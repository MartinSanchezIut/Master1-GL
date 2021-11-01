package server.classes;

public class Espece {

	/*
	 Cette classe n'est pas un objet distribué
	 Elle sera visible par le client sous forme de string	 
	 */
	
	private String espece;
	private String race;
	private double ddv;
	protected Espece(String l, String r, double d) {
		super();
		espece = l;
		race = r;
		ddv = d;
	}
	public String getEspece() {
		return espece;
	}
	public String getRace() {
		return race;
	}
	public double getDDV() {
		return ddv;
	}
}
