package graphe;

import java.util.ArrayList;
import java.util.Stack;

class Graphe{

    public ArrayList<Arrete> arretes;
    public ArrayList<Sommet> sommets;

    public Graphe() {
        arretes = new ArrayList<>();
        sommets = new ArrayList<>();
    }

    public Graphe(ArrayList<Arrete> a) {
        arretes = a;
        sommets = new ArrayList<>();

        for (Arrete x : arretes) {
        	if (! sommets.contains(x.a)) {
        		sommets.add(x.a);
        	}
        	if (! sommets.contains(x.b)) {
        		sommets.add(x.b);
        	}
        }
    }


    public Graphe colorier(int nbCoul) {
    	Stack<Sommet> somettrivial = new Stack<Sommet> ();
    	Stack<Sommet> spile = new Stack<Sommet> ();

    	for(Sommet x : sommets) {
    		if(x.nbVoisin <= nbCoul ) {
    			somettrivial.push(x);
    			//retirer x du graphe
    			x.color = 
 
    		}
    	}
    	for(Sommet x : sommets) {
		 {
			if(sommets.containt(x)) {
				
				
			}
		}
    	/*
    	 pile<Sommet> sommetsTrivialementColoriable
    	 
    	 pile<Sommet> spile
    	 
    	 Si il exite s trivialement coloriable
    	 	
    	 	Ajouter a la pile
    	 	Colorier (G sans s)
    	 	
    	 	Donner une couleur dispo a s

    	 
    	 Sinon 
    	 	si il existe s
    	 		ajouter a autre pile
    	 		spiller s    	 
    	 */
    	
    	
    	
    	return this;
    }

    public String toString(){
        String ret = "";
        for (Sommet s : sommets) {
        	ret += s.toString() + " \n" ;
        }
        ret += "\n\n";
        
        for (Arrete a : arretes) {
            ret += a.toString() + "\n" ;
        }
        return ret;
    }

}