package com.hotel.HotelService.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.HotelService.Model.Chambre;
import com.hotel.HotelService.Model.Hotel;
import com.hotel.HotelService.Repositories.ChambreRepository;
import com.hotel.HotelService.Repositories.HotelRepository;

@RestController
public class HotelController {
	
	@Autowired
	public HotelRepository repo ;
	@Autowired
	public ChambreRepository chambres ;
	

	@GetMapping("/hotel")
	public List<Hotel> getAllHotels() {
		return repo.findAll();
	}
	
	@GetMapping("hotel/{id}")
	public Optional<Hotel> getHotel(@PathVariable long id) {
		return repo.findById(id);
	}
	
		
	@GetMapping("hotel/{id}/chambre")
	public ArrayList<Chambre> getChambresDe(@PathVariable long id) {
		Optional<Hotel> h = getHotel(id) ;
		if (! h.isEmpty()) {
			ArrayList<Chambre> ret = new ArrayList<>();
			List<Chambre> cham = chambres.findAll();
			for (Chambre c : cham ) {
				if (c.getIdHotel() == id) {
					ret.add(c);
				}
			}
			return ret;
			
		}
		return null;
	}
	
	// hotel/1/from=0-0-0,to=1000-0-0,priceMin=30,priceMax=50,beds=3
	@GetMapping("hotel/{id}/from={date},to={date1},priceMin={prixMin},priceMax={prixMax},beds={lits}")
	public ArrayList<Chambre> lookup(@PathVariable long id,
			@PathVariable String date, @PathVariable String date1, @PathVariable int prixMin, 
			@PathVariable int prixMax, @PathVariable int lits) {
			
		ArrayList<Chambre> ret = new ArrayList<>();
		
		for (Chambre c : getChambresDe(id)) {
			if ((c.getPrix() >= prixMin) && (c.getPrix() <= prixMax) && (c.getLits() >= lits)) {
				
				int d = Integer.parseInt(date.replace("-", ""));
				int d1 = Integer.parseInt(date1.replace("-", ""));
				boolean valid = true;
				/*
				for (int i = 0; i < c.getReservation().size(); i++) {
					int cd = Integer.parseInt(c.getReservation().get(i).getDebut().replace("/", ""));
					int cd1 = Integer.parseInt(c.getReservation().get(i).getFin().replace("/", ""));
					if ((d > cd && d < cd1) || (d1 < cd1 && d1 > cd)) {
						valid = false;
					}
				}
				*/
				if (valid) {
					ret.add(c);
				}
			}
		}		
		return ret;
	}
	
	
	
/*	
	//Date au format aaaa/mm/jj
	@GetMapping("hotel/lookup/from={date},to={date1},price={pMax},beds={lits}")
	public ArrayList<Chambre> lookup(@PathVariable String date, @PathVariable String date1, @PathVariable int prixMin, @PathVariable int prixMax, @PathVariable int lits) {
		
		ArrayList<Chambre> ret = new ArrayList<>();
		for (Chambre c : h.getChambres()) {
			if ((c.getPrix() >= prixMin) && (c.getPrix() <= prixMax) && (c.getLits() >= lits)) {
				int d = Integer.parseInt(date.replace("/", ""));
				int d1 = Integer.parseInt(date1.replace("/", ""));
				boolean valid = true;
				for (int i = 0; i < c.getReservation().size(); i++) {
					int cd = Integer.parseInt(c.getReservation().get(i).getDebut().replace("/", ""));
					int cd1 = Integer.parseInt(c.getReservation().get(i).getFin().replace("/", ""));
					if ((d > cd && d < cd1) || (d1 < cd1 && d1 > cd)) {
						valid = false;
					}
				}
				if (valid) {
					ret.add(c);
				}
			}
		}		
		return ret;
	}*/
	
}
