package com.hotel.HotelService.Model;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hotel {
	
	
	@Id
	private Long id;
	
	@Column(name="name")	
	private String nom;
	@Column(name="stars")	
	private int etoiles;
	@Column(name="ville")	
	private String ville;
	//@OneToMany
	private ArrayList<Chambre> chambres;
	
	
	public Hotel(String n, String v, int e) {
		nom = n;
		etoiles = e;
		ville = v;
		chambres = new ArrayList<>();
	}
	
	public ArrayList<Chambre> getChambres() {
		return chambres;
	}
	public String getName() {
		return nom;
	}
	public String getVille() {
		return ville;
	}
	public int getEtoiles() {
		return etoiles;
	}
}
