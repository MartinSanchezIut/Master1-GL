
class Graphe{

    public ArrayList<Arrete> arretes;

    public Graphe() {
        arretes = new ArrayList<>();
    }

    public Graphe(ArrayList<Arretes> a) {
        arretes = a;
    }


    public Graphe colorierGraphe() {

    }

    public String toString(){
        String ret = "";
        for (Arrete a : arretes) {
            ret += a.toString() + "\n" ;
        }
        return ret;
    }

}