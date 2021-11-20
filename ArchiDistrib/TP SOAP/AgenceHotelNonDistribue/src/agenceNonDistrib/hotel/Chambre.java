package agenceNonDistrib.hotel;

public class Chambre {
	
	private Hotel hotel;
	private Reservation reservation;
	private String nom;
	private int lits;
	
	private int prix;
	
	public Chambre(Hotel h, String n, int l, int p) {
		hotel = h;
		nom = n;
		lits = l;
		prix = p;
		reservation = null;
	}
	
	
	
	@Override
	public String toString() {
		return "Chambre de l'hotel: " + hotel.getName() + " - " + nom + " (" + lits + ") : " + prix + "Euros." ;
	}

}
