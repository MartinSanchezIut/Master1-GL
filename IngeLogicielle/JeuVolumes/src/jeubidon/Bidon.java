package jeubidon; 

public class Bidon {
	
	private int id;
	
	private int capacite;
	private int contenu;
	
	public Bidon(int i, int capacite) {
		this.capacite = capacite;
		contenu = 0;
		
		id = i;
	}
	
	public int getCapacite() {
		return capacite;
	}
	
	public int getContenu() {
		return contenu;
	}
	
	public void setContenu(int c) {
		contenu = c;
	}
	public String toString() {
		return contenu + " / " + capacite;
	}
	
	public int getId() {
		return id;
	}
	
}
