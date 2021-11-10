package decorateur;

public class CompteAvecSeuil extends Compte {

	private int seuil;
	public CompteAvecSeuil(Client cli, int s) {
		super(cli);
		seuil = s;
	}
	
	public double prixLocation(Produit p) {
		if (p.getPrix() > seuil) {
			return -1;
		}
		return p.getPrix();
	}

}
