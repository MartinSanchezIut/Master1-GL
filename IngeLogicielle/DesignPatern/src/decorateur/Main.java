package decorateur;

public class Main {

	public static void main(String[] args){
		Produit lgv = new Produit("La grande vadrouille", 10.0);
		Client cl = new Client("Dupont");
		Compte cmt = new Compte(cl);
		cmt.prixLocation(lgv);
		
		Compte cmt2 = new CompteAvecReduction(cl);
		System.out.println("CompteReduction : " + cmt2.prixLocation(lgv));
		Compte cmt3 = new CompteAvecSeuil(cl);
		System.out.println("CompteSeuil : " + cmt3.prixLocation(lgv));
		System.out.println("CompteSeuil : " + cmt3.prixLocation(lgv));
		System.out.println("CompteSeuil : " + cmt3.prixLocation(lgv)); 
		Produit r4 = new ProduitSolde("RockyIV", 10.0, 20);
		
		System.out.println("CompteNormal+ProduitSold ́e : " + cmt.prixLocation(r4));
		System.out.println("CompteReduction+ProduitSold ́e : " + cmt2.prixLocation(r4));
	}

}
