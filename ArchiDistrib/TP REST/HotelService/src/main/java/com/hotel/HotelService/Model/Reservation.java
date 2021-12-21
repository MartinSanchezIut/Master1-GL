package com.hotel.HotelService.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="chambre")
	private int idChambre;
	@Column(name="client")
	private int  idClient;
	@Column(name="debut")
	private String debut;
	@Column(name="fin")
	private String fin;
	
	public Reservation() {}
	public Reservation(Long id, int idChambre, int idClient, String debut, String fin) {
		super();
		this.id = id;
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
