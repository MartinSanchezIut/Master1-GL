package agenceNonDistrib.client;

public class Client {
	
	private String nom;
	private String prenom;
	private String carte;
	
	public Client(String n, String p, String c) {
		nom = n;
		prenom = p;
		carte = c;
	}
	
	@Override
	public String toString() {	
		return nom  + " " + prenom;
	}
}
