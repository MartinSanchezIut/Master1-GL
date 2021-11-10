package decorateur;

public class CompteAvecRedEtSeuil extends Compte{

	private CompteAvecReduction red;
	private CompteAvecSeuil seuil;
	
	public CompteAvecRedEtSeuil(Client cli, int reduc, int seuil) {
		super(cli);
		red = new CompteAvecReduction(cli, reduc);
		this.seuil = new CompteAvecSeuil(cli, seuil);
	}
	
	public double prixLocation(Produit p) {
		if (seuil.prixLocation(p) == -1) {
			return -1;
		}
		return red.prixLocation(p);
	}
}
