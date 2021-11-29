package agenceservice;

import java.net.MalformedURLException;
import java.net.URL;

import agenceservice.hotel.HotelService;

public class AgenceServicePublisher {
	public static void main(String[] args) throws MalformedURLException {
		Agence a = new Agence();
		
		HotelService l3c = new HotelService(new URL("http://localhost:8080/Les3Chenes?wsdl"));
		a.addHotel(l3c.getHotelPort()) ;
		
		HotelService uAH = new HotelService(new URL("http://localhost:8080/unAutreHotel?wsdl"));
		a.addHotel(uAH.getHotelPort()) ;		
		
		
		
		
		
		
		
		
		
	/*	Agence l3c = new Agence("Les3Chenes", "Perpizoo", 5);
		Chambre c = new Chambre(l3c, "LaColo", 3, 100);
		
		l3c.addChambre(c);
		
		
		Agence uAH = new Agence("unAutreHotel", "Montpellier", 3);
		Chambre c1 = new Chambre(l3c, "LaColo", 3, 100);
		
		uAH.addChambre(c1);
		
		Endpoint.publish("http://localhost:8080/Les3Chenes", 
				l3c);
		Endpoint.publish("http://localhost:8080/unAutreHotel", 
				uAH);
		*/
		System.err.println("Server is ready");
	}
}
