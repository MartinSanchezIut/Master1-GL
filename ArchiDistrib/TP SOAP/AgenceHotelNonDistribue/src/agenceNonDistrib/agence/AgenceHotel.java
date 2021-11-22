package agenceNonDistrib.agence;
import java.util.ArrayList;

import agenceNonDistrib.hotel.Chambre;
import agenceNonDistrib.hotel.Hotel;

public class AgenceHotel {

	private ArrayList<Hotel> listeHotel;
	public AgenceHotel() {
		listeHotel = new ArrayList<>();
	}
	
	public void addHotel(Hotel h) {
		listeHotel.add(h);
	}
	public Hotel removeHotel(Hotel h) throws Exception {
		for(int i = 0; i < listeHotel.size(); i++) {
			Hotel ret = listeHotel.get(i);
			if (ret.equals(h)) {
				listeHotel.remove(i);
				return ret;
			}
		}
		throw new Exception("Erreur: cet hotel n'existe pas dans notre agence.");
	}
	
	public ArrayList<Chambre> lookup(String ville, String date, String date1, int prixMin, int prixMax, int etoiles, int lits) {
		ArrayList<Chambre> ret = new ArrayList<>();
		for (Hotel h : listeHotel) {
			if (h.getVille().equalsIgnoreCase(ville) && h.getEtoiles() == etoiles) {
				ArrayList<Chambre> cham = h.lookup(date, date1, prixMin, prixMax, lits);
				ret.addAll(cham);
			}
		}
		return ret;
	}	
}
