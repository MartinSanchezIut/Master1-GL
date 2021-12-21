package fr.sanchez.AgenceService.DistantModels;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelD {
	
	private Long id;
	private String name;
	private int etoiles;
	private String ville;
	
	public HotelD(String name, int etoiles, String ville) {
		this.name = name;
		this.etoiles = etoiles;
		this.ville = ville;
	}
	public HotelD() {	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getEtoiles() {
		return etoiles;
	}
	public String getVille() {
		return ville;
	}
}
