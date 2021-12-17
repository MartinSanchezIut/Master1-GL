package com.hotel.HotelService.Model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.ForeignKey;

@Entity
public class Chambre {
	@Id
	private Long id;
	@Column(name="name")
	private String nom;
	@Column(name="lits")
	private int lits;
	@Column(name="prix")
	private int prix;
	@Column(name="hotel")
	private int idHotel;
	
	private ArrayList<Reservation> reservation;

	
	public Chambre() {	}
	
	public Chambre(Long id, String nom, int lits, int prix, ArrayList<Reservation> reservation) {
		super();
		this.id = id;
		this.nom = nom;
		this.lits = lits;
		this.prix = prix;
		this.reservation =  new ArrayList<>();
	}

	// A supprimer plus tard
	public Chambre(String n, int l, int p, int idHotel) {
		nom = n;
		lits = l;
		prix = p;
		this.idHotel = idHotel;
		reservation = new ArrayList<>();
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
	public String getNom() {
		return nom;
	}
	public long getIdHotel() {
		return idHotel;
	}
	public long getId() {
		return id;
	}
}
