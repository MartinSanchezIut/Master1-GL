package decorateur;

public class CompteAvecReduction extends Compte {

	private int red;
	public CompteAvecReduction(Client cli, int reduction) {
		super(cli);
		red = reduction;
	}
	
	public double prixLocation(Produit p) {
		return p.getPrix() * (red / 100);
	}
}
