package fr.sanchez.hotelWebService.model;

public class Partenaire {
	
	private String nomAgence;
	private String motdepasse;
	private Integer reduction;
	
	public Partenaire(String nomAgence, String motdepasse, Integer reduction) {
		super();
		this.nomAgence = nomAgence;
		this.motdepasse = motdepasse;
		this.reduction = reduction;
	}
	public void setReduction(Integer red) {
		reduction = red;
	}
	public String getNomAgence() {
		return nomAgence;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public Integer getReduction() {
		return reduction;
	}
	@Override
	public String toString() {
		return "[nomAgence=" + nomAgence + ", motdepasse=" + motdepasse + ", reduction=" + reduction + "]";
	}
}
