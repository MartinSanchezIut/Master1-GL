package fr.sanchez.hotelWebService;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IHotelService {
	
	@WebMethod
	ArrayList<String> rechercher(String login, String mdp, String date, String date1, int prixMin, int prixMax, int lits);

	@WebMethod
	String reserver(String login, String mdp, String nomchambre, String  nom, String prenom, String carte, String debut, String fin);
	
	@WebMethod
	Integer getReduction(String login, String mdp);

	
	@WebMethod
	String getAddresse();
	@WebMethod
	Integer getEtoiles();
	@WebMethod
	String getNom();
}
