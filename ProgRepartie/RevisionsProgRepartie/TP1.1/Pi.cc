#include <stdlib.h>
#include <sys/types.h>
#include <iostream>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <stdio.h>//perror
using namespace std;

struct mesg_buffer {
    long etiquette;
    int  count;
} message;

int main(int argc, char * argv[]){
  if (argc!=3) {
    cout<<"Nbre d'args invalide, utilisation :"<< endl;
    cout << argv[0] << " fichier-pour-cle-ipc entier-pour-cle-ipc"<< endl;
    exit(0);
  }
	  
  key_t cle=ftok(argv[1], atoi(argv[2]));
  if (cle==-1) {
    perror("Erreur ftok : ");
    exit(2);
  }
  cout << "ftok ok" << endl;

  int msgid = msgget(cle, 0666);
  if(msgid==-1) {
    perror("erreur msgget : ");
    exit(2);
  }
  cout << "msgget ok" << endl;

    // Le code ici
    struct mesg_buffer msg;
    msgrcv(msgid, &msg, sizeof(msg), 0, 0);
    // J'ai le token
    // Travailler
  cout << "Je taffe " << msg.count << endl;
    // Je libère
    struct mesg_buffer msg1;
    msg1.etiquette = 0;
    msg1.count = msg.count++;
    msgsnd(msgid, &msg, sizeof(msg), 0);


    // Le code ici
  return 0;
}
