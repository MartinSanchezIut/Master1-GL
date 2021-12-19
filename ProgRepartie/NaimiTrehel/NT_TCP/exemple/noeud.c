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
#include <netdb.h>
#include <time.h>
#include "../h/naimi.h"
#include "../h/calcul.h"
#include "../h/stack.h"



#define THREAD_CREATION_ERROR 11
#define WAIT_MESSAGE_FAIL 12
#define SOCKET_ERROR 13
#define CONNECT_ERROR 14
#define EXIT_ARGUMENT_ERROR 1

#define EXIT_SUCCES 0

#define TRACE 1
// if(TRACE) {printf("");}


/*
    Fonction liee a l'écoute sur la socket
*/
void * ecoute (void * params){
    param * args = (struct param *) params;

    struct sockaddr_in moi = getSockAddr("127.0.0.1", args->portEcoute);


    if(TRACE) {printf("     Ecoute: Thread d'écoute crée !\n");}
    printf("-*-*-*-*-*-*-*-*-*-*-\n");
    printf("Ecoute:\nMoi : %d : %d \nPere : (%d) : (%d) \n", 
        moi.sin_addr.s_addr, moi.sin_port, 
        args->pere->sin_addr.s_addr, args->pere->sin_port);
    printf("-*-*-*-*-*-*-*-*-*-*-\n");


    // Creation du socket d'ecoute
    int sock;
    if ((sock = socket(AF_INET, SOCK_STREAM, 0)) < 0 ) {
         perror("Erreur socket ecoute:"); close(sock); exit(SOCKET_ERROR);}
    if ( bind(sock, (const struct sockaddr *)&moi, sizeof(moi)) < 0 ){ 
        perror("Erreur bind ecoute: "); close(sock); exit(SOCKET_ERROR); }
	if (listen(sock, 10) < 0)	{
		perror("Erreur listen ecoute: \n"); close(sock); exit(SOCKET_ERROR); }
	if(TRACE) {printf("     Ecoute: Thread d'écoute en ecoute !\n");}


    // Petit bout de code pour que "AttendreMessage" ne bloque pas infiniment, Timeout = 60sec
    struct timeval tv;
    tv.tv_sec = 40;
    tv.tv_usec = 0;
    if (setsockopt(sock, SOL_SOCKET, SO_RCVTIMEO,&tv,sizeof(tv)) < 0) {
        printf("     Ecoute: delai d'attente expire\n");
        pthread_exit(NULL);
    }

    /*
        Ici on veut boucler tant que le programe principal tourne,
        Ecouter les messages recus, et les traiter
    */
    // DEBUT DU MULTIPLEXAGE
	fd_set set ;
	fd_set settmp ;

	FD_ZERO(&set);
	FD_SET(sock, &set);

	int max = sock;
    while (! *args->condBoucle){
        settmp = set;
		select(max+1, &settmp, NULL, NULL, NULL);

        for (int df = 2; df <= max; df++){
            if (!FD_ISSET(df, &settmp)) {
                //printf("Serveur : !ISSET\n"); 
                continue;
            }

            if(df == sock) {
				struct sockaddr_in adCv;
				socklen_t lgCv = sizeof(struct sockaddr_in);

				int dSC = accept(sock, (struct sockaddr *)&adCv, &lgCv);
				if (dSC < 0) {perror("Erreur d'accept ecoute: ") ;continue; }

				if (TRACE) {printf("     Serveur : le client %s:%d est connecté  \n", inet_ntoa(adCv.sin_addr), ntohs(adCv.sin_port));}
				FD_SET(dSC, &set) ;
				if (max < dSC) max = dSC;
				continue;
			} 

            message msg;
            if (AttendreMessage(df, &msg) < 0) {
                perror("Erreur dans l'attente de msg: \n");
                FD_CLR(df, &set);
				close(df);
                continue;
            }		

            if(TRACE) { printf("    Msg recu: Message=%i, (%d) : (%d) \n", msg.type, msg.contenu.sin_addr.s_addr, msg.contenu.sin_port );}

            switch (msg.type){
            case 0:
                /*
                    Ici j'ai reçu une demande  pour devenir racine
                    A faire: si pere = moi-meme
                                next =  contenu
                                pere = contenu
                            sinon 
                                envoyer le message a pere
                                pere = contenu
                */     

               /*
                int conn = connect(df, (struct sockaddr *)&args->pere, sizeof(args->pere));
                if (conn < 0)	{
                    perror("Ecoute: pb au connect :");
                    FD_CLR(df, &set);
                    close(df);
                    continue;
                }
               */         
                if ((moi.sin_port == args->pere->sin_port) && (moi.sin_addr.s_addr == args->pere->sin_addr.s_addr)) {
                    push(args->next, msg.contenu);
                    *args->pere = msg.contenu ;

                    message msg1; msg1.type = 2; msg1.contenu = moi;
                    printf("Envoie de message pour passer la main ! \n");
                    EnvoyerMessage(df, *args->pere,  msg1);
                }else {
                    printf("Envoie de message transmettre ! \n");
                    EnvoyerMessage(df, *args->pere,  msg);
                    *args->pere = msg.contenu ;
                }
                printf("    Ecoute: Demande d'acces a la racine\n") ;
                printf("-*-*-*-*-*-*-*-*-*-*-\n");
                printf("Ecoute:\nMoi : %d : %d \nPere : (%d) : (%d) \n", 
                    moi.sin_addr.s_addr, moi.sin_port, 
                    args->pere->sin_addr.s_addr, args->pere->sin_port);
                printf("-*-*-*-*-*-*-*-*-*-*-\n");

                FD_CLR(df, &set);
			    close(df);
                break;
            case 1:
                /*
                    Ici on m'envoie le token
                    A faire: envoyer un signal sur le mutex pour debloquer le prog principal
                */
                printf("    Ecoute: J'ai le token !\n\n");
                pthread_mutex_unlock(args->jeton);
                FD_CLR(df, &set);
			    close(df);
                break;
            case 2:
                /*
                    Ce message permet de prévenir le demandeur de racine qu'il 
                    est la nouvelle racine
                */
                *args->pere = moi ;
                printf("     Ecoute: Je suis la nouvelle racine! \n\n");    
                FD_CLR(df, &set);
			    close(df);
                break; 
            default:
                printf("    Ecoute: Type de message inconnu ...\n\n") ;
                FD_CLR(df, &set);
			    close(df);
                break;
            }
        }
    }
    close(sock);
    pthread_exit(NULL);
}

