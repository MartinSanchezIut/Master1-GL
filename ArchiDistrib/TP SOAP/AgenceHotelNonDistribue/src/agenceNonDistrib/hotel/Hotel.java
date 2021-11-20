package agenceNonDistrib.hotel;
import java.util.ArrayList;

public class Hotel {
	
	private String nom;
	private ArrayList<Chambre> chambres;
	
	private String ville;
	private int etoiles;
	
	public Hotel(String n, String v, int e) {
		nom = n;
		etoiles = e;
		ville = v;
		chambres = new ArrayList<>();
	}
	
	public String getName() {
		return nom;
	}
	public String getVille() {
		return ville;
	}
	public int getEtoiles() {
		return etoiles;
	}
	public ArrayList<Chambre> getChambres() {
		return chambres;
	}
}
