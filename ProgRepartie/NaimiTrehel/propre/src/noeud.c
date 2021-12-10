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
#define EXIT_ARGUMENT_ERROR 1
#define EXIT_SUCCES 0

#define TRACE 1
// if(TRACE) {printf("");}


/*
    Fonction liee a l'écoute sur la socket
*/
void * ecoute (void * params){
    struct param * args = (struct param *) params;
    if(TRACE) {printf("     Ecoute : Je commence mon calcul !\n");}
    calcul(2);
    if(TRACE) {printf("     Ecoute : Je termine mon calcul !\n");}

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
	*/ 
	int jeton = 0;

    struct sockaddr_in test_pere = getSockAddr(argv[1], atoi(argv[2]));
    //struct sockaddr_in test_next = getSockAddr()

    // PAS DE STRING PELO  https://www.gta.ufrj.br/ensino/eel878/sockets/sockaddr_inman.html
    identificateur pere;
    strncpy(pere.ip, argv[1], sizeof(argv[1])+1) ;
    strncpy(pere.port, argv[2], sizeof(argv[2])+1) ;
    pere.ip[sizeof(argv[1])+1] = '\0';
    pere.port[sizeof(argv[2])+1] = '\0';
    
    identificateur next;
    strncpy(next.ip, "", 0) ;
    strncpy(next.port, "", 0) ;
 	/*
		VARIABLES IMPORTANTES DU PROGRAMME
	*/
    if(TRACE){printf("Jeton : %i \nPere : %s : %s \nNext : %s : %s\n", jeton, pere.ip, pere.port, next.ip, next.port);}


    param p;     p.jeton = jeton;   p.pere = pere;     p.next = next;
    pthread_t t_ecoute;
    if (pthread_create(&t_ecoute, NULL, ecoute, (void*) &p) != 0){
        perror("Erreur creation du thread d'ecoute : ");
        exit(THREAD_CREATION_ERROR);
    }
    if(TRACE) {printf("Thread d'écoute crée !\n");}



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

    // Join ?? Ou un kill(9)
    pthread_join(t_ecoute, NULL);
    exit(EXIT_SUCCES);
}