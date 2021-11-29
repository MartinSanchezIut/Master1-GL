package agenceservice;

import java.util.ArrayList;
import java.util.List;


import agenceservice.hotel.Chambre;
import agenceservice.hotel.IHotelService;

public class Agence implements IAgenceService{

	private ArrayList<IHotelService> listeHotel;
	public Agence() {
		listeHotel = new ArrayList<IHotelService>();
	}
	
	public void addHotel(IHotelService h) {
		listeHotel.add(h);
	}
	public IHotelService removeHotel(IHotelService h) throws Exception {
		for(int i = 0; i < listeHotel.size(); i++) {
			IHotelService ret = listeHotel.get(i);
			if (ret.equals(h)) {
				listeHotel.remove(i);
				return ret;
			}
		}
		throw new Exception("Erreur: cet hotel n'existe pas dans notre agence.");
	}
	
	public ArrayList<Chambre> lookup(String ville, String date, String date1, int prixMin, int prixMax, int etoiles, int lits) {
		ArrayList<Chambre> ret = new ArrayList<Chambre>();
		for (IHotelService h : listeHotel) {
			if (h.getVille().equalsIgnoreCase(ville) && h.getEtoiles() == etoiles) {
				List<Chambre> cham = h.lookup(date, date1, prixMin, prixMax, lits);
				ret.addAll(cham);
			}
		}
		return ret;
	}
}
