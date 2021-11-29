package hotelservice;

import java.util.ArrayList;

import javax.jws.WebService;

import hotelservice.utils.Chambre;
import hotelservice.utils.Client;
import hotelservice.utils.Reservation;

@WebService(endpointInterface="hotelservice.IHotelService")
public class Hotel implements IHotelService{

	private String nom;
	private ArrayList<Chambre> chambres;
	
	private String ville;
	private int etoiles;
	
	public Hotel(String n, String v, int e) {
		nom = n;
		etoiles = e;
		ville = v;
		chambres = new ArrayList<Chambre>();
	}
	
	public void addChambre(Chambre c) {
		chambres.add(c);
	}
	
	public String getNom() {
		return nom;
	}
	public String getVille() {
		return ville;
	}
	public int getEtoiles() {
		return etoiles;
	}
	//Date au format aaaa/mm/jj
	public ArrayList<Chambre> lookup(String date, String date1, int prixMin, int prixMax, int lits) {
		ArrayList<Chambre> ret = new ArrayList<Chambre>();
		for (Chambre c : chambres) {
			if ((c.getPrix() >= prixMin) && (c.getPrix() <= prixMax) && (c.getLits() >= lits)) {
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
}
