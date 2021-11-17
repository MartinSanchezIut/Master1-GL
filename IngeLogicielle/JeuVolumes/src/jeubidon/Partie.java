package jeubidon;

import java.util.ArrayList;
import java.util.Scanner;

import jeubidon.command.DeplacerVolume;
import jeubidon.command.RemplirBidon;
import jeubidon.command.ViderBidon;

public class Partie {

	private int nbrBidons;
	private ArrayList<Bidon> bidons;
	private Lanceur l;
	
	private int objectifVictoire;
	
	public Partie(int nombreBidons, int[] capacitesBidons, int objectif) {
		nbrBidons = nombreBidons;
		bidons = new ArrayList<>();
		
		for (int i = 0; i < nbrBidons; i++) {
			bidons.add(new Bidon(i, capacitesBidons[i])) ;
		}
		
		objectifVictoire = objectif;
		l = new Lanceur();
		
		System.out.println("Creation d'une partie ! ");
		System.out.println(toString());
	}
	
	public void jouer() {
		while(!aGagne()) {
			menu();
			Scanner scan = new Scanner(System.in); 
			int val = scan.nextInt();
			
			switch (val) {
			case 0:
				bidons.get(0).setContenu(objectifVictoire);
				break;
			case 1:
				while(l.canReverse()) {
					l.reverseCommand();
				}
				break;
			case 2:
				System.out.println("Quel bidon ?");
				int bid = scan.nextInt();
				l.executeCommand(new RemplirBidon(bidons.get(bid)));
				break;
			case 3:
				System.out.println("Quel bidon ?");
				bid = scan.nextInt();
				l.executeCommand(new ViderBidon(bidons.get(bid)));
				break;
			case 4:
				System.out.println("Transvaser A dans B, Entrez A et B.");
				int ba = scan.nextInt();
				int bb = scan.nextInt();
				l.executeCommand(new DeplacerVolume(bidons.get(ba), bidons.get(bb)));
				break;
			case 5:
				l.reverseCommand();
				break;
			default:
				System.err.println("Pas compris désolé !");
				break;
			}
		}
		System.out.println("C'est terminé ! Au-revoir.");
		System.out.println(l.getHistory());
	}
	
	private void menu() {
		System.out.println("=-:-==-:-==-:-==-:-==-:-==-:-==-:-==-:-==-:-=");
		for(int i = 0; i < bidons.size(); i++) {
			System.out.println(i + " : " + bidons.get(i).toString());
		}
		System.out.println("=-:-==-:-==-:-==-:-==-:-==-:-==-:-==-:-==-:-=");
		System.out.println("Selectionnez une option : ");
		System.out.println("	0- Quitter");
		System.out.println("	1- Recommencer");
		System.out.println("	2- Remplir un bidon");
		System.out.println("	3- Vider un bidon");
		System.out.println("	4- Deplacer le contenu d'un bidon");			
		System.out.println("	5- Retour en arriere");			
		System.out.println("=-:-==-:-==-:-==-:-==-:-==-:-==-:-==-:-==-:-=");	
	}
		
	public boolean aGagne() {
		return bidons.get(0).getContenu() == objectifVictoire;
	}
	
	public String toString() {
		String str = "Jeu des Volumes : \n";
		str += "	" + nbrBidons + " bidons, \n" ;
		
		for (int i = 0; i < nbrBidons; i++) {
			str += "	Bidon " + i + " : " + bidons.get(i)  + ", \n";
		}
		str+= "	" + objectifVictoire + " pour gagner." ;
		return str;
	}
}
