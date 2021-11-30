package fr.sanchez.hotelWebService.model;

import java.util.ArrayList;

import javax.jws.WebService;

import fr.sanchez.hotelWebService.IHotelService;

@WebService(endpointInterface="fr.sanchez.hotelWebService.IHotelService")
public class Hotel implements IHotelService{

	private String nom;
	private String addresse;
	private Integer etoiles;
	
	private ArrayList<Partenaire> partenaires;
	private ArrayList<Chambre> chambres;

	public Hotel(String nom, String addresse, Integer etoiles) {
		super();
		this.nom = nom;
		this.addresse = addresse;
		this.etoiles = etoiles;
		this.chambres = new ArrayList<>();
		this.partenaires = new ArrayList<>();
	}
	
	public String reserver(String login, String mdp, Chambre chambre, Client client, String debut, String fin) {
		chambre.getReservation().add(new Reservation(client, debut, fin)) ;
		return "La chambre a ete reservee";
	}
	
	public Integer getReduction(String login, String mdp) {
		Integer reduc = 0;
		for (Partenaire p : partenaires) {
			if (p.getNomAgence().equalsIgnoreCase(login) && p.getMotdepasse().equals(mdp)) {
				reduc = p.getReduction();
			}
		}	
		return reduc;
	}
	
	//Date au format aaaa/mm/jj
	public ArrayList<Chambre> rechercher(String login, String mdp, String date, String date1, int prixMin, int prixMax, int lits) {
		Integer reduction = 0;
		for (Partenaire p : partenaires) {
			if (p.getNomAgence().equalsIgnoreCase(login) && p.getMotdepasse().equals(mdp)) {
				reduction = p.getReduction();
			}
		}
		ArrayList<Chambre> ret = new ArrayList<>();
		for (Chambre c : chambres) {
			if ((c.getPrix(reduction) >= prixMin) && (c.getPrix(reduction) <= prixMax) && (c.getNbLits() >= lits)) {
				int d = Integer.parseInt(date.replace("/", ""));
				int d1 = Integer.parseInt(date1.replace("/", ""));
				boolean valid = true;
				for (int i = 0; i < c.getReservation().size(); i++) {
					int cd = Integer.parseInt(c.getReservation().get(i).getDebut().replace("/", ""));
					int cd1 = Integer.parseInt(c.getReservation().get(i).getFin().replace("/", ""));
					if ((d > cd && d < cd1) || (d1 < cd1 && d1 > cd)) {
						valid = false;
					}
				}
				if (valid) {
					ret.add(c);
				}
			}
		}		
		return ret;
	}
	@Override
	public String toString() {
		return "[nom=" + nom + ", addresse=" + addresse + ", etoiles=" + etoiles + ", partenaires=" + partenaires
				+ ", chambres=" + chambres + "]";
	}
	public String getNom() {
		return nom;
	}
	public String getAddresse() {
		return addresse;
	}
	public Integer getEtoiles() {
		return etoiles;
	}
	public ArrayList<Chambre> getChambres() {
		return chambres;
	}
	public ArrayList<Partenaire> getPartenaires() {
		return partenaires;
	}

	@Override
	public Integer getPrixChambre(Chambre c, Integer reduc) {
		return c.getPrix(reduc);
	}	
}
