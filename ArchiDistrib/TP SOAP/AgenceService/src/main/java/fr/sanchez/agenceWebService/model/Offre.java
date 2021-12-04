package fr.sanchez.agenceWebService.model;

import fr.sanchez.agenceWebService.hotel.IHotelService;

public class Offre {
	
	private IHotelService hotel;
	private String chambre;
	
	private Integer prix;
	private Integer reduc;

	public Offre(Agence self, IHotelService hotel, String chambre, int prix) {
		super();
		this.hotel = hotel;
		this.chambre = chambre;
		this.prix = prix;
		this.reduc = hotel.getReduction(self.getNom(), self.getNom());
	}	
	public IHotelService getHotel() {
		return hotel;
	}
	public String getChambre() {
		return chambre;
	}
	public Integer getPrix() {
		return prix;
	}
	public Integer getReduc() {
		return reduc;
	}
	@Override
	public String toString() {
		return "A " + hotel.getAddresse()  + " " + chambre + ", prix=" + prix + " avec une reduction de " + reduc;
	}
}
