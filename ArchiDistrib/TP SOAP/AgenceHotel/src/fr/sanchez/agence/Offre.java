package fr.sanchez.agence;

import fr.sanchez.hotel.Chambre;
import fr.sanchez.hotel.Hotel;

public class Offre {
	
	private Hotel hotel;
	private Chambre chambre;
	
	private Integer prix;

	public Offre(Agence self, Hotel hotel, Chambre chambre) {
		super();
		this.hotel = hotel;
		this.chambre = chambre;
		System.out.println(hotel.getReduction(self.getNom(), self.getMdp()));
		this.prix = chambre.getPrix(hotel.getReduction(self.getNom(), self.getMdp()));
	}	
	@Override
	public String toString() {
		return "Offre [hotel=" + hotel.getNom() + ", chambre=" + chambre.getNom() + ", prix=" + prix + "]";
	}
	public Hotel getHotel() {
		return hotel;
	}
	public Chambre getChambre() {
		return chambre;
	}
	public Integer getPrix() {
		return prix;
	}
}
