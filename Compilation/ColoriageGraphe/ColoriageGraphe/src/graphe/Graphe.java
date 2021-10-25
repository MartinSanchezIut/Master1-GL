package graphe;

import java.util.ArrayList;
import java.util.Stack;

class Graphe{

	public ArrayList<Sommet> sommets;

    public ArrayList<Arrete> interferances;
    public ArrayList<Arrete> preferences;

	public Graphe(Graphe g) {
		this.sommets = new ArrayList<>(g.sommets) ;
		this.interferances = new ArrayList<>(g.interferances) ;
		this.preferences = new ArrayList<>(g.preferences) ;
	}
    public Graphe(ArrayList<Arrete> inter, ArrayList<Arrete> pref) {
        interferances = inter;
		preferences = pref;

        sommets = new ArrayList<>();
        for (Arrete x : inter) {
        	if (! sommets.contains(x.a)) {
        		sommets.add(x.a);
        	}
        	if (! sommets.contains(x.b)) {
        		sommets.add(x.b);
        	}
        }
		for (Arrete x : pref) {
        	if (! sommets.contains(x.a)) {
        		sommets.add(x.a);
        	}
        	if (! sommets.contains(x.b)) {
        		sommets.add(x.b);
        	}
        }
    }

	public boolean canBeColored(Sommet sommet, int couleur){
        for(Arrete arr : interferances){
            if(arr.estVoisin(sommet)){
                if(arr.a.color == couleur || arr.b.color == couleur){
                    return false;
                }
            }
        }
        return true;
    }

	public boolean estTrivial(Sommet s, int nbCouleur) {
        int voisins = 0;
		for(Arrete arr : interferances){
			if(arr.estVoisin(s)){
				voisins++;
			}
		}
		return voisins < nbCouleur;
	}

	public Graphe supprimerSommet(Sommet s) {
		Graphe ret = new Graphe(this);

		ret.sommets.remove(s);
		for (Arrete arr : interferances) {
			if (arr.estVoisin(s)) {
				ret.interferances.remove(arr);
			}
		}		
		for (Arrete arr : preferences) {
			if (arr.estVoisin(s)) {
				ret.preferences.remove(arr);
			}
		}	
		return ret;
	}

	public void colorierSommet(Sommet s, int nbCoul) {
		for (int i = 0; i < nbCoul; i++) {
			if (this.canBeColored(s, i)) {
				s.color = i;
				break;
			}
		}
	}

    public Graphe colorier(int nbCoul) {
		Stack<Sommet> spille = new Stack<>();
		// A revoir avec l'idée de matthieu
		for (Sommet s : sommets) {
			if (this.estTrivial(s, nbCoul)) {
				Graphe g = new Graphe(this);
				g.supprimerSommet(s) ;
				g.colorier(nbCoul) ;

				this.colorierSommet(s, nbCoul) ;
				break; // A voir
			}
		}
		for (Sommet s : sommets) {
			Graphe g = new Graphe(this) ;
			g.supprimerSommet(s) ;
			g.colorier(nbCoul);

			spille.push(s) ;

		}
    	   	/*  Pour chaque sommet (Est trivial?)
			   		Oui: 
					   new graphe copie
					   supprimer
					   recursif

					   colorier(sommet)
				Pour tout sommet:
					nouveau graphe
					supprimer
					recursif

					spiller
			   */
    	return this;
    }

    public String toString(){
        String ret = "";
        for (Sommet s : sommets) {
        	ret += s.toString() + " \n" ;
        }
        ret += "\n\n";
        
        for (Arrete a : interferances) {
            ret += a.toString() + "\n" ;
        }

		for (Arrete a : preferences) {
            ret += a.toString() + "\n" ;
        }
        return ret;
    }

}