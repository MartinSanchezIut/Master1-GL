#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <netdb.h>

typedef struct identificateur identificateur;
typedef struct message message;

struct identificateur{
    char ip[16];      // 255.255.255.255
    char port[16];   // 5566xx
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

void * server (void * params){
    //On cast notre params dans la bonne structure, et puis on lui donne une nouvelle variable pour y accéder
    struct message * args = (struct message *) params;
    int sock;
    struct sockaddr_in servaddr;
    int status;
    int cbRead, nbSend;
    message bufferin;

    if ((sock = socket(AF_INET, SOCK_DGRAM, 0)) < 0 ) { perror("Erreur socket:"); exit(1); }
        printf("socket créer");

    memset(&servaddr, 0, sizeof(servaddr));
    servaddr.sin_family = AF_INET;        
    servaddr.sin_addr.s_addr = htonl(INADDR_ANY);
    servaddr.sin_port = htons((short) atoi(args->contenu.port));     // Ouvrir sur le port passé dans la commande
    printf("port : %d" ,(short) atoi(args->contenu.port));
    if ( bind(sock, ( struct sockaddr *)&servaddr, sizeof(servaddr)) < 0 ){ perror("Erreur dans ce bind"); exit(1);}

    cbRead = recvfrom(sock, &bufferin, sizeof(bufferin), 0, NULL, 0);
                       printf("%i\n",cbRead);
    if( cbRead < 0 ){perror("recvfrom() error ");exit(1);}
    close(sock);
    printf( "recvfrom()=>cbRead=%d, Message=%i, %s : %s \n", cbRead, bufferin.type,
                                                                bufferin.contenu.ip,
                                                                bufferin.contenu.port );
    pthread_exit(NULL);
}

void * ecoute (void * params){
    int cbRead, nbSend;
    //On cast notre params dans la bonne structure, et puis on lui donne une nouvelle variable pour y accéder
    struct message * args = (struct message *) params;
    int status;
    int sock2;
    message bufferout;
    struct sockaddr_in cliaddr;
    identificateur pere;

    strncpy(pere.ip, args->contenu.ip, sizeof(args->contenu.ip)+1) ;
    strncpy(pere.port,  args->contenu.port, sizeof(args->contenu.port)+1) ;

   
    cliaddr.sin_family = AF_INET;     
    cliaddr.sin_addr.s_addr = inet_addr(pere.ip);  
    cliaddr.sin_port = htons((short) atoi(pere.port)); 
    if ((sock2 = socket(AF_INET, SOCK_DGRAM, 0)) < 0 ) { perror("Erreur socket2:"); exit(1); }
    // if ( bind(sock2, (const struct sockaddr *)&cliaddr, sizeof(cliaddr)) < 0 ){ perror("Erreur bind"); exit(1);}

    bufferout.type = 1;    
    strcpy(bufferout.contenu.ip, "Coucou") ;
    strcpy( bufferout.contenu.port, "cava") ;
    nbSend = sendto(sock2, &bufferout, sizeof(bufferout), 0, (struct sockaddr*) &cliaddr, sizeof(cliaddr)) ;
    if(  nbSend == -1 ){perror("send to error ");exit(1);}
        close(sock2);

    printf( "sendto()=>cbRead=%d, Message=%i, %s : %s \n", nbSend,  bufferout.type,
                                                                    bufferout.contenu.ip,
                                                                    bufferout.contenu.port );

    wait(&status);
    pthread_exit(NULL);
}


int main(int argc, char *argv[]) {
    if (argc != 4)  {
        printf("utilisation : client ip_serveur port_serveur mon_port\n");
        exit(0);
    }

    int jeton = 0;
    identificateur next;
    strncpy(next.ip, "", 0) ;
    strncpy(next.port, "", 0) ;
    message bufferin;
    bufferin.type = 1;    

    strcpy(bufferin.contenu.ip, "Coucou") ;
    strcpy( bufferin.contenu.port, argv[3]) ;

    pthread_t servers;
    if (pthread_create(&servers, NULL, server, (void*) &bufferin) != 0){
        perror("erreur creation thread");
        exit(1);
    }

    printf("Thread créer\n");
    message bufferout;
    bufferout.type = 1;    
    strcpy(bufferout.contenu.ip, argv[1]) ;
    strcpy( bufferout.contenu.port, argv[2]) ;

    pthread_t client;
    if (pthread_create(&client, NULL, ecoute, (void*) &bufferout) != 0){
        perror("erreur creation thread");
        exit(1);
    }

    printf("Thread créer\n");

    if(pthread_join(servers, NULL) != 0) {
        perror("erreur join thread");
        exit(1);
    };
}

