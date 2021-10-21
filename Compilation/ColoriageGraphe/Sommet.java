
class Sommet{

    public String name;
    public String color;

    public Sommet(String n, String c) {
        name = n;
        color = c;
    }
    public Sommet(String n) {
        name = n;
        color = null;
    }

    public String toString(){
        String ret = name + "(" + color + ")";
        return ret;
    }
}