#include <stdio.h>
#include <iostream>
#include <fstream>  
#include "image_ppm.h"

using namespace std ;

int main(int argc, char* argv[]){
    char cNomImgLue[250];
    int nH, nW, nTaille, S;
    
    if (argc != 2) {
        printf("Usage: ImageIn.pgm \n"); 
        exit (1) ;
    }
    
    sscanf (argv[1],"%s",cNomImgLue) ;
    OCTET *ImgIn;
    
    lire_nb_lignes_colonnes_image_pgm(cNomImgLue, &nH, &nW);
    nTaille = nH * nW;
    
    allocation_tableau(ImgIn, OCTET, nTaille);
    lire_image_pgm(cNomImgLue, ImgIn, nH * nW);
        
    float tab[256] ;
    for (int i = 0; i < 256; i++) {
        tab[i] = 0;
    }

    for (int i=0; i < nTaille; i++) {
        int value =  ImgIn[i];
        tab[value]++;
    }

    /*
    for (int i=0; i < nH; i++)
    for (int j=0; j < nW; j++)
        {
        if ( ImgIn[i*nW+j] < S) ImgOut[i*nW+j]=0; else ImgOut[i*nW+j]=255;
        }

    ecrire_image_pgm(cNomImgEcrite, ImgOut,  nH, nW);
    */
    free(ImgIn); 

    std::ofstream outfile ("histo.dat");
    std::ofstream outfile1 ("ddp.dat");

    int somme = 0;
    for (int i = 0; i < 256; i++) {
        //cout << "Niveau de gris: " << i << " : " << tab[i] << endl;
        outfile << i << " " << tab[i] << endl;
        outfile1 << i << " " << float(tab[i]/nTaille) << endl;

        somme += tab[i];
    }

    int moyenne = somme / nTaille;
    
    somme = 0;
    for (int i = 0; i < 256; i++) {

        somme += tab[i] - moyenne;
    }
    int variance =  ( somme * somme ) / nTaille;

    cout << "Moyenne: " << moyenne << " Variance: " << variance << endl;

    outfile.close();
    return 1;
}
