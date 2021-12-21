package fr.sanchez.AgenceService.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hotel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="URI")	
	private String uri;
	@Column(name="agence")	
	private int idAgence;
	
	public Hotel() {	}

	public Hotel(Long id, String uri, int idAgence) {
		super();
		this.id = id;
		this.uri = uri;
		this.idAgence = idAgence;
	}
	public Long getId() {
		return id;
	}
	public String getUri() {
		return uri;
	}
	public int getIdAgence() {
		return idAgence;
	}
}
