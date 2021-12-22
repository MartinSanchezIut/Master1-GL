package com.example.tripadvisor.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AgenceD {
	

	private Long id;	
	private String nom;
	private String mdp;
	
	public AgenceD() {	}
	public AgenceD(String nom, String mdp) {
		super();
		this.nom = nom;
		this.mdp = mdp;
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
}
