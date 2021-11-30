package fr.sanchez.agenceWebService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import fr.sanchez.agenceWebService.model.Agence;
import fr.sanchez.agenceWebService.model.Hotel;

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
	
		
		System.out.println("Reservez un hotel : ");
		System.out.println("Dans quelle ville ?");
		String ville = sc.nextLine();
		
		System.out.println("Date d'arrivée ? (aaaa/mm/jj)");
		String date = sc.nextLine();	

		System.out.println("Date de depart ? (aaaa/mm/jj)");
		String date1 = sc.nextLine();
		
		System.out.println("Prix min ?");
		int prixMin = sc.nextInt();
	
		System.out.println("Prix max ? ");
		int prixMax = sc.nextInt();
		
		System.out.println("Combien d'etoiles l'hotel ?");
		int etoiles = sc.nextInt();
		
		System.out.println("Nombre lits ? ");
		int lits = sc.nextInt();
		
		System.out.println("Resumons, vous chezchez : ");
		System.out.println("A " + ville + ", du " + date + " au " + date1);
		System.out.println("Entre " + prixMin + " et " + prixMax + "euros, " + etoiles + "Etoiles, et pour " + lits + "lits.");
		
		
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
