package com.hotel.HotelService.Model;

public class Offre {

	private Hotel hotel;
	private Chambre chambre;
	private Integer prix;
	
	public Offre(Hotel hotel, Chambre chambre, Integer prix) {
		super();
		this.hotel = hotel;
		this.chambre = chambre;
		this.prix = prix;
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
