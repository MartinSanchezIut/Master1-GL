package decorateurimpl;

public class Main {

	public static void main(String[] args){
		Produit lgv = new Produit("La grande vadrouille", 10.0);
		Client cl = new Client("Dupont");
		
		//un compte normal pour le client Dupont
		Compte cmt = new CompteBasique(cl);
		System.out.println("basique lgv : " + cmt.prixLocation(lgv));
		
		//Dupont achete un forfait reduction.
		cmt = new ForfaitReduction(cmt, 50);
		System.out.println("reduction lgv : " + cmt.prixLocation(lgv));
		
		//Dupont achete en plus un forfait seuil, le seuil est `a 2
		cmt = new ForfaitSeuil(cmt, 15);
		System.out.println("Seuil1+Reduction lgv: " + cmt.prixLocation(lgv));
		System.out.println("Seuil2+Reduction lgv: " + cmt.prixLocation(lgv));
		System.out.println("Seuil3+Reduction lgv: " + cmt.prixLocation(lgv));
		
		//Dupont avec ses 2 forfaits loue un produit solde
		Produit r4 = new ProduitSolde("RockyIV", 10.0, 10);
		System.out.println("Seuil1+Reduction+Solde rocky: " + cmt.prixLocation(r4));
		System.out.println("Seuil2+Reduction+Solde rocky: " + cmt.prixLocation(r4));
		System.out.println("Seuil3+Reduction+Solde rocky: " + cmt.prixLocation(r4));
	}

}
