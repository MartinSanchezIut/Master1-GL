package decorateurimpl;

public class CompteBasique implements Compte {

	private Client c;
	public CompteBasique(Client cli) {
		c = cli;
		c.compte = this;
	}
	
	public double prixLocation(Produit p) {
		return p.getPrix();
	}
}
