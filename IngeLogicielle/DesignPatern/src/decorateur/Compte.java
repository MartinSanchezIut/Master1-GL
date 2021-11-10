package decorateur;

public class Compte {

	private Client c;
	
	public Compte(Client cli) {
		c = cli;
	}
	
	public double prixLocation(Produit p) {
		return p.getPrix();
	}
	/*
	public Compte addReduction(int red) {
		return new CompteAvecReduction(c, red);
	}
	
	public Compte addSeuil(int seuil) {
		return new CompteAvecSeuil(c, seuil);
	}*/
}
