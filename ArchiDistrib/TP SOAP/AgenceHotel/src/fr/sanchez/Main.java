package fr.sanchez;

import java.util.ArrayList;
import java.util.Scanner;

import fr.sanchez.agence.Agence;
import fr.sanchez.agence.Offre;
import fr.sanchez.hotel.Chambre;
import fr.sanchez.hotel.Client;
import fr.sanchez.hotel.Hotel;
import fr.sanchez.hotel.Partenaire;

public class Main {
	
	public static void main(String[] args) {
		// Création des objets
		Agence agence = new Agence("Agence1", "123");
		
		for (int i = 0; i < 3; i++) {
			Hotel h = new Hotel("Hotel "+i, "Montpellier", i+2);
			for(int j = 0; j < 4; j++) {
				Chambre c = new Chambre("Chambre "+ j, 4, 10);
				h.getChambres().add(c);
				//System.out.println(c);
			}
			if (i == 2) {
				h.getPartenaires().add(new Partenaire("Agence1", "123", 50)) ;
			}
			//System.out.println(h);
			agence.getListeHotels().add(h);
		}
		System.out.println(agence);
		
		
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("Reservez un hotel : ");
		System.out.println("Quelle ville ?");
		String ville = sc.nextLine();
		
		System.out.println("Date de d'arrivée ? (aaaa/mm/jj)");
		// aaaa/mm/jj -> permet de comparer facilement sur int
		String date = sc.nextLine();	

		System.out.println("Date de de depart ? (aaaa/mm/jj)");
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
		ArrayList<Offre> response = agence.rechercher(ville, date, date1, prixMin, prixMax, etoiles, lits);
		for(int i = 0; i < response.size(); i++) {
			System.out.println(" - " + i + " " + response.get(i).toString());
		}
		if (response.size() == 0) {
			System.out.println("Rien trouve");
			System.exit(1);
		}
		
		System.out.println("Dans quel hotel reserver ?");
		int idCham = sc.nextInt();
		
		System.out.println("Entrez vos coordones : nom ?");
		String nom = sc.nextLine();
		System.out.println("Entrez vos coordones : prenom ?");
		String prenom = sc.nextLine();		
		System.out.println("Entrez vos coordones : carte ?");
		String carte = sc.nextLine();
		
		Client c = new Client(nom, prenom, carte);
		
		System.out.println(response.get(idCham).getHotel().reserver(null, c, prenom, carte));
		
		System.out.println("C'est réservé.");
		sc.close();

				
		
	}
}
