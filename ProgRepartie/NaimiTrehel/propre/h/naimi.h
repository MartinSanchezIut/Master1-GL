#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <netdb.h>

/*
Définition des structures de données,
    identificateur représente une noeud, définit par son ip et son port d'écoute.
    message représente un message envoyé sur le réseau.
    param représente les parametres a envoyer au thread d'écoute, c'est a dire les variables du programe principal
*/
typedef struct identificateur identificateur;
typedef struct message message;
typedef struct param param;

struct identificateur{
    char ip[16];      // 255.255.255.255
    char port[16];   // 5566xx    UN INT
};

struct message{
    int type;
    /*
    Type = 0 : Demande pour devenir la racine
    Type = 1 : Envoi de token, pour entrer en section critique
    */
    struct sockaddr_in contenu;
    /*
    Qui suis-je ? Mon ip, et mon port d'écoute.
    */
};

struct param{
    int* condBoucle;
    int* jeton;
    struct sockaddr_in *pere; 
    struct sockaddr_in *next; 

    int portEcoute;
};


int AttendreMessage(int socket, message *msg) {
    message mess ;
    int cbRead = recvfrom(socket, &mess, sizeof(mess), 0, NULL, 0);
    if( cbRead < 0 ){
        perror("recvfrom() error: ");
        return -1;
    }
    msg->type = mess.type;
    msg->contenu = mess.contenu;
    return cbRead;
}
int EnvoyerMessage(int socket, struct sockaddr_in dest, message msg){
    int nbSend = sendto(socket, &msg, sizeof(msg), 0, (struct sockaddr*) &dest, sizeof(dest)) ;
    if(nbSend < 0 ){
        perror("sendto() error: ");
        return -1;
    }
    return nbSend;
}
int EnvoyerToken(int socket, struct sockaddr_in dest){
    message msg;
    msg.type  = 1;
    msg.contenu = ?????;
    int nbSend = sendto(socket, &msg, sizeof(msg), 0, (struct sockaddr*) &dest, sizeof(dest)) ;
    if(nbSend < 0 ){
        perror("sendto() error: ");
        return -1;
    }
    return nbSend;
}

struct sockaddr_in getSockAddr(char ip[], int port) {
    struct sockaddr_in myaddr;
    myaddr.sin_family = AF_INET;
    myaddr.sin_port = htons(port);
    inet_aton(ip, &myaddr.sin_addr.s_addr); 
    return myaddr;
}

