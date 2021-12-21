package com.hotel.HotelService.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Partenaire {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="nom")
	private String nom;
	@Column(name="mdp")
	private String mdp;
	@Column(name="reduc")
	private int reduc;
	@Column(name="hotel")
	private int idHotel;
	
	public Partenaire() {	}
	public Partenaire(Long id, String nom, String mdp, int reduc, int idHotel) {
		super();
		this.id = id;
		this.nom = nom;
		this.mdp = mdp;
		this.reduc = reduc;
		this.idHotel = idHotel;
	}
	public Long getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	public String getMdp() {
		return mdp;
	}
	public int getReduc() {
		return reduc;
	}
	public int getIdHotel() {
		return idHotel;
	}	
}
