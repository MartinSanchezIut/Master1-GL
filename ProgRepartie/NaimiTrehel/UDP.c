#include <stdio.h>
#include <sys/types.h>
#include <netdb.h>
#include <arpa/inet.h>
#include <sys/socket.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <string.h>


typedef struct identificateur identificateur;
typedef struct message message;

struct identificateur{
    char ip[16];      // 255.255.255.255
    char port[16];   // 5566xx
};

struct message{
    int type;
    identificateur contenu;
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
    identificateur pere;
    strncpy(pere.ip, argv[1], sizeof(argv[1])+1) ;
    strncpy(pere.port, argv[2], sizeof(argv[2])+1) ;
    identificateur next;
    strncpy(next.ip, "", 0) ;
    strncpy(next.port, "", 0) ;
 	/*
		VARIABLES IMPORTANTES DU PROGRAMME
	*/ 

    int sock, sock2;
    message bufferout;
    message bufferin;
    struct sockaddr_in servaddr, cliaddr;
    int status;

    if ((sock = socket(AF_INET, SOCK_DGRAM, 0)) < 0 ) { perror("Erreur socket:"); exit(1); }
    memset(&servaddr, 0, sizeof(servaddr)); memset(&cliaddr, 0, sizeof(cliaddr));
    servaddr.sin_family = AF_INET;        
    servaddr.sin_addr.s_addr = INADDR_ANY;
    servaddr.sin_port = htons((short) atoi(argv[3]));     // Ouvrir sur le port passé dans la commande

    if ( bind(sock, (const struct sockaddr *)&servaddr, sizeof(servaddr)) < 0 ){ perror("Erreur bind"); exit(1);}
    
    int cbRead, nbSend;
    switch(fork()) {
        case -1:
            perror("Erreur de fork\n");
            exit(1);
        case 0: // Fils
            cbRead = recvfrom(sock, &bufferin, sizeof(bufferin), 0, NULL, 0);
            if( cbRead < 0 ){perror("recvfrom() error ");exit(1);}

	        printf( "recvfrom()=>cbRead=%d, Message=%i, %s : %s \n", cbRead, bufferin.type,
                                                                             bufferin.contenu.ip,
                                                                             bufferin.contenu.port );
            break;
        default: // Pere
            if ((sock2 = socket(AF_INET, SOCK_DGRAM, 0)) < 0 ) { perror("Erreur socket2:"); exit(1); }


            cliaddr.sin_family = AF_INET;        
            cliaddr.sin_addr.s_addr = inet_addr(pere.ip);
            cliaddr.sin_port = htons((short) atoi(pere.port));  
           // if ( bind(sock2, (const struct sockaddr *)&cliaddr, sizeof(cliaddr)) < 0 ){ perror("Erreur bind"); exit(1);}
        

            bufferout.type = 1;    
            strcpy(bufferout.contenu.ip, "Coucou") ;
            strcpy( bufferout.contenu.port, "cava") ;
            
            nbSend = sendto(sock2, &bufferout, sizeof(bufferout), 0, (struct sockaddr*) &cliaddr, sizeof(cliaddr)) ;
            if(  nbSend == -1 ){perror("send to error ");exit(1);}

	        printf( "sendto()=>cbRead=%d, Message=%i, %s : %s \n", nbSend,  bufferout.type,
                                                                            bufferout.contenu.ip,
                                                                            bufferout.contenu.port );

            wait(&status);
            break;
        }
 //   close(sock);
	printf("Fin du noeud\n");  
}
