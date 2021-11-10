package decorateurimpl;

public class Forfait implements Compte{

	Compte decore;
	public Forfait (Compte c) {
		decore = c;
	}
	
	@Override
	public double prixLocation(Produit p) {
		return decore.prixLocation(p);
	}
	
}
