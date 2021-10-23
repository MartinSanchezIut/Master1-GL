package graphe;

class Arrete{
	
    public Sommet a;
    public Sommet b;  
    
    public Arrete(Sommet x, Sommet y) {
        a = x; 
        b = y; 
    }
    public Arrete(String x, String y) {
        a = new Sommet(x); 
        b = new Sommet(y);
    }
    
    public boolean estVoisin(Sommet z) {
        return (a.equals(z)|| b.equals(z));
    }
    public String toString(){
        String ret = a.name + "  ---  " + b.name ;
        return ret;
    }
}