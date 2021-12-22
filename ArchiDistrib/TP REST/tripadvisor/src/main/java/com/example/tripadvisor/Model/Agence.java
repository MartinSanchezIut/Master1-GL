package com.example.tripadvisor.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Agence {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="URI")	
	private String uri;

	public Agence(Long id, String uri) {
		super();
		this.id = id;
		this.uri = uri;
	}
	public Agence() {	}
	public Long getId() {
		return id;
	}
	public String getUri() {
		return uri;
	}
}
