#include <netdb.h>
#include <arpa/inet.h>
#include <strings.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int* extract(int* T, int n, int a, int b) {
    int *array = (int*) malloc( n * sizeof(int));
    int index = 0;
    for (size_t i = 0; i < n; i++) {
        if (T[i] <= b && T[i] >= a) {
            array[index] = T[i];
            index++;
        }
    }
    return array;
}

int recursiveSomme(int* tab, int n){
    if (n == 0) {
        return 0;
    }
    return tab[n-1] + recursiveSomme(tab, n-1);
}

int main() {
    int a = 10;
    int b = 25;
    int *p = &b;
    int *pp = &a;

    printf("%d \n", *(&*(*(&p))) );
    printf("%d \n", *(p-1) );
    printf("%d \n", *(*(&p)-1) );
    printf("%d \n", *(*(&pp)+1) );
    printf("%d \n", *(&(*(*(&p))) - 1) );


    int tab[5] = {19, 10, 8, 17, 9};
    int* ret = extract(tab, 5, 8, 10);
    for (size_t i = 0; i < 5; i++)    {
        printf("%i ",  ret[i]);
    }
    int val = recursiveSomme(tab, 5);
    printf("\n%i \n",  val);


    int tube[2];
    int pipe(int tube[2]);
    char message[100] = "";

    switch (fork())   {
    case -1:
        printf("Une erreur de fork");
        break;
    case 0:
        sleep(3);
        printf("Je suis le fils");
        sprintf(message, "Wesh le couz tu vas bieng !\n");
		write(tube[1], message, 100);
        break;
    default:
        printf("Je suis le pere");
        if (read(*tube, message, 100) > 0) {
			printf("Message du processus:  %s", message);
        }
        break;
    }
    
}