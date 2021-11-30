package fr.sanchez.hotelWebService;

import java.util.ArrayList;

import javax.xml.ws.Endpoint;

import fr.sanchez.hotelWebService.model.Chambre;
import fr.sanchez.hotelWebService.model.Hotel;
import fr.sanchez.hotelWebService.model.Partenaire;

public class HotelServicePublisher {

	public static void main(String[] args) {
		hotelPublisher("Hotel1", "Montpellier", 3, new ArrayList<Partenaire>());

		ArrayList<Partenaire> partner = new ArrayList<Partenaire>();
		partner.add(new Partenaire("Agence", "123", 30));
		partner.add(new Partenaire("Agence5", "123", 50));
		hotelPublisher("Hotel2", "Montpellier", 5, partner);
		
		hotelPublisher("Hotel3", "Montpellier", 1, new ArrayList<Partenaire>());
		
		partner = new ArrayList<Partenaire>();
		partner.add(new Partenaire("Agence", "123", 15));
		partner.add(new Partenaire("Agence44", "123", 90));
		hotelPublisher("Hotel4", "Montpellier", 4, partner);
		
		System.out.println("Server is ready");
	}
	
	public static void hotelPublisher(String name, String ville, int etoiles, ArrayList<Partenaire> partenaires) {
		// Creation de l'hotel
		Hotel h = new Hotel(name, ville, etoiles);
		// Creation des chambres
		for(int i = 0; i < 17; i++) {
			int random = 1 + (int)(Math.random() * ((6 - 1) + 1));
			int random1 = 26 + (int)(Math.random() * ((76 - 26) + 1));
			Chambre c = new Chambre("Chambre " + i + ".", random, random1);
			h.getChambres().add(c);			
		}
		// Creation des partenaires
		h.getPartenaires().addAll(partenaires);
		
		// Publication
		Endpoint.publish("http://localhost:8080/" + name, 
				h);
	}
}
