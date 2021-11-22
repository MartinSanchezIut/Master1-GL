package agenceNonDistrib;
import java.util.ArrayList;
import java.util.Scanner;

import agenceNonDistrib.agence.AgenceHotel;
import agenceNonDistrib.client.Client;
import agenceNonDistrib.hotel.Chambre;
import agenceNonDistrib.hotel.Reservation;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Reservez un hotel : ");
		System.out.println("Quelle ville ?");
		String ville = sc.nextLine();
		
		System.out.println("Date de d'arrivée ? (aaa/mm/jj)");
		// aaaa/mm/jj -> permet de comparer facilement sur int
		String date = sc.nextLine();	

		System.out.println("Date de de depart ? (aaa/mm/jj)");
		// aaaa/mm/jj -> permet de comparer facilement sur int
		String date1 = sc.nextLine();
		
		System.out.println("Prix min ?");
		int prixMin = sc.nextInt();
	
		System.out.println("Prix max ? ");
		int prixMax = sc.nextInt();
		
		System.out.println("Catégorie ");
		int etoiles = sc.nextInt();
		
		System.out.println("Nombre lits ? ");
		int lits = sc.nextInt();
		
		System.out.println("Vous cherchez : ");
		System.out.println(ville + " - " + date + " / " + date1);
		System.out.println(prixMin + " - " + prixMax + "euros  " + etoiles + "* " + lits + "lits.");
		
		
		// Le truc qui devrait se passer chez le serveur
		AgenceHotel agence = new AgenceHotel();
		ArrayList<Chambre> response = agence.lookup(ville, date, date1, prixMin, prixMax, etoiles, lits);
		for(int i = 0; i < response.size(); i++) {
			System.out.println(" - " + i + " " + response.get(i).toString());
		}
		
		System.out.println("Dans quel hotel reserver ?");
		int idCham = sc.nextInt();
		Client c = new Client("Toto", "Titi", "6847698");
		Reservation r = new Reservation(response.get(idCham), c, date, date1);
		
		System.out.println("C'est réservé.");
		sc.close();

		
	}

}
