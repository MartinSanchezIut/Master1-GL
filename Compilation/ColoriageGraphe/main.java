class main{


    public static main(String[] args){

        ArrayList<Arrete> arretes = new ArrayList<>();

        // Diamant
        Sommet a = new Sommet("A");
        Sommet b = new Sommet("B");
        Sommet c = new Sommet("C");
        Sommet d = new Sommet("D");

        Arrete ab = new Arrete(a, b);
        Arrete bc = new Arrete(b, c);
        Arrete cd = new Arrete(c, d);
        Arrete da = new Arrete(d, a);

        arretes.add(ab);
        arretes.add(bc);
        arretes.add(cd);
        arretes.add(da);
        Graphe g = new Graphe(arretes);

        System.out.println("Entrez le nombre de couleur pour le graphe diamant: ");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        //g.colorier(num);
        g.toString();
        

    }

}