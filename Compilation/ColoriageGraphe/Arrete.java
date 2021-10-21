
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

    public String toString(){
        String ret = a.toString() + "  ---  " + b.toString();
        return ret;
    }
}