#include <string.h>
#include <stdio.h>
#include <sys/types.h>
#include <stdlib.h>
#include <unistd.h>
#include <iostream>
#include <pthread.h>


struct paramsFonctionThread {

  int idThread;

  // si d'autres param�tres, les ajouter ici.

};


void * fonctionThread (void * params){

  struct paramsFonctionThread * args = (struct paramsFonctionThread *) params;

  // a compl�ter
  ...
}


int main(int argc, char * argv[]){

  if (argc < 2 ){
    printf("utilisation: %s  nombre_threads  \n", argv[0]);
    return 1;
  }     

  
  pthread_t threads[atoi(argv[1])];

  ...

 
  
  // cr�ation des threards 
  for (int i = 0; i < atoi(argv[1]); i++){

    // Le passage de param�tre est fortement conseill� (�viter les
    // variables globles).

     ... // compl�ter pour initialiser les param�tres
    if (pthread_create(&threads[i], NULL,..., ...) != 0){
      perror("erreur creation thread");
      exit(1);
    }
  }


// garder cette saisie et modifier le code en temps venu.
  char c; 
  printf("saisir un caract�re \n");
  fgets(m, 1, stdin);

 ... compl�ter

  return 0;
 
}
 
