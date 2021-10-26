package graphe;
import java.util.ArrayList;
import java.util.Scanner;

class Main{


    public static void main(String[] args){

        ArrayList<Arrete> pref = new ArrayList<>();
        ArrayList<Arrete> inter = new ArrayList<>();

        // Diamant
        Sommet a = new Sommet("A");
        Sommet b = new Sommet("B");
        Sommet c = new Sommet("C");
        Sommet d = new Sommet("D");

        Arrete ab = new Arrete(a, b);
        Arrete bc = new Arrete(b, c);
        Arrete cd = new Arrete(c, d);
        Arrete da = new Arrete(d, a);

        inter.add(ab);
        inter.add(bc);
        inter.add(cd);
        //inter.add(da);
        pref.add(da);
        
        Graphe g = new Graphe(inter, pref);
        System.out.println(g.toString());     
        
        System.out.println("Entrez le nombre de couleur pour le graphe diamant: ");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        g.colorier(num);
        System.out.println(g.toString());
        
        System.out.println("\n\n\n\n\n");
        
        // Autre exemple
        ArrayList<Arrete> arretespref = new ArrayList<>();
        ArrayList<Arrete> arretesint = new ArrayList<>();
        Sommet v = new Sommet("V");
        Sommet x = new Sommet("X");
        Sommet y = new Sommet("Y");
        Sommet u = new Sommet("U");
        Sommet t = new Sommet("T");
        Sommet z = new Sommet("Z");


        Arrete vx = new Arrete(v, x);
        Arrete vz = new Arrete(v, z);
        Arrete vt = new Arrete(v, t);
        Arrete xu = new Arrete(x, u);
        Arrete xy = new Arrete(x, y);
        Arrete yt = new Arrete(y, t);
        Arrete yu = new Arrete(y, u);


        Arrete ut = new Arrete(u, t);
        arretesint.add(vx);
        arretesint.add(vz);
        arretesint.add(vt);
        arretesint.add(xu);
        arretesint.add(xy);
        arretesint.add(yt);
        arretesint.add(yu);

        arretespref.add(ut);
        
        Graphe g1 = new Graphe(arretesint, arretespref);
        System.out.println("Entrez le nombre de couleur pour le graphe: ");
        int num1 = in.nextInt();
        g1.colorier(num1);
        System.out.println(g1.toString());
        in.close();   
    }
}