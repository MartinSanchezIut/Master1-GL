package fr.sanchez.AgenceService.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
