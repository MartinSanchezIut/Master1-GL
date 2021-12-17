package com.hotel.HotelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.hotel.HotelService.Model.Chambre;
import com.hotel.HotelService.Model.Hotel;
import com.hotel.HotelService.Repositories.ChambreRepository;
import com.hotel.HotelService.Repositories.ClientRepository;
import com.hotel.HotelService.Repositories.HotelRepository;
import com.hotel.HotelService.Repositories.PartenaireRepository;
import com.hotel.HotelService.Repositories.ReservationRepository;

@Component
public class Data {
	@Autowired
	private HotelRepository hotel ;
	@Autowired
	private ChambreRepository chambres ;
	@Autowired
	private ReservationRepository reserv ;
	@Autowired
	private ClientRepository client ;	
	@Autowired
	private PartenaireRepository part ;	
	
	
	private String[] villes = {"Paris", "Montpellier", "Toulouse", "Perpignan", "Pau", "Sete", "Bordeau"} ;
    @EventListener
    public void appReady(ApplicationReadyEvent event) {
    	
    	for (int i = 0; i < 7; i++) {
			int etoiles = 0 + (int)(Math.random() * ((5 - 1) + 1));
			int ville = 0 + (int)(Math.random() * ((villes.length - 1) + 1));
			
        	//hotel.save(new Hotel(null, "Hotel " + i, etoiles, villes[ville]));
        	
	    	for (int j=0; j<12; j++) {
	    		int lits = 1 + (int)(Math.random() * ((6 - 1) + 1));
	    		int prix = 26 + (int)(Math.random() * ((76 - 26) + 1));
	    		
	    		//chambres.save(new Chambre(null, "Chambre " + j, lits, prix, i));
	    	}
    	

    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
        
    }
}