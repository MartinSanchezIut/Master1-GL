package agenceservice;

import java.util.ArrayList;


import agenceservice.hotel.Chambre;
import agenceservice.hotel.IHotelService;


public interface IAgenceService {
	
	public void addHotel(IHotelService h);
	
	public IHotelService removeHotel(IHotelService h) throws Exception ;
	
	public ArrayList<Chambre> lookup(String ville, String date, String date1, int prixMin, int prixMax, int etoiles, int lits) ;
}
