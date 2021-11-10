package decorateur;

public class Main {

	public static void main(String[] args){
		Produit lgv = new Produit("La grande vadrouille", 10.0);
		Produit r4 = new ProduitSolde("RockyIV", 10.0, 20);
		
		Client cl = new Client("Dupont");
		Compte cmt = new Compte(cl);
		System.out.println(cmt.prixLocation(lgv));
		
		Compte cmt2 = new CompteAvecReduction(cl, 50);
		System.out.println("CompteReduction : " + cmt2.prixLocation(lgv));
		Compte cmt3 = new CompteAvecSeuil(cl, 100);
		System.out.println("CompteSeuil : " + cmt3.prixLocation(lgv));
		System.out.println("CompteSeuil : " + cmt3.prixLocation(lgv));
		System.out.println("CompteSeuil : " + cmt3.prixLocation(lgv)); 
		
		System.out.println("CompteNormal+ProduitSolde : " + cmt.prixLocation(r4));
		System.out.println("CompteReduction+ProduitSolde : " + cmt2.prixLocation(r4));
	}
}
