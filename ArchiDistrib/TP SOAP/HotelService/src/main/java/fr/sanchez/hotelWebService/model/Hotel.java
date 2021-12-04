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
	
	@Override
	public String reserver(String login, String mdp, String nomChambre, String nom, String prenom, String carte,
			String debut, String fin) {
		Chambre c = null;
		for (Chambre cha : chambres) {
			if (cha.getNom().equalsIgnoreCase(nomChambre))
				c = cha;
		}
		if (c != null) {
			c.getReservation().add(new Reservation(new  Client(nom, prenom, carte), debut, fin)) ;
			return "La chambre a ete reservee.\n " + nom + " " + prenom + " " + carte + " " + nomChambre;
		}else {
			return "Une erreur est survenue";
		}
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
	
	public ArrayList<String> rechercher(String login, String mdp, String date, String date1, int prixMin, int prixMax, int lits) {
		Integer reduction = 0;
		for (Partenaire p : partenaires) {
			if (p.getNomAgence().equalsIgnoreCase(login) && p.getMotdepasse().equals(mdp)) {
				reduction = p.getReduction();
			}
		}
		
		ArrayList<String> ret = new ArrayList<>();
		ArrayList<Chambre> recherche = rechercher(date, date1, prixMin, prixMax, lits, reduction);
		for(Chambre c  : recherche) {
			Offre o = new Offre(this, c, c.getPrix(reduction))  ;
			ret.add(o.toString());
		}
		return ret;
	}
	
	//Date au format aaaa/mm/jj
	private ArrayList<Chambre> rechercher(String date, String date1, int prixMin, int prixMax, int lits, int reduction) {
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
}
