package agenceNonDistrib.hotel;

import agenceNonDistrib.client.Client;

public class Reservation {

	private Chambre chambre;
	private Client client;
	
	private String debut;
	private String fin;
	
	public Reservation(Chambre cham, Client cli, String d, String f) {
		chambre = cham;
		client = cli;
		debut = d;
		fin = f;
		System.out.println("Le client " + cli + " reserve la chambre " + cham + " de " + debut.toString() 
		+ " a " + fin.toString() + ".");
	}
	
}