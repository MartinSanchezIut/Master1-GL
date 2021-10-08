//#include <iostream>
#include <sys/types.h>
#include <pthread.h>
#include <unistd.h>
#include "../calcul.h"
#include <stdlib.h>
#include <stdio.h>

struct predicatRdv {
  int x;
  int seuil;
  pthread_mutex_t mutex;
  pthread_cond_t cond;
};

struct params {
  // structure pour regrouper les param�tres d'un thread. 
  int idThread; // un identifiant de thread, de 1 � N (N le nombre
		// total de theads secondaires
  struct predicatRdv * varPartagee;
};

// fonction associ�e a chaque thread participant au RdV.
void * participant (void * p){ 
  struct params * args = (struct params *) p;
  struct predicatRdv * predicat = args -> varPartagee;

  
  // simulation d'un long calcul pour le travail avant RdV
  calcul(args->idThread + rand() % 10); // c'est un exemple.

  // RdV 
  pthread_mutex_lock(&predicat->mutex);

  while (predicat->x < predicat->seuil) {  // attention : le dernier arriv� ne doit pas attendre. Il doit r�veiller tous les autres.
    pthread_cond_wait(&predicat->cond, &predicat->mutex);
  }
// prevenir les autres

  calcul(2); // reprise et poursuite de l'execution.

  pthread_exit(NULL); // fortement recommand�.
}




int main(int argc, char * argv[]){
  if (argc!=2) {
    printf("argument requis \n");
    printf("./prog nombre_Threads \n");
    exit(1);
  }
 
  // initialisations 
  pthread_t threads[atoi(argv[1])];
  struct params tabParams[atoi(argv[1])];




  struct predicatRdv var;
  var.x = 15;
  var.seuil = 20;
  pthread_mutex_init(&var.mutex, NULL);
  pthread_cond_init(&var.cond, NULL);


  srand(atoi(argv[1]));  // initialisation de rand pour la simulation de longs calculs

  // cr�ation des threards 
  for (int i = 0; i < atoi(argv[1]); i++){
    tabParams[i].idThread = i;
    tabParams[i].varPartagee = &var; 
    if (pthread_create(&threads[i], NULL, participant, &tabParams[i]) != 0){
      perror("erreur creation thread \n");
      exit(1);
    }
  }

  // attente de la fin des  threards. Partie obligatoire 
  for (int i = 0; i < atoi(argv[1]); i++){
		int res = pthread_join(threads[i], NULL);
  }
  printf("thread principal : fin de tous les threads secondaires \n");

  // terminer "proprement". 
  // destroy mutex et nanani

}
 
