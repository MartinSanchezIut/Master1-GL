package com.hotel.HotelService.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chambre {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String nom;
	@Column(name="lits")
	private int lits;
	@Column(name="prix")
	private int prix;
	@Column(name="hotel")
	private int idHotel;
		
	public Chambre() {	}
	public Chambre(Long id, String nom, int lits, int prix, int idHotel) {
		super();
		this.id = id;
		this.nom = nom;
		this.lits = lits;
		this.prix = prix;
		this.idHotel = idHotel;
	}
	public Long getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public int getLits() {
		return lits;
	}
	public int getPrix() {
		return prix;
	}
	public int getIdHotel() {
		return idHotel;
	}
}
