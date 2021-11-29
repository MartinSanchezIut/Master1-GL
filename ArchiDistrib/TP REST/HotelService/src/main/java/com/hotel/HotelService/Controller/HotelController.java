package com.hotel.HotelService.Controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.HotelService.Model.Chambre;
import com.hotel.HotelService.Model.Hotel;

@RestController
public class HotelController {
	
	
	// Ici on peut remplir l'hotel
	private Hotel h = new Hotel("Gite d'Agilard", "Tuchan", 3);
	{
		for(int i = 1; i < 9; i++) {
			int r = 2 + (int)(Math.random() * ((5 - 2) + 1));
			int r1 = 10 + (int)(Math.random() * ((50 - 10) + 1));
			h.getChambres().add(new Chambre("Chambre " + i, r, r1)) ;
		}
	}
	
	
	@GetMapping("/")
	public Hotel getHotel() {
		return h;
	}
	
	@GetMapping("hotel/nom")
	public String getName() {
		return h.getName();
	}
	
	@GetMapping("hotel/ville")
	public String getVille() {
		return h.getVille();
	}
	
	@GetMapping("hotel/stars")
	public int getEtoiles() {
		return h.getEtoiles();
	}
	
	@GetMapping("hotel/chambres")
	public ArrayList<Chambre> getChambres() {
		return h.getChambres();
	}
	
	@GetMapping("hotel/chambre/{id}")
	public Chambre getChambresById(@PathVariable int id) {
		return h.getChambres().get(id);
	}
	
	
	
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
	}
	
}
