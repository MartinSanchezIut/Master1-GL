package com.hotel.HotelService.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {
	
	@Id
	@GeneratedValue  
	private Long id;
	@Column(name="name")
	private String nom;
	@Column(name="surname")
	private String prenom;
	@Column(name="card")
	private String carte;
	
	public Client() {}	
	public Client(Long id, String nom, String prenom, String carte) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.carte = carte;
	}
	public Long getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getCarte() {
		return carte;
	}
}