/*
int Main(int argc, char *argv[]) :
    utilisation : ./noeud ip_pere port_pere mon_port
    
        ip_pere : ip du pere
        port_pere : port d'écoute du pere
        mon_port : mon port d'écoute
*/
int main(int argc, char *argv[]) {
    if (argc != 4)  {
        printf("utilisation : client ip_serveur port_serveur mon_port\n");
        exit(EXIT_ARGUMENT_ERROR);
    }
    /*
		VARIABLES IMPORTANTES DU PROGRAMME
            https://www.gta.ufrj.br/ensino/eel878/sockets/sockaddr_inman.html
            https://www.geeksforgeeks.org/stack-data-structure-introduction-program/
	*/ 
    int condBoucle = 0;
    struct sockaddr_in moi = getSockAddr("127.0.0.1", atoi(argv[3]));

    struct sockaddr_in pere = getSockAddr(argv[1], atoi(argv[2]));
    struct Stack *next = createStack(10) ;
    pthread_mutex_t jeton = initToken(moi, pere);
 	/*
		VARIABLES IMPORTANTES DU PROGRAMME
	*/
    if(TRACE) {printf("-*-*-*-*-*-*-*-*-*-*-\n");}
    if(TRACE){printf("Main:\nMoi : %d : %d \nPere : %s(%d) : %s(%d) \n", 
        moi.sin_addr.s_addr, moi.sin_port, 
        argv[1], pere.sin_addr.s_addr, argv[2], pere.sin_port);}
    if(TRACE) {printf("-*-*-*-*-*-*-*-*-*-*-\n");}


    // Creation du thread d'ecoute
    param p;     
    p.condBoucle = &condBoucle;     
    p.jeton = &jeton;   
    p.pere = &pere;    
    p.next = next;
    p.portEcoute = atoi(argv[3]);
    pthread_t t_ecoute;
    if (pthread_create(&t_ecoute, NULL, ecoute, (void*) &p) != 0){
        perror("Erreur creation du thread d'ecoute : ");
        exit(THREAD_CREATION_ERROR);
    }

    // Creation du socket d'envoi de messages
    int sock;
    if ((sock = socket(AF_INET, SOCK_STREAM, 0)) < 0 ) {
         perror("Erreur socket d'envoi:"); exit(SOCKET_ERROR);}

 
 
        
            // PROGRAMME PRINCIPAL :
            calcul(1) ;

            message msg;
            msg.type = 0;
            msg.contenu = getSockAddr("127.0.0.1", atoi(argv[3]));

            int conn = connect(sock, (struct sockaddr *)&pere, sizeof(pere));
            if (conn < 0)	{
                perror("Ecoute: pb au connect :");
                exit(CONNECT_ERROR);
            }
            EnvoyerMessage(sock, pere, msg)  ;

            attendreToken(&jeton);
            printf("%ld - Main : Je commence mon calcul !\n", getTime() ) ;
            calcul(15);
            printf("%ld - Main : Je termine mon calcul !\n", getTime() );

            if (!isEmpty(next)) {
                EnvoyerToken(&jeton, sock, pop(next)) ;
            }else {
                printf("Je n'ai pas de next ... \n");
            }
   


    // Permet de mettre fin a la boucle du thread d'ecoute
    condBoucle = 1;
    pthread_join(t_ecoute, NULL);
    exit(EXIT_SUCCES);
}