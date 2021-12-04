package fr.sanchez.agenceWebService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import fr.sanchez.agenceWebService.model.Agence;
import fr.sanchez.agenceWebService.model.Hotel;
import fr.sanchez.agenceWebService.model.Offre;

public class Main {

	static ArrayList<Hotel> hotels;
	static ArrayList<Agence> agences;
		
	public static void main(String[] args) throws MalformedURLException {
		build();
		Scanner sc = new Scanner(System.in);

		
		System.out.println("Bonjour, selectionnez une agence parmis les choix suivant :");
		for (int i = 0; i < agences.size(); i++) {
			System.out.println("	" + i + " - " + agences.get(i));
		}
		int agenc = sc.nextInt();
		Agence agence = agences.get(agenc);
		System.out.println("\nBienvenu chez l'agence : " + agence);
		sc.reset();
		
		System.out.println("Reservez un hotel : ");
		System.out.println("Dans quelle ville ?");
		String ville = "";
		do {
			ville = sc.nextLine();
		}while (ville.equals(""));
		
		System.out.println("Date d'arrivée ? (aaaa/mm/jj)");
		String date = "";
		do {
			date = sc.nextLine();
		}while (date.equals(""));
		
		
		System.out.println("Date de depart ? (aaaa/mm/jj)");
		String date1 = "";
		do {
			date1 = sc.nextLine();
		}while (date1.equals(""));	
		
		
		System.out.println("Prix min ?");
		int prixMin = sc.nextInt();
	
		System.out.println("Prix max ? ");
		int prixMax = sc.nextInt();
		
		System.out.println("Combien d'etoiles l'hotel ?");
		int etoiles = sc.nextInt();
		
		System.out.println("Nombre lits ? ");
		int lits = sc.nextInt();
		
		System.out.println("\n\nResumons, vous cherchez : ");
		System.out.println("A " + ville + ", du " + date + " au " + date1);
		System.out.println("Entre " + prixMin + " et " + prixMax + "euros, " + etoiles + "Etoiles, et pour " + lits + "lits.");
		
		ArrayList<Offre> response = agence.rechercher(ville, date, date1, prixMin, prixMax, etoiles, lits);
		for(int i = 0; i < response.size(); i++) {
			System.out.println(" - " + i + " " + response.get(i).toString());
		}
		if (response.size() == 0) {
			System.out.println("Rien trouve");
			System.exit(1);
		}
		
		System.out.println("Quelle offre vous interesse ?");
		int idCham = sc.nextInt();
		
		System.out.println("Entrez vos coordones : nom ?");
		String nom = "";
		do {
			nom = sc.nextLine();
		}while (nom.equals(""));	
		System.out.println("Entrez vos coordones : prenom ?");
		String prenom = "";
		do {
			prenom = sc.nextLine();
		}while (prenom.equals(""));
		System.out.println("Entrez vos coordones : carte ?");
		String carte = "";
		do {
			carte = sc.nextLine();
		}while (carte.equals(""));
		
// 	String reserver(String login, String mdp, Chambre chambre, String  nom, String prenom, String carte, String debut, String fin);
		System.out.println(response.get(idCham).getHotel().reserver(
				agence.getNom(), 
				agence.getMdp(),
				response.get(idCham).getChambre(),
				nom,
				prenom,
				carte,
				date,
				date1));
		System.out.println("C'est réservé.");		
		sc.close();
	}
	
	public static void build() throws MalformedURLException {	
		hotels = new ArrayList<>();
		hotels.add(new Hotel(new URL("http://localhost:8080/Hotel1"))) ;
		hotels.add(new Hotel(new URL("http://localhost:8080/Hotel2"))) ;
		hotels.add(new Hotel(new URL("http://localhost:8080/Hotel3"))) ;
		hotels.add(new Hotel(new URL("http://localhost:8080/Hotel4"))) ;
		
		agences = new ArrayList<>();
		Agence a = new Agence("Agence", "123");
		a.getListeHotels().addAll(hotels);
		agences.add(a) ;
		
		a = new Agence("Agence5", "123");
		a.getListeHotels().add(hotels.get(0));
		a.getListeHotels().add(hotels.get(2));
		agences.add(a) ;
	
		a = new Agence("Agence44", "123");
		a.getListeHotels().add(hotels.get(1));
		a.getListeHotels().add(hotels.get(3));
		agences.add(a) ;		

		a = new Agence("Optic2000", "123");
		a.getListeHotels().addAll(hotels);
		agences.add(a) ;
	}
}
