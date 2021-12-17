package com.hotel.HotelService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.HotelService.Model.Chambre;
import com.hotel.HotelService.Model.Client;
import com.hotel.HotelService.Model.Reservation;
import com.hotel.HotelService.Repositories.ChambreRepository;
import com.hotel.HotelService.Repositories.ClientRepository;
import com.hotel.HotelService.Repositories.HotelRepository;
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
	
	@GetMapping("/chambres")
	public List<Chambre> getAllChambres(){
		return chambres.findAll();
	}
	@GetMapping("/reservations")
	public List<Reservation> getAllReservations(){ 
		return reserv.findAll();
	}
	@GetMapping("/clients")
	public List<Client> getAllClients(){
		return client.findAll();
	}
	
	@GetMapping("/reservations/{id}")
	public List<Reservation> getAllReservations(@PathVariable long id){
		return reserv.getReservationOfChambre(id);
	}

}
