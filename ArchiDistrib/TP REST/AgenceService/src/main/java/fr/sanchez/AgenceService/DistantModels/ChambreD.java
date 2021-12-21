package fr.sanchez.AgenceService.DistantModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChambreD {

	private Long id;
	private String nom;
	private int lits;
	private int prix;
	private int idHotel;
		
	public ChambreD() {	}
	public ChambreD(String nom, int lits, int prix, int idHotel) {
		super();
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
