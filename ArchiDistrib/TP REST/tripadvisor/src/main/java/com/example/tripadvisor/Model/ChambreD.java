package com.example.tripadvisor.Model;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChambreD {

	private Long id;
	private String nom;
	private int lits;
	private int prix;
	private File img;
	private int idHotel;
		
	public ChambreD() {	}
	public ChambreD(String nom, int lits, int prix, File img, int idHotel) {
		super();
		this.nom = nom;
		this.lits = lits;
		this.prix = prix;
		this.img = img;
		this.idHotel = idHotel;
	}
	
	public File getImg() {
		return img;
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
