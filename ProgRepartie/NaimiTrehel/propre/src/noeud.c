#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <netdb.h>
#include "../h/naimi.h"
#include "../h/calcul.h"

#define THREAD_CREATION_ERROR 11
#define WAIT_MESSAGE_FAIL 12
#define EXIT_ARGUMENT_ERROR 1

#define EXIT_SUCCES 0

#define TRACE 1
// if(TRACE) {printf("");}


/*
    Fonction liee a l'écoute sur la socket
*/
void * ecoute (void * params){
    param * args = (struct param *) params;

    if(TRACE) {printf("     Ecoute: Thread d'écoute crée !\n");}
    if(TRACE) {printf("-*-*-*-*-*-*-*-*-*-*-\n");}
    if(TRACE){printf("Ecoute:\nJeton : %i \ncondBoucle %i\nPere : (%d) : (%d) \nNext : %d : %d\n", 
        *args->jeton, *args->condBoucle, args->pere->sin_addr.s_addr, 
        args->pere->sin_port, args->next->sin_addr.s_addr, args->next->sin_port);}
    if(TRACE) {printf("-*-*-*-*-*-*-*-*-*-*-\n");}


    // Creation du socket d'ecoute
    int sock;
    struct sockaddr_in serveraddr = getSockAddr("127.0.0.1", args->portEcoute);
    if ((sock = socket(AF_INET, SOCK_DGRAM, 0)) < 0 ) {
         perror("Erreur socket ecoute:"); exit(1);}

    if ( bind(sock, (const struct sockaddr *)&serveraddr, sizeof(serveraddr)) < 0 ){ 
        perror("Erreur bind ecoute: "); exit(1);}

    /*
        Ici on veut boucler tant que le programe principal tourne,
        Ecouter les messages recus, et les traiter
    */
    while (! *args->condBoucle){
        message msg;
        if (AttendreMessage(sock, &msg) < 0) {
            perror("Erreur dans l'attente de msg: ");
            exit(WAIT_MESSAGE_FAIL);
        }
        printf( "Msg recu: Message=%i, (%d) : (%d) \n", 
            msg.type, msg.contenu.sin_addr.s_addr, msg.contenu.sin_port );
   
        
        if(TRACE) {printf("     Ecoute : Je commence mon calcul !\n");}
        calcul(2);
        if(TRACE) {printf("     Ecoute : Je termine mon calcul !\n");}
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
	*/ 
    int condBoucle = 0;
	int jeton = 0;
    struct sockaddr_in pere = getSockAddr(argv[1], atoi(argv[2]));
    struct sockaddr_in next ;
 	/*
		VARIABLES IMPORTANTES DU PROGRAMME
	*/
    if(TRACE) {printf("-*-*-*-*-*-*-*-*-*-*-\n");}
    if(TRACE){printf("Main:\nJeton : %i \nPere : %s(%d) : %s(%d) \nNext : %d : %d\n", 
        jeton, argv[1], pere.sin_addr.s_addr, argv[2], pere.sin_port, next.sin_addr.s_addr, next.sin_port);}
    if(TRACE) {printf("-*-*-*-*-*-*-*-*-*-*-\n");}


    // Creation du thread d'ecoute
    param p;     
    p.condBoucle = &condBoucle;     
    p.jeton = &jeton;   
    p.pere = &pere;    
    p.next = &next;
    p.portEcoute = atoi(argv[3]);
    pthread_t t_ecoute;
    if (pthread_create(&t_ecoute, NULL, ecoute, (void*) &p) != 0){
        perror("Erreur creation du thread d'ecoute : ");
        exit(THREAD_CREATION_ERROR);
    }



    // PROGRAMME PRINCIPAL :
    if(TRACE) {printf("Main : Je commence mon calcul !\n");}
    calcul(5);
    if(TRACE) {printf("Main : Je termine mon calcul !\n");}

    /*                                         

    continuer;      // Du code sans importance

    p_thrad_mutex_wait(jeton) ;  // J'attend le jeton
    nanani du code chiant       // J'execute mon code critique
    envoyerJeton(next) ;       // J'envoie le jeton a mon suivant

    continuer;      // Du code sans importance

    p_thrad_mutex_wait(jeton) ;  // J'attend le jeton
    nanani du code chiant       // J'execute mon code critique
    envoyerJeton(next) ;       // J'envoie le jeton a mon suivant

    continuer;      // Du code sans importance
    */



    // Permet de mettre fin a la boucle du thread d'ecoute
    condBoucle = 1;
    // Join ?? Ou un kill(9)
    pthread_join(t_ecoute, NULL);
    exit(EXIT_SUCCES);
}