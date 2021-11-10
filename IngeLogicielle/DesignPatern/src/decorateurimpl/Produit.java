package decorateurimpl;

public class Produit {
	
	private String label; 
	private double prix;

	public Produit(String l, double p) {
		label = l;
		prix = p;
	}
	
	public double getPrix() {
		return prix;
	}
}
