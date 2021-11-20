#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <sys/shm.h>
#include <stdlib.h>
#include "calcul.h"
// Copié sur sabrine

int main(int argc, char const *argv[]){
  if (argc!= 6) {
    printf("Nbre d'args invalide, utilisation :\n");
    printf("%s fichier-pour-cle-ipc entier-pour-clé-ipc nombre-zones nombre-traitements numero-processus \n", argv[0]);
    exit(0);
  }
  printf("Je suis le processus numero %d \n",atoi(argv[5]));
  //recuperer la cle
  int cle = ftok(argv[1], atoi(argv[2]));

  //recuperer la memoire partagée
  int idMem = shmget(cle, atoi(argv[3])*sizeof(int),0600);
  if (idMem == -1){
    perror("erreur shmget : ");
    exit(-1);
  }
  
int* memPar;

//recuperer le semaphore qui se trouve etre un tableau
  int nbSem = atoi(argv[4])-1;

  int idSem = semget(cle, nbSem,0600);
  if(idSem == -1){
    perror("erreur semget : ");
    exit(-1);
  }

  union semun{
    int val;
    struct semid_ds * buf;
    ushort * array;
  } valinit;
//creer le tableau de sem
  valinit.array = (int*)malloc(nbSem*sizeof(int));
    if (semctl(idSem, nbSem, GETALL, valinit) == -1){
    perror("erreur initialisation sem : ");
    exit(-2);
  } 
  struct sembuf monsem;
    monsem.sem_flg = 0;
    monsem.sem_op = 1;

//Parcour le tableau de sem 
  if (atoi(argv[5]) == 1){
    monsem.sem_num = atoi(argv[5])-1;
    for (int i = 0; i < atoi(argv[3]); i++){
    //je donne l'accées a la memoire partagée
      memPar = (int*)shmat(idMem,NULL,0);
      printf("J'ai accées à la mémoire partagée \n");
      calcul(2);
    //je fais le traitement sur la memoire partagée
      memPar[i] += atoi(argv[5])*22;
      printf("J'ai traité la zone numero %i memPar[%i] = %i \n",i,i,memPar[i]);
    //je libere la memoire partagée
      if(shmdt (memPar) == -1){
      perror("erreur de liberation de la memoire partagée : ");
      exit(-3);
      }
      printf("J'ai liberé la mémoire partagée \n");
    //je rajoute 1 a l'emplacement du processus (qui est le num du precussus -1) dans le sem
      if (semop(idSem,&monsem,1) == -1){
      perror("erreur operation V : ");
      exit(-4);
    }
    printf("J'ai incrémenté le sem à l'emplacement numero %i \n \n",atoi(argv[5])-1);
    }
  }

  else{
    for (int i = 0; i < atoi(argv[3]); i++){
      monsem.sem_num = atoi(argv[5])-2;
      monsem.sem_op = -1;
      if (semop(idSem,&monsem,1) != -1){
        memPar = (int*)shmat(idMem,NULL,0);
        printf("J'ai accées à la mémoire partagée \n");
        calcul(5);
        memPar[i] += atoi(argv[5])*22;
        printf("J'ai traité la zone numero %i memPar[%i] = %i \n",i,i,memPar[i]);
        //je libere la memoire partagée
         if(shmdt (memPar) == -1){
          perror("erreur de liberation de la memoire partagée : ");
          exit(-3);
        }
        printf("J'ai liberé la mémoire partagée \n");
         //je rajoute 1 a l'emplacement du processus (qui est le num du precussus -1) dans le sem
        if (atoi(argv[5]) != atoi(argv[4])){
         monsem.sem_op = 1;
         monsem.sem_num = atoi(argv[5])-1;
          if (semop(idSem,&monsem,1) == -1){
          perror("erreur operation V : ");
          exit(-4);
          }
          printf("J'ai incrémenté le sem à l'emplacement numero %i \n \n",atoi(argv[5])-1);
        }
      }
    }
  }
   

	return 0;
}