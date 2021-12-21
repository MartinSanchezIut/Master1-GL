#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <pthread.h>
#include <sys/time.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <sys/select.h>
#include <time.h>
#include <netdb.h>

/*
Définition des structures de données,
    message représente un message envoyé sur le réseau.
    param représente les parametres a envoyer au thread d'écoute, c'est a dire les variables du programe principal
*/
typedef struct message message;
typedef struct param param;

struct message{
    int type;
    /*
    Type = 0 : Demande pour devenir la racine
    Type = 1 : Envoi de token, pour entrer en section critique
    Type = 2 : L'ex racine me previens que je suis la nouvelle racine
    */
    struct sockaddr_in contenu;
    /*
    Qui suis-je ? Mon ip, et mon port d'écoute.
    */
};

struct param{
    int* condBoucle;
    pthread_mutex_t* jeton;
    struct sockaddr_in *pere; 
    struct Stack *next; 

    int portEcoute;
    int socketEnvoi;
};


int recvTCP(int socket, message *buffer, size_t length){
	size_t received ;
	size_t totalRCV = 0;
	unsigned int cptrRCV = 0;
	while (totalRCV < length){
		received = recv(socket, buffer + totalRCV, length - totalRCV, 0);
		cptrRCV++;
		if (received <= 0){
			return received;
		}
		totalRCV += received;
	}
	return received;
}

int sendTCP(int socket, message *buffer, size_t length){
	size_t sent;
	size_t totalSent = 0;
	unsigned int cptrSend = 0;
	while (totalSent < length)	{
		sent = send(socket, buffer + totalSent, length - totalSent, 0);
		cptrSend++;
		if (sent <= 0)		{
			return sent;
		}
		totalSent += sent;
	}
	return sent;
}

int AttendreMessage(int socket, message *msg) {
    message mess ;
    int cbRead = recvTCP(socket, &mess, sizeof(mess));
    if( cbRead < 0 ){
        perror("recvfrom() error: ");
        return -1;
    }
    msg->type = mess.type;
    msg->contenu = mess.contenu;
    return cbRead;
}

int EnvoyerMessage(int socket, struct sockaddr_in dest, message msg){
    int nbSend = sendTCP(socket, &msg, sizeof(msg)) ;
    if(nbSend < 0 ){
        perror("sendto() error: ");
        return -1;
    }
    return nbSend;
}

int EnvoyerToken(pthread_mutex_t* jeton, int socket, struct sockaddr_in dest){
    pthread_mutex_unlock(jeton);
    message msg; memset(&msg, 0, sizeof(msg));
    msg.type  = 1;
    //msg.contenu = NULL;
    int nbSend = sendTCP(socket, &msg, sizeof(msg)) ;
    if(nbSend < 0 ){
        perror("sendto() error: ");
        return -1;
    }
    // A VERIFIER !!!!
    pthread_mutex_lock(jeton);

    return nbSend;
}

pthread_mutex_t initToken(struct sockaddr_in me, struct sockaddr_in pere) {
    pthread_mutex_t jeton = PTHREAD_MUTEX_INITIALIZER;
    // On va verifier si je suis la racine : pere = moi
    if ((me.sin_port == pere.sin_port) && (me.sin_addr.s_addr == pere.sin_addr.s_addr)) {
        pthread_mutex_unlock(&jeton);
    }else {
        pthread_mutex_lock(&jeton);
    }
    return jeton;
}

void attendreToken(pthread_mutex_t* jeton) {
    pthread_mutex_lock(jeton);
}

struct sockaddr_in getSockAddr(char ip[], int port) {
    struct sockaddr_in myaddr;
    myaddr.sin_family = AF_INET;
    myaddr.sin_port = htons(port);
	if (inet_pton(AF_INET, ip, &(myaddr.sin_addr)) < 1)	{
		perror("client: inet_pton() error ->");
	}
    return myaddr;
}

time_t getTime() {
    time_t seconds;
    time(&seconds);
    return seconds-1639476053-616814;
}