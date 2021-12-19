#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <netdb.h>
#include <time.h>
#include <sys/select.h>
#include "../h/naimi.h"
#include "../h/calcul.h"

int main(int argc, char *argv[]) {
    if (argc != 3)  {
        printf("utilisation : sender port_recept type_msg\n");
        exit(1);
    }

    int sock;
    struct sockaddr_in serveraddr = getSockAddr("127.0.0.1", atoi(argv[1]));
    if ((sock = socket(AF_INET, SOCK_STREAM, 0)) < 0 ) {
         perror("Erreur socket ecoute:"); exit(1);}

    //printf("\n %d : %s : %ld \n", sock, &serveraddr, sizeof(serveraddr));
    int conn = connect(sock, (struct sockaddr *)&serveraddr, sizeof(serveraddr));
	if (conn < 0)	{perror("Client: pb au connect :");close(sock);exit(1);}
    printf("Connecté au serveur \n");

    message msg;
    msg.type = atoi(argv[2]) ;
    msg.contenu = getSockAddr("192.168.0.0", 1568) ;

    //int ret = sendTCP(sock, &msg, sizeof(msg));
    int ret = EnvoyerMessage(sock, serveraddr, msg);

    printf( "Msg envoye: Message=%i, (%d) : (%d) \n", 
    msg.type, msg.contenu.sin_addr.s_addr, msg.contenu.sin_port );

    printf("Val de retour de l'envoie : %i \n", ret) ;

    exit(0) ;
}