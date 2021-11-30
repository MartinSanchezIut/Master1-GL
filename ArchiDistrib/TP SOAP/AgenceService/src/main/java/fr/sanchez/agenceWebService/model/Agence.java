package fr.sanchez.agenceWebService.model;

import java.util.ArrayList;
import java.util.List;

import fr.sanchez.agenceWebService.hotel.Chambre;
import fr.sanchez.agenceWebService.hotel.IHotelService;

public class Agence {
	
	private String nom;
	private String mdp;
	
	private ArrayList<Hotel> listeHotels;
	
	public Agence(String nom, String mdp) {
		this.nom = nom;
		this.mdp = mdp;
		listeHotels = new ArrayList<>();
	}
	
	public ArrayList<Offre> rechercher(String ville, String date, String date1, int prixMin, int prixMax, int etoiles, int lits) {
		ArrayList<Offre> ret = new ArrayList<>();
		for (Hotel hotel : listeHotels) {
			IHotelService h = hotel.getProxy();
			
			if (h.getAddresse().equalsIgnoreCase(ville) && h.getEtoiles() == etoiles) {
				List<Chambre> chambres = h.rechercher(nom, mdp, date, date1, prixMin, prixMax, lits);
				
				for (Chambre c : chambres) {
					Offre o = new Offre(this, h, c);
					ret.add(o);	
				}
			}
		}
		return ret;
	}	
	

	@Override
	public String toString() {
		return "Agence [nom=" + nom + ", mdp=" + mdp + ", listeHotels=" + listeHotels + "]";
	}

	public String getNom() {
		return nom;
	}
	public String getMdp() {
		return mdp;
	}
	public ArrayList<Hotel> getListeHotels() {
		return listeHotels;
	}
}
