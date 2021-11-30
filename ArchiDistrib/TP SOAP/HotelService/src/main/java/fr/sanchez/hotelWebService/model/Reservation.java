package fr.sanchez.hotelWebService.model;

public class Reservation {
	
	private Client cli;
	private String debut;
	private String fin;
	
	public Reservation(Client cli, String debut, String fin) {
		super();
		this.cli = cli;
		this.debut = debut;
		this.fin = fin;
	}
	public Client getCli() {
		return cli;
	}
	public String getDebut() {
		return debut;
	}
	public String getFin() {
		return fin;
	}
	@Override
	public String toString() {
		return "[cli=" + cli + ", debut=" + debut + ", fin=" + fin + "]";
	}
}
