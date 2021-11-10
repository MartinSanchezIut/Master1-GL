package decorateurimpl;

public class ProduitSolde extends Produit{

	private int reduction;
	public ProduitSolde(String l, double p, int reduc) {
		super(l, p);
		reduction = reduc;
	}
	
	public double getPrix() {
		return getPrix() * (reduction / 100);
	}
	
	

	
}
