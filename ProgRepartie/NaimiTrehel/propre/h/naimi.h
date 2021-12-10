#include <stdio.h>

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
    identificateur contenu;
    /*
    Qui suis-je ? Mon ip, et mon port d'écoute.
    */
};

struct param{
    int jeton;
    identificateur pere; 
    identificateur next; 
};


struct message AttendreMessage(int socket) {

}

struct sockaddr_in getSockAddr(char ip[], int port) {
    struct sockaddr_in myaddr;
    myaddr.sin_family = AF_INET;
    myaddr.sin_port = htons(port);
    inet_aton(ip, &myaddr.sin_addr.s_addr); 

    /*
    int s = socket(PF_INET, SOCK_STREAM, 0);
    bind(s, (struct sockaddr_in*) myaddr, sizeof(myaddr));
    close(s);
    */
    return myaddr;
}

