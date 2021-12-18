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
#include "../h/naimi.h"
#include "../h/calcul.h"

int main(int argc, char *argv[]) {
    if (argc != 3)  {
        printf("utilisation : sender port_recept type_msg\n");
        exit(1);
    }

    int sock;
    struct sockaddr_in serveraddr = getSockAddr("127.0.0.1", atoi(argv[1]));
    if ((sock = socket(AF_INET, SOCK_DGRAM, 0)) < 0 ) {
         perror("Erreur socket ecoute:"); exit(1);}

    message msg;
    msg.type = atoi(argv[2]) ;
    msg.contenu = getSockAddr("192.168.0.0", 1568) ;

    int ret = EnvoyerMessage(sock, serveraddr, msg);

    printf( "Msg envoye: Message=%i, (%d) : (%d) \n", 
    msg.type, msg.contenu.sin_addr.s_addr, msg.contenu.sin_port );

    printf("Val de retour de l'envoie : %i \n", ret) ;

    exit(0) ;
}