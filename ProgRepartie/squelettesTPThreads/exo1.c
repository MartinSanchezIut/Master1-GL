#include <string.h>
#include <stdio.h>//perror
#include <sys/types.h>
#include <stdlib.h>
#include <unistd.h>
//#include <iostream>
#include <pthread.h>
#include "../calcul.h"


// BOn le coucou bug un peut mais c'est dans l'exo 3 alors tant pis

struct paramsFonctionThread {
	int idThread;
	// si d'autres param�tres, les ajouter ici.
	int temps;

	int varamodif;
};


void * fonctionThread (void * params){
	struct paramsFonctionThread * args = (struct paramsFonctionThread *) params;

	pthread_t moi = pthread_self();
	int id = args->idThread ;
	printf("Mon thread : %li (%i)  proc.  %i  \n", moi, id, getpid());

	calcul(args->temps); 

	(args->varamodif)++; 
	printf("coucou: %i \n", args->varamodif);

	printf("Mon thread : FIN \n");
	pthread_exit(NULL);
}


int main(int argc, char * argv[]){
	if (argc < 2 ){
		printf("utilisation: %s  nombre_threads  \n", argv[0]);
		return 1;
	}     
	int coucou = 2;
	pthread_t threads[atoi(argv[1])];
	struct paramsFonctionThread parameters[atoi(argv[1])];

	// cr�ation des threards 
	for (int i = 0; i < atoi(argv[1]); i++){

		// Le passage de param�tre est fortement conseill� (�viter les
		// variables globles).

		// compl�ter pour initialiser les param�tres
		//struct paramsFonctionThread par = parameters[i];
		parameters[i].idThread = i;
		parameters[i].temps = i;
		parameters[i].varamodif = coucou;

//	printf("Creation de %i, temps = %i, var = %i \n", par.idThread, par.temps, par.varamodif);
		if (pthread_create(&threads[i], NULL, fonctionThread, &parameters[i]) != 0){
			perror("erreur creation thread");
			exit(1);
		}
	}

	for (int i = 0; i < atoi(argv[1]); i++){
		int res = pthread_join(threads[i], NULL);
	}

	printf("coucou: %i \n", coucou);

	// garder cette saisie et modifier le code en temps venu.
	char c; 
	printf("saisir un caract�re \n");
	fgets(&c, 1, 0);

	return 0;
}

