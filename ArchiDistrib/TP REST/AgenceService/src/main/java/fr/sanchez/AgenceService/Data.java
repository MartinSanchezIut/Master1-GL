package fr.sanchez.AgenceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


import fr.sanchez.AgenceService.Model.Agence;
import fr.sanchez.AgenceService.Model.Hotel;
import fr.sanchez.AgenceService.Repositories.AgenceRepository;
import fr.sanchez.AgenceService.Repositories.HotelRepository;


@Component
public class Data {
	@Autowired
	private AgenceRepository a;
	@Autowired
	private HotelRepository h;
	
	
    @EventListener
    public void appReady(ApplicationReadyEvent event) {
    	a.save(new Agence(null, "Agence 1", "123")) ;
    	a.save(new Agence(null, "Agence 2", "123")) ;
    	
    	h.save(new Hotel(null, "http://localhost:8080/hotel/0", 0));
    	h.save(new Hotel(null, "http://localhost:8080/hotel/0", 1));
    	
    	h.save(new Hotel(null, "http://localhost:8080/hotel/1", 0));
    	h.save(new Hotel(null, "http://localhost:8080/hotel/1", 1));
    	
    	h.save(new Hotel(null, "http://localhost:8080/hotel/2", 0));
    	h.save(new Hotel(null, "http://localhost:8080/hotel/2", 1));
    	
    	h.save(new Hotel(null, "http://localhost:8080/hotel/3", 0));
    	h.save(new Hotel(null, "http://localhost:8080/hotel/3", 1));
    	
       	h.save(new Hotel(null, "http://localhost:8080/hotel/4", 0));
    	h.save(new Hotel(null, "http://localhost:8080/hotel/4", 1));
    	
    	h.save(new Hotel(null, "http://localhost:8080/hotel/5", 0));
    	h.save(new Hotel(null, "http://localhost:8080/hotel/5", 1));
    	
    	h.save(new Hotel(null, "http://localhost:8080/hotel/6", 0));
    	h.save(new Hotel(null, "http://localhost:8080/hotel/6", 1));


    }
}