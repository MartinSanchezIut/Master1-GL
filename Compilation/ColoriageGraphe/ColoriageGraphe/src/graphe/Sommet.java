package graphe;

class Sommet{

    public String name;
    public String color;

    public int nbVoisin;
    
    public Sommet(String n, String c) {
        name = n;
        color = c;
        nbVoisin = 0;
    }
    public Sommet(String n) {
        name = n;
        color = null;
        nbVoisin = 0;
    }

    public String toString(){
        String ret = name + "(" + color + ") " + nbVoisin ;
        return ret;
    }
}