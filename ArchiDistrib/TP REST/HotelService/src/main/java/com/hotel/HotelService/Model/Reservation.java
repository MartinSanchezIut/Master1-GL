package com.hotel.HotelService.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class Reservation {
	
	@Id
	private Long id;
	
	@Column(name="chambre")
	private Chambre chambre;
	@Column(name="client")
	private Client client;
	@Column(name="debut")
	private String debut;
	@Column(name="fin")
	private String fin;
	
	public Reservation() {}
	
	public Reservation(Long id, Chambre chambre, Client client, String debut, String fin) {
		super();
		this.id = id;
		this.chambre = chambre;
		this.client = client;
		this.debut = debut;
		this.fin = fin;
	}

	public Long getId() {
		return id;
	}
	public Chambre getChambre() {
		return chambre;
	}
	public Client getClient() {
		return client;
	}
	public String getDebut() {
		return debut;
	}
	public String getFin() {
		return fin;
	}
	
	
}
