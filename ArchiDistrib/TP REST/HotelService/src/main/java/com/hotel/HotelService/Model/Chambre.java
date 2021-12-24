package com.hotel.HotelService.Model;

import java.io.File;
import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chambre {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String nom;
	@Column(name="lits")
	private int lits;
	@Column(name="prix")
	private int prix;

	@Column(name="img")
	private String img;
	
	@Column(name="hotel")
	private int idHotel;
		
	public Chambre() {	}
	public Chambre(Long id, String nom, int lits, int prix, String img, int idHotel) {
		super();
		this.id = id;
		this.nom = nom;
		this.lits = lits;
		this.prix = prix;
		this.img = img;
		this.idHotel = idHotel;
	}
	public Long getId() {
		return id;
	}
	
	/*public String getImg() {
		return img;
	}*/
	public File getImg() throws IOException {
		
        File fichier = new File (this.img);  
        if (! fichier.exists()) {
        	throw new IOException("File not exist : " + fichier.getAbsolutePath());
        }
        if (! fichier.canRead()){
        	throw new IOException("File cannot be read : " + fichier.getAbsolutePath());
        }
        
        return fichier;
/*        BufferedImage bi = ImageIO.read (fichier);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bi, "jpg", bos );
        return bos.toByteArray(); */
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
