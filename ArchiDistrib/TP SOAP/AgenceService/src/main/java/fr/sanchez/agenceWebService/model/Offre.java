package fr.sanchez.agenceWebService.model;

import fr.sanchez.agenceWebService.hotel.Chambre;
import fr.sanchez.agenceWebService.hotel.IHotelService;

public class Offre {
	
	private IHotelService hotel;
	private Chambre chambre;
	
	private Integer prix;

	public Offre(Agence self, IHotelService hotel, Chambre chambre) {
		super();
		this.hotel = hotel;
		this.chambre = chambre;
		this.prix = hotel.getPrixChambre(chambre, hotel.getReduction(self.getNom(), self.getMdp()));
	}	
	/*@Override
	public String toString() {
		return "Offre [hotel=" + hotel.getNom() + ", chambre=" + chambre.getNom() + ", prix=" + prix + "]";
	}*/
	public Chambre getChambre() {
		return chambre;
	}
	public Integer getPrix() {
		return prix;
	}
}
