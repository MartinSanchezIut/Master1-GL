package com.hotel.HotelService.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hotel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")	
	private String nom;
	@Column(name="stars")	
	private int etoiles;
	@Column(name="ville")	
	private String ville;
	
	public Hotel(Long id, String nom, int etoiles, String ville) {
		super();
		this.id = id;
		this.nom = nom;
		this.etoiles = etoiles;
		this.ville = ville;
	}
	public Hotel() {	}
	
	
	public Long getId() {
		return id;
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
