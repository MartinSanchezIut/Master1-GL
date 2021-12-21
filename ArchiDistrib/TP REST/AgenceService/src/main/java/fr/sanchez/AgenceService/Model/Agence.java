package fr.sanchez.AgenceService.Model;

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
	
	@Column(name="name")	
	private String nom;
	@Column(name="mdp")	
	private String mdp;
	
	public Agence() {	}
	public Agence(Long id, String nom, String mdp) {
		super();
		this.id = id;
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
