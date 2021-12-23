package com.example.tripadvisor.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Offre {

	private HotelD hotel;
	private ChambreD chambre;
	private int prix;
	
	private AgenceD agence;
	
	public Offre(HotelD hotel, ChambreD chambre, Integer prix) {
		super();
		this.hotel = hotel;
		this.chambre = chambre;
		this.prix = prix;
	}
	public HotelD getHotel() {
		return hotel;
	}
	public ChambreD getChambre() {
		return chambre;
	}
	public Integer getPrix() {
		return prix;
	}
	public AgenceD getAgence() {
		return agence;
	}
	public void setAgence(AgenceD agence) {
		this.agence = agence;
	}
	@Override
	public String toString() {
		return "Offre dans l'hotel \'" + hotel.getName() + "\' a \'" + hotel.getVille() + "\': " + chambre.getNom() + " " +prix+"e  ("+ 
				agence.getNom() +")";
	}	
}
