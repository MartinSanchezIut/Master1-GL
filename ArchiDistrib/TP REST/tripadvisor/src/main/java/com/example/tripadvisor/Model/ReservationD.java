package com.example.tripadvisor.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationD {
	
	private Long id;
	private int idChambre;
	private int  idClient;
	private String debut;
	private String fin;
	
	public ReservationD() {}
	public ReservationD(int idChambre, int idClient, String debut, String fin) {
		super();
		this.idChambre = idChambre;
		this.idClient = idClient;
		this.debut = debut;
		this.fin = fin;
	}
	public Long getId() {
		return id;
	}
	public int getIdChambre() {
		return idChambre;
	}
	public int getIdClient() {
		return idClient;
	}
	public String getDebut() {
		return debut;
	}
	public String getFin() {
		return fin;
	}	
}
