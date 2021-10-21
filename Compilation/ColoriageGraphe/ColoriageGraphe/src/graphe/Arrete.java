package graphe;

class Arrete{

	public enum Type {
		INT, 
		PREF;
	}
	
    public Sommet a;
    public Sommet b;
    public Type t;
    
    
    public Arrete(Sommet x, Sommet y) {
        a = x; a.nbVoisin++;
        b = y; b.nbVoisin++;
        t = Type.INT;
    }

    public Arrete(Sommet x, Sommet y, String type) {
        a = x; a.nbVoisin++;
        b = y; b.nbVoisin++;
        t = Type.PREF;
    }
    
    public Arrete(String x, String y) {
        a = new Sommet(x); a.nbVoisin++;
        b = new Sommet(y); b.nbVoisin++;
    }
    
    public Arrete(String x, String y, String type) {
        a = new Sommet(x); a.nbVoisin++;
        b = new Sommet(y); b.nbVoisin++;
        t = Type.PREF;
    }
    

    public String toString(){
        String ret = a.name + "  ---  " + b.name   + "    (" + t + ")" ;
        return ret;
    }
}