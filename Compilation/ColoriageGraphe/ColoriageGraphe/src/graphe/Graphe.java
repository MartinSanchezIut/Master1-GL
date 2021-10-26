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
    // Ce truc est pété
    /*
     Si deja colorer : NON
     Si arrete de preferance: 
         oui si est coloriable par cette couleur dans le graphe qui contient pas 
         cette arete
         
     Si interférance
     */
	public boolean canBeColored(Sommet sommet, int couleur){
		if (sommet.color != -1) {
			return false;
		}
		for (Arrete arr : preferences) {
			if (arr.estVoisin(sommet))  {
				System.out.println(sommet.name + " est une arrete de pref");
				int coul1 = arr.a.color;
				int coul2 = arr.b.color;

				// C'est ici que ca merde
				Graphe g = new Graphe(this);
				g.preferences.remove(arr);
				System.out.println(g.toString());

				if (g.canBeColored(sommet, coul1) || g.canBeColored(sommet, coul2)) {
					System.out.println("Satisfait");
					return true;
				}
			}
		}
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
		for (int i = 1; i <= nbCoul; i++) {
			if (this.canBeColored(s, i)) {
				s.color = i;
				break;
			}
		}
	}

    public Graphe colorier(int nbCoul) {
		Stack<Sommet> spille = new Stack<>();
		
		boolean hasFound = false;
		for (Sommet s : sommets) {
			if (this.estTrivial(s, nbCoul)) {
				hasFound = true;
				Graphe g = this.supprimerSommet(s) ;
				g.colorier(nbCoul) ;

				this.colorierSommet(s, nbCoul) ;
				break;
			}
		}
		if (!hasFound) {
			for (Sommet s : sommets) {
				Graphe g = this.supprimerSommet(s) ;
				g.colorier(nbCoul);
	
				spille.push(s) ;
			}
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
		String sp = "Spille : " ;
		for (Sommet s : spille) {
			sp += s.name + " - " ;
		}
		System.out.println(sp);
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