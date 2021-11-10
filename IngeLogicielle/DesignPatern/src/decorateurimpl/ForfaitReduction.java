package decorateurimpl;

public class ForfaitReduction extends Forfait{
	
	private int reduction;
	public ForfaitReduction(Compte c, int red) {
		super(c);
		reduction = red;
	}

	public double prixLocation(Produit p) {
		return super.prixLocation(p) * (reduction / 100);
	}
}
