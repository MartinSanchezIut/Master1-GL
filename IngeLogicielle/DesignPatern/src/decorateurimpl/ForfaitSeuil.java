package decorateurimpl;

public class ForfaitSeuil extends Forfait{

	int seuil;
	public ForfaitSeuil(Compte c, int s) {
		super(c);
		seuil = s;
	}

	@Override
	public double prixLocation(Produit p) {
		double prixLoc = super.prixLocation(p);
		if (prixLoc > seuil) {
			return -1;
		}else {
			return prixLoc;
		}
	}

}
