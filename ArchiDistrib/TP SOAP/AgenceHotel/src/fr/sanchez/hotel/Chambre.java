package fr.sanchez.hotel;

import java.util.ArrayList;

public class Chambre {
	
	private String nom;
	private Integer nbLits;
	private Integer prix;
	
	private Hotel hotel;
	
	private ArrayList<Reservation> reservation;

	
	public Chambre(String nom, Integer nbLits, Integer prix) {
		super();
		this.nom = nom;
		this.nbLits = nbLits;
		this.prix = prix;
		reservation = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return "[nom=" + nom + ", nbLits=" + nbLits + ", prix=" + prix + ", reservation=" + reservation + "]";
	}

	public String getNom() {
		return nom;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public Integer getNbLits() {
		return nbLits;
	}
	public Integer getPrix(Integer reduc) {
		return prix - (prix * reduc/100);
	}
	public ArrayList<Reservation> getReservation() {
		return reservation;
	}	
}
