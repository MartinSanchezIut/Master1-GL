package hotelservice;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import hotelservice.utils.Chambre;


@WebService
public interface IHotelService {
	
	@WebMethod
	String getVille();
	
	@WebMethod
	String getNom();	

	@WebMethod
	int getEtoiles();
	
	@WebMethod
	ArrayList<Chambre> lookup(String date, String date1, int prixMin, int prixMax, int lits);
}
