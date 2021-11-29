package hotelservice;

import javax.xml.ws.Endpoint;

import hotelservice.utils.Chambre;


public class HotelServicePublisher {
	public static void main(String[] args) {
		hotelPublisher("Hotel1", "Montpellier", 3);
		hotelPublisher("Hotel2", "Montpellier", 5);
		hotelPublisher("Hotel3", "Montpellier", 1);
		hotelPublisher("Hotel4", "Montpellier", 4);
		
		System.err.println("Server is ready");
	}
	
	public static void hotelPublisher(String name, String ville, int etoiles) {
		Hotel l3c = new Hotel(name, ville, etoiles);
		ReservationService reserv = new ReservationService();
		for(int i = 0; i < 17; i++) {
			int random = 1 + (int)(Math.random() * ((6 - 1) + 1));
			int random1 = 26 + (int)(Math.random() * ((76 - 26) + 1));
			Chambre c = new Chambre(l3c, "Chambre " + i + ".", random, random1);
			l3c.addChambre(c);			
		}
		Endpoint.publish("http://localhost:8080/" + name + "reserv", 
				reserv);
		Endpoint.publish("http://localhost:8080/" + name, 
				l3c);
	}
}
