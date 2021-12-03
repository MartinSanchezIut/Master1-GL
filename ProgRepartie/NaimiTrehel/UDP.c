#include <stdio.h>
#include <sys/types.h>
#include <netdb.h>
#include <arpa/inet.h>
#include <sys/socket.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <string.h>

struct identificateur{
    char ip[16];    // 255.255.255.255
    char port[6]; //5566xx
};

struct message{
    int type;
    struct identificateur contenu;
};

int main(int argc, char *argv[]) {
	if (argc != 4)	{
		printf("utilisation : client ip_serveur port_serveur mon_port\n");
		exit(0);
	}

  	/*
		VARIABLES IMPORTANTES DU PROGRAMME
	*/ 
	int jeton = 0;
    struct identificateur pere;
    strcpy(argv[1], pere.ip) ;
    strcpy(argv[2], pere.port) ;

    struct identificateur next;
    strcpy("", next.ip) ;
    strcpy("", next.port) ;


    int sock;
    int sock2;
    struct message buffer;
    struct sockaddr_in servaddr, cliaddr;

    int status;

    if ((sock = socket(AF_INET, SOCK_DGRAM, 0)) < 0 ) { perror("Erreur socket:"); exit(EXIT_FAILURE); }
    
    memset(&servaddr, 0, sizeof(servaddr)); memset(&cliaddr, 0, sizeof(cliaddr));
    
    servaddr.sin_family = AF_INET;
    servaddr.sin_addr.s_addr = INADDR_ANY;
    servaddr.sin_port = htons(argv[3]);  // Ouvrir sur le port passé dans la commande

    if ( bind(sock, (const struct sockaddr *)&servaddr, sizeof(servaddr)) < 0 ){ perror("Erreur bind"); exit(EXIT_FAILURE);}



    switch(fork()) {
        case -1:
            perror("Erreur de fork\n");
            exit(1);
        case 0: // Fils
            //printf("Je suis le thread qui attends les messages\n");
            rcv_from() 

            


            // Ecouter sur le socket

            close(sock);
            break;
        default: // Pere

          
            sendto(sock,(const struct message *)buffer , MSG_CONFIRM,strlen(buffer),(const struct sockaddr *)&servaddr,sizeof(servaddr));


            getifaddrs() 
            while()







            wait(&status);
            break;
        }


	printf("Fin du noeud\n");  
}
