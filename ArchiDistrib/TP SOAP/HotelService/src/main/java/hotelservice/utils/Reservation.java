package hotelservice.utils;


public class Reservation {

	private Chambre chambre;
	private Client client;
	
	private String debut;
	private String fin;
	
	public Reservation(Chambre cham, Client cli, String d, String f) {
		chambre = cham;
		cham.getReservation().add(this);
		client = cli;
		debut = d;
		fin = f;
		System.out.println("Le client " + cli + " reserve la chambre " + cham + " de " + debut.toString() 
		+ " a " + fin.toString() + ".");
	}
	
	public String getDebut() {
		return debut;
	}
	public String getFin() {
		return fin;
	}
	
}
