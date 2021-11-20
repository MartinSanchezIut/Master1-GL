package agenceNonDistrib;
import java.util.Scanner;

import agenceNonDistrib.agence.AgenceHotel;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Reservez un hotel : ");
		System.out.println("Quelle ville ?");
		String ville = sc.nextLine();
		
		System.out.println("Date de d'arrivée ? (jj/mm/aa)");
		String date = sc.nextLine();	

		System.out.println("Date de de depart ? (jj/mm/aa)");
		String date1 = sc.nextLine();
		
		System.out.println("Prix min ?");
		int prixMin = sc.nextInt();
	
		System.out.println("Prix max ? ");
		int prixMax = sc.nextInt();
		
		System.out.println("Catégorie ");
		int etoiles = sc.nextInt();
		
		System.out.println("Nombre lits ? ");
		int lits = sc.nextInt();
		
		sc.close();
		System.out.println("Vous cherchez : ");
		System.out.println(ville + " - " + date + " / " + date1);
		System.out.println(prixMin + " - " + prixMax + "euros  " + etoiles + "* " + lits + "lits.");
		
		
		// Le truc qui devrait se passer chez le serveur
		AgenceHotel agence = new AgenceHotel();
		
		
		
		
		
	}

}
