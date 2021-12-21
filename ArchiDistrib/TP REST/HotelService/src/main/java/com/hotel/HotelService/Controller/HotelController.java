package com.hotel.HotelService.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.HotelService.Model.Chambre;
import com.hotel.HotelService.Model.Offre;
import com.hotel.HotelService.Model.Partenaire;
import com.hotel.HotelService.Model.Reservation;
import com.hotel.HotelService.Repositories.ChambreRepository;
import com.hotel.HotelService.Repositories.ClientRepository;
import com.hotel.HotelService.Repositories.HotelRepository;
import com.hotel.HotelService.Repositories.PartenaireRepository;
import com.hotel.HotelService.Repositories.ReservationRepository;

@RestController
public class HotelController {
	
	@Autowired
	public HotelRepository hotel ;
	@Autowired
	public ChambreRepository chambre ;
	@Autowired
	public ReservationRepository reserv ;
	@Autowired
	public ClientRepository client ;	
	@Autowired
	public PartenaireRepository part ;	

	
	
	
	
	
	
	
	// hotel/1/test:test-from=0-0-0,to=1000-0-0,priceMin=30,priceMax=50,beds=3
	@GetMapping("/hotel/{id}/{login}:{mdp}-from={date},to={date1},priceMin={prixMin},priceMax={prixMax},beds={lits}")
	public ArrayList<Offre> rechercher(@PathVariable long id, @PathVariable String login, @PathVariable String mdp,
									   @PathVariable String date, @PathVariable String date1, @PathVariable int prixMin, 
									   @PathVariable int prixMax, @PathVariable int lits) {
		ArrayList<Offre> ret = new ArrayList<>() ;		
		
		Integer reduction = 0;
		for (Partenaire p : part.findPartenairesDe(id)) {
			if (p.getNom().equalsIgnoreCase(login) && p.getMdp().equalsIgnoreCase(mdp)) {
				reduction = p.getReduc();
			}		
		}
		
		ArrayList<Chambre> cha = lookup(id, date, date1, prixMin, prixMax, lits) ;
		for(Chambre c : cha) {		
			Offre o = new Offre(hotel.findById(id).get(), c, (c.getPrix() - (c.getPrix() * reduction/100) )) ;
			ret.add(o) ;
		}
		
		return ret;
	}
	
	private ArrayList<Chambre> lookup(@PathVariable long id,
			@PathVariable String date, @PathVariable String date1, @PathVariable int prixMin, 
			@PathVariable int prixMax, @PathVariable int lits) {
			
		ArrayList<Chambre> ret = new ArrayList<>();
		
		for (Chambre c : chambre.findChambreDe(id)) {
			if ((c.getPrix() >= prixMin) && (c.getPrix() <= prixMax) && (c.getLits() >= lits)) {
				
				int deb = Integer.parseInt(date.replace("-", ""));
				int fin = Integer.parseInt(date1.replace("-", ""));
				boolean valid = true; 
				
				List<Reservation> reservations = reserv.getReservationOfChambre(c.getId()) ;
				for (int i = 0; i < reservations.size(); i++) {
					int reser_deb = Integer.parseInt(reservations.get(i).getDebut().replace("-", ""));
					int reser_fin = Integer.parseInt(reservations.get(i).getFin().replace("-", ""));
					
					if ((fin > reser_deb && fin < reser_fin) || (deb < reser_fin && deb > reser_deb)) {
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
