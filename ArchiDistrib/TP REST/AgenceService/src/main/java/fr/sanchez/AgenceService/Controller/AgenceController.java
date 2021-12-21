package fr.sanchez.AgenceService.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.sanchez.AgenceService.DistantModels.HotelD;
import fr.sanchez.AgenceService.DistantModels.Offre;
import fr.sanchez.AgenceService.Model.Agence;
import fr.sanchez.AgenceService.Model.Hotel;
import fr.sanchez.AgenceService.Repositories.AgenceRepository;
import fr.sanchez.AgenceService.Repositories.HotelRepository;

@RestController
public class AgenceController {

	@Autowired
	public AgenceRepository agence ;
	@Autowired
	public HotelRepository hotel ;	
	@Autowired
	RestTemplate proxy;	
	
	// Agence
	@GetMapping("/agence")
	public List<Agence> getAllAgence(){
		return agence.findAll();
	}
	@GetMapping("/agence/{id}")
	public Optional<Agence> getAgence(@PathVariable long id){
		return agence.findById(id);
	}
	
	
	
	// Hotel
	@GetMapping("/hotel")
	public List<Hotel> getAllHotel(){
		return hotel.findAll();
	}
	@GetMapping("/hotel/{id}")
	public Optional<Hotel> getHotel(@PathVariable long id){
		return hotel.findById(id);
	}
	@GetMapping("/agence/{id}/hotel")
	public List<Hotel> getHotelDe(@PathVariable long id){
		return hotel.findHotelDe(id);
	}
	
	// /agence/1/lookup/ville=Montpellier,etoiles=3,from=0-0-0,to=1000-0-0,priceMin=30,priceMax=50,beds=3
	@GetMapping("/agence/{id}/lookup/ville={ville},etoiles={etoiles},from={date},to={date1},priceMin={prixMin},priceMax={prixMax},beds={lits}")
	public List<Offre> lookup(@PathVariable long id, @PathVariable String ville, @PathVariable int etoiles,
							  @PathVariable String date, @PathVariable String date1, @PathVariable int prixMin, 
							  @PathVariable int prixMax, @PathVariable int lits){
		
		List<Offre> ret = new ArrayList<>();
		Optional<Agence> agence = getAgence(id);
		
		List<Hotel> hotels = getHotelDe(id);
		for(Hotel h : hotels) {
			HotelD hot = proxy.getForObject(h.getUri(), HotelD.class) ;
			if ((hot.getEtoiles() == etoiles) && hot.getVille().equalsIgnoreCase(ville)) {
			
				String uri = h.getUri() + "/" + agence.get().getNom() + ":" + agence.get().getMdp() 
							+ "-from="+ date + ",to=" + date1 + ",priceMin=" + prixMin + ",priceMax=" + prixMax + ",beds=" + lits;
				Offre[] offres = proxy.getForObject(uri, Offre[].class);
				ret.addAll(Arrays.asList(offres)) ;
			}
			
			}
		return ret;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
