#include <stdio.h>
#include <sys/types.h>
#include <netdb.h>
#include <arpa/inet.h>
#include <sys/socket.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <string.h>


struct identificateur{
    char ip[16];    // 255.255.255.255
    char port[6]; //5566xx
};

int sendTCP(int socket, const char *buffer, size_t length, unsigned int *nbBytesSent, unsigned int *nbCallSend){
	size_t sent;
	size_t totalSent = 0;
	unsigned int cptrSend = 0;

	while (totalSent < length)	{
		sent = send(socket, buffer + totalSent, length - totalSent, 0);
		cptrSend++;
		if (sent <= 0)		{
			(*nbBytesSent) += totalSent;
			(*nbCallSend) += cptrSend;
			return sent;
		}
		totalSent += sent;
	}
	(*nbBytesSent) += totalSent;
	(*nbCallSend) += cptrSend;

	return 1;
}

int createSocketTCP(int argc, char *argv[]) {
	int ds = socket(AF_INET, SOCK_STREAM, 0);
	if (ds == -1)	{
		printf("Client : pb creation socket\n");
		exit(1);
	}
	struct sockaddr_in adrServ;
	adrServ.sin_family = AF_INET;
	adrServ.sin_port = htons(atoi(argv[2]));
	if (inet_pton(AF_INET, argv[1], &(adrServ.sin_addr)) < 1)	{
		perror("client: inet_pton() error ->");
		exit(1);
	}
	int conn = connect(ds, (struct sockaddr *)&adrServ, sizeof(adrServ));
	if (conn < 0)	{
		perror("Client: pb au connect :");
		close(ds);
		exit(1);
	}
	printf("Client : demande de connexion reussie \n\n");
	return ds;
}

int main(int argc, char *argv[]){
	if (argc != 4)	{
		printf("utilisation : client ip_serveur port_serveur mon_port\n");
		exit(0);
	}

	/*
		VARIABLES IMPORTANTES DU PROGRAMME
	*/ 
	int jeton = 0;
    struct identificateur pere;
    struct identificateur next;




	int ds = createSocketTCP(argc, argv) ;

    pere.ip = argv[1] ;
    pere.port = argv[2] ;

    

	close(ds);
	printf("Client : je termine\n");
}