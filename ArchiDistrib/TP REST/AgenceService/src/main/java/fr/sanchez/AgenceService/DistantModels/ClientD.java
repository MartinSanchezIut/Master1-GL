package fr.sanchez.AgenceService.DistantModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientD {
	
	private Long id;
	private String nom;
	private String prenom;
	private String carte;
	
	public ClientD() {}	
	public ClientD(String nom, String prenom, String carte) {
		this.id = null;
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
