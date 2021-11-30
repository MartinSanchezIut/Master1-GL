package fr.sanchez.hotelWebService;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import fr.sanchez.hotelWebService.model.Chambre;
import fr.sanchez.hotelWebService.model.Client;

@WebService
public interface IHotelService {
	
	@WebMethod
	ArrayList<Chambre> rechercher(String login, String mdp, String date, String date1, int prixMin, int prixMax, int lits);

	@WebMethod
	String reserver(String login, String mdp, Chambre chambre, Client client, String debut, String fin);
	
	@WebMethod
	Integer getReduction(String login, String mdp);

	@WebMethod
	String getAddresse();
	
	@WebMethod
	Integer getEtoiles();
	
	@WebMethod
	Integer getPrixChambre(Chambre c, Integer reduc);
}
