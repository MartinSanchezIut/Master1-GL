#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/ipc.h>
#include <sys/sem.h>
#include <stdlib.h>

/*struct sembuf {
    unsigned short sem_num ;
    short sem_op ;  
    short sem_flg ; 
};*/
union semun{
    int val;
    struct semid_ds * buf;
    ushort * array;
} ;
int main(int argc, char * argv[]){
    if (argc!=3) {
        printf("Nbre d'args invalide, utilisation :\n");
        printf("%s fichier-pour-cle-ipc entier-pour-cle-ipc\n", argv[0]);
        exit(0);
    }

    int cleSem=ftok(argv[1], atoi(argv[2]));
    int idSem = semget(cleSem, 1, 0600);
    if (idSem==-1){
        perror("erreur  semget");
        exit(-1);
    }
    printf("sem id : %d \n", idSem);
    printf("Nous sommes au point de rdv\n");



    struct sembuf opp;
    opp.sem_num=0;
    opp.sem_op=-1;
    opp.sem_flg=0;

    semop(idSem,&opp,1);



    union semun valeurs;   
    valeurs.array = (ushort*)malloc(1 * sizeof(ushort));
    if (semctl(idSem, 1, GETALL, valeurs) == -1){
        perror("erreur initialisation sem : ");
        exit(1);
    } 
    printf("[ "); 
    for(int i=0; i < 1-1; i++){
        printf("%d, ", valeurs.array[i]);
    }
    printf("%d ] \n", valeurs.array[1-1]);
    free(valeurs.array);



    struct sembuf opp1;
    opp1.sem_num=0;
    opp1.sem_op=0;
    opp1.sem_flg=0;
    semop(idSem,&opp1,1);

    printf("Fin\n");
  return 0;
}
