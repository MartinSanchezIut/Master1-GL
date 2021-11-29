package hotelservice.utils;

import java.util.ArrayList;

import hotelservice.Hotel;

public class Chambre {
	
	private Hotel hotel;
	private ArrayList<Reservation> reservation;
	private String nom;
	private int lits;
	
	private int prix;
	
	public Chambre(Hotel h, String n, int l, int p) {
		hotel = h;
		nom = n;
		lits = l;
		prix = p;
		reservation = new ArrayList<Reservation>();
	}
	
	public ArrayList<Reservation> getReservation() {
		return reservation;
	}
	public int getLits() {
		return lits;
	}
	public int getPrix() {
		return prix;
	}
	public Hotel getHotel() {
		return hotel;
	}
	
	@Override
	public String toString() {
		return "Chambre de l'hotel: " + hotel.getNom() + " - " + nom + " (" + lits + ") : " + prix + "Euros." ;
	}

}
