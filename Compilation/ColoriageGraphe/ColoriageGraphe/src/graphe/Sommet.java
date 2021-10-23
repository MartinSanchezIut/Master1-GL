package graphe;

class Sommet{

    public String name;
    public int color;
    
    public Sommet(String n) {
        name = n;
        color = -1;
    }

    public String toString(){
        String ret = name + "(" + color + ") " ;
        return ret;
    }
}