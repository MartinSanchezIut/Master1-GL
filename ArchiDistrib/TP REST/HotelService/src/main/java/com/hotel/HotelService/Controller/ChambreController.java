package com.hotel.HotelService.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.HotelService.Model.Chambre;
import com.hotel.HotelService.Model.Client;
import com.hotel.HotelService.Model.Hotel;
import com.hotel.HotelService.Model.Partenaire;
import com.hotel.HotelService.Model.Reservation;
import com.hotel.HotelService.Repositories.ChambreRepository;
import com.hotel.HotelService.Repositories.ClientRepository;
import com.hotel.HotelService.Repositories.HotelRepository;
import com.hotel.HotelService.Repositories.PartenaireRepository;
import com.hotel.HotelService.Repositories.ReservationRepository;

@RestController
public class ChambreController {
	
	@Autowired
	public HotelRepository hotel ;
	@Autowired
	public ChambreRepository chambres ;
	@Autowired
	public ReservationRepository reserv ;
	@Autowired
	public ClientRepository client ;	
	@Autowired
	public PartenaireRepository part ;	
	
	
	// Hotel
	@GetMapping("/hotel")
	public List<Hotel> getAllHotels(){
		return hotel.findAll();
	}
	@GetMapping("hotel/{id}")
	public Optional<Hotel> getHotel(@PathVariable long id) {
		return hotel.findById(id);
	}	
	
	
	
	// Chambre
	@GetMapping("/chambre")
	public List<Chambre> getAllChambres(){
		return chambres.findAll();
	}
	@GetMapping("chambre/{id}")
	public Optional<Chambre> getChambre(@PathVariable long id) {
		return chambres.findById(id);
	}	
	@GetMapping("hotel/{id}/chambre")
	public List<Chambre> getChambreDe(@PathVariable long id) {
		return chambres.findChambreDe(id);
	}	
	
	
	
	
	// Reservation
	@GetMapping("/reservation")
	public List<Reservation> getAllReservations(){ 
		return reserv.findAll();
	}
	@GetMapping("/reservation/{id}")
	public Optional<Reservation> getReservation(@PathVariable long id){
		return reserv.findById(id);
	}
	@GetMapping("/chambre/{id}/reservation")
	public List<Reservation> getReservationDe(@PathVariable long id){
		return reserv.getReservationOfChambre(id);
	}
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/reservation")
	public Reservation createReservation(@RequestBody Reservation cli) {
		return reserv.save(cli);
	}
	@GetMapping("/chambre/{id}/client={idCli}/deb={deb}/fin={fin}")
	public void addReservation(@PathVariable int id,
									  @PathVariable int idCli,
									  @PathVariable String deb,
									  @PathVariable String fin){
		Reservation r = new Reservation(null, id, idCli , deb, fin);
		reserv.save(r) ;
	}
	
	
	
	// Client
	@GetMapping("/client")
	public List<Client> getAllClients(){
		return client.findAll();
	}
	@GetMapping("/client/{id}")
	public Optional<Client> getClient(@PathVariable long id){
		return client.findById(id);
	}
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/client")
	public Client createClient(@RequestBody Client cli) {
		return client.save(cli);
	}
	@GetMapping("/client/inscription/{name}:{surname}:{card}")
	public void addClient(@PathVariable String name,
									  @PathVariable String surname,
									  @PathVariable String card){
		Client c = new Client(null, name, surname, card) ;
		client.save(c) ;
	}
	
	
	// Partenaire
	@GetMapping("/partenaire")
	public List<Partenaire> getAllPartenaires(){
		return part.findAll();
	}
	@GetMapping("/partenaire/{id}")
	public Optional<Partenaire> getPartenaire(@PathVariable long id){
		return part.findById(id);
	}
	@GetMapping("/hotel/{id}/partenaire")
	public List<Partenaire> getPartenaireDe(@PathVariable long id){
		return part.findPartenairesDe(id);
	}
}
