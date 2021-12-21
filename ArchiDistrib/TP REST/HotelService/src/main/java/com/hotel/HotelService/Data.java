package com.hotel.HotelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

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

@Component
public class Data {
	@Autowired
	private HotelRepository h ;
	@Autowired
	private ChambreRepository c ;
	@Autowired
	private ReservationRepository r ;
	@Autowired
	private ClientRepository cli ;	
	@Autowired
	private PartenaireRepository p ;	
	
	
	@SuppressWarnings("unused")
	private String[] villes = {"Paris", "Montpellier", "Toulouse", "Perpignan", "Pau", "Sete", "Bordeau"} ;
    @EventListener
    public void appReady(ApplicationReadyEvent event) {
    	h.save(new Hotel(null, "Hotel 1", 3, "Pau"));
    	c.save(new Chambre(null, "Chambre 1", 5, 53, 1));
    	c.save(new Chambre(null, "Chambre 2", 3, 25, 1));
    	c.save(new Chambre(null, "Chambre 3", 5, 43, 1));
    	c.save(new Chambre(null, "Chambre 4", 4, 57, 1));
    	c.save(new Chambre(null, "Chambre 5", 4, 45, 1));
    	c.save(new Chambre(null, "Chambre 6", 5, 40, 1));
    	c.save(new Chambre(null, "Chambre 7", 2, 64, 1));
    	c.save(new Chambre(null, "Chambre 8", 3, 44, 1));
    	c.save(new Chambre(null, "Chambre 9", 3, 61, 1));
    	c.save(new Chambre(null, "Chambre 10", 3, 37, 1));
    	c.save(new Chambre(null, "Chambre 11", 4, 64, 1));
    	c.save(new Chambre(null, "Chambre 12", 3, 37, 1));
    	p.save(new Partenaire(null, "Agence 1", "123", 35, 1));
    	p.save(new Partenaire(null, "Agence 2", "123", 47, 1));


    	h.save(new Hotel(null, "Hotel 2", 3, "Montpellier"));
    	c.save(new Chambre(null, "Chambre 1", 5, 29, 2));
    	c.save(new Chambre(null, "Chambre 2", 2, 41, 2));
    	c.save(new Chambre(null, "Chambre 3", 5, 28, 2));
    	c.save(new Chambre(null, "Chambre 4", 4, 62, 2));
    	c.save(new Chambre(null, "Chambre 5", 4, 35, 2));
    	c.save(new Chambre(null, "Chambre 6", 3, 46, 2));
    	c.save(new Chambre(null, "Chambre 7", 5, 32, 2));
    	c.save(new Chambre(null, "Chambre 8", 2, 45, 2));
    	c.save(new Chambre(null, "Chambre 9", 4, 58, 2));
    	c.save(new Chambre(null, "Chambre 10", 4, 59, 2));
    	c.save(new Chambre(null, "Chambre 11", 5, 61, 2));
    	c.save(new Chambre(null, "Chambre 12", 3, 29, 2));
    	p.save(new Partenaire(null, "Agence 1", "123", 79, 2));
    	p.save(new Partenaire(null, "Agence 2", "123", 52, 2));


    	h.save(new Hotel(null, "Hotel 3", 1, "Perpignan"));
    	c.save(new Chambre(null, "Chambre 1", 3, 27, 3));
    	c.save(new Chambre(null, "Chambre 2", 2, 29, 3));
    	c.save(new Chambre(null, "Chambre 3", 2, 31, 3));
    	c.save(new Chambre(null, "Chambre 4", 5, 29, 3));
    	c.save(new Chambre(null, "Chambre 5", 3, 44, 3));
    	c.save(new Chambre(null, "Chambre 6", 4, 37, 3));
    	c.save(new Chambre(null, "Chambre 7", 3, 52, 3));
    	c.save(new Chambre(null, "Chambre 8", 4, 49, 3));
    	c.save(new Chambre(null, "Chambre 9", 3, 65, 3));
    	c.save(new Chambre(null, "Chambre 10", 3, 63, 3));
    	c.save(new Chambre(null, "Chambre 11", 3, 64, 3));
    	c.save(new Chambre(null, "Chambre 12", 2, 33, 3));
    	p.save(new Partenaire(null, "Agence 1", "123", 35, 3));
    	p.save(new Partenaire(null, "Agence 2", "123", 65, 3));


    	h.save(new Hotel(null, "Hotel 4", 1, "Bordeau"));
    	c.save(new Chambre(null, "Chambre 1", 4, 62, 4));
    	c.save(new Chambre(null, "Chambre 2", 3, 56, 4));
    	c.save(new Chambre(null, "Chambre 3", 4, 22, 4));
    	c.save(new Chambre(null, "Chambre 4", 4, 33, 4));
    	c.save(new Chambre(null, "Chambre 5", 5, 40, 4));
    	c.save(new Chambre(null, "Chambre 6", 2, 35, 4));
    	c.save(new Chambre(null, "Chambre 7", 4, 44, 4));
    	c.save(new Chambre(null, "Chambre 8", 4, 26, 4));
    	c.save(new Chambre(null, "Chambre 9", 3, 28, 4));
    	c.save(new Chambre(null, "Chambre 10", 5, 53, 4));
    	c.save(new Chambre(null, "Chambre 11", 3, 61, 4));
    	c.save(new Chambre(null, "Chambre 12", 5, 45, 4));
    	p.save(new Partenaire(null, "Agence 1", "123", 15, 4));
    	p.save(new Partenaire(null, "Agence 2", "123", 45, 4));


    	h.save(new Hotel(null, "Hotel 5", 4, "Paris"));
    	c.save(new Chambre(null, "Chambre 1", 3, 22, 5));
    	c.save(new Chambre(null, "Chambre 2", 4, 46, 5));
    	c.save(new Chambre(null, "Chambre 3", 4, 62, 5));
    	c.save(new Chambre(null, "Chambre 4", 5, 44, 5));
    	c.save(new Chambre(null, "Chambre 5", 5, 43, 5));
    	c.save(new Chambre(null, "Chambre 6", 5, 44, 5));
    	c.save(new Chambre(null, "Chambre 7", 2, 38, 5));
    	c.save(new Chambre(null, "Chambre 8", 3, 42, 5));
    	c.save(new Chambre(null, "Chambre 9", 4, 64, 5));
    	c.save(new Chambre(null, "Chambre 10", 5, 46, 5));
    	c.save(new Chambre(null, "Chambre 11", 5, 32, 5));
    	c.save(new Chambre(null, "Chambre 12", 2, 35, 5));
    	p.save(new Partenaire(null, "Agence 1", "123", 75, 5));
    	p.save(new Partenaire(null, "Agence 2", "123", 33, 5));


    	h.save(new Hotel(null, "Hotel 6", 1, "Sete"));
    	c.save(new Chambre(null, "Chambre 1", 4, 52, 6));
    	c.save(new Chambre(null, "Chambre 2", 3, 39, 6));
    	c.save(new Chambre(null, "Chambre 3", 5, 48, 6));
    	c.save(new Chambre(null, "Chambre 4", 5, 49, 6));
    	c.save(new Chambre(null, "Chambre 5", 4, 24, 6));
    	c.save(new Chambre(null, "Chambre 6", 3, 37, 6));
    	c.save(new Chambre(null, "Chambre 7", 4, 39, 6));
    	c.save(new Chambre(null, "Chambre 8", 4, 60, 6));
    	c.save(new Chambre(null, "Chambre 9", 5, 47, 6));
    	c.save(new Chambre(null, "Chambre 10", 4, 57, 6));
    	c.save(new Chambre(null, "Chambre 11", 5, 31, 6));
    	c.save(new Chambre(null, "Chambre 12", 4, 60, 6));
    	p.save(new Partenaire(null, "Agence 1", "123", 76, 6));
    	p.save(new Partenaire(null, "Agence 2", "123", 71, 6));


    	h.save(new Hotel(null, "Hotel 7", 3, "Toulouse"));
    	c.save(new Chambre(null, "Chambre 1", 2, 34, 7));
    	c.save(new Chambre(null, "Chambre 2", 3, 59, 7));
    	c.save(new Chambre(null, "Chambre 3", 3, 32, 7));
    	c.save(new Chambre(null, "Chambre 4", 5, 30, 7));
    	c.save(new Chambre(null, "Chambre 5", 3, 31, 7));
    	c.save(new Chambre(null, "Chambre 6", 3, 41, 7));
    	c.save(new Chambre(null, "Chambre 7", 3, 46, 7));
    	c.save(new Chambre(null, "Chambre 8", 3, 49, 7));
    	c.save(new Chambre(null, "Chambre 9", 3, 38, 7));
    	c.save(new Chambre(null, "Chambre 10", 4, 61, 7));
    	c.save(new Chambre(null, "Chambre 11", 2, 29, 7));
    	c.save(new Chambre(null, "Chambre 12", 5, 64, 7));
    	p.save(new Partenaire(null, "Agence 1", "123", 52, 7));
    	p.save(new Partenaire(null, "Agence 2", "123", 55, 7));


    	cli.save(new Client(null, "Calogronan", "Piere", "79652"));
    	r.save(new Reservation(null, 36, 1, "6-1-1", "20-1-1"));
    	r.save(new Reservation(null, 5, 1, "20-1-1", "23-1-1"));
    	r.save(new Reservation(null, 63, 1, "7-1-1", "21-1-1"));


    	cli.save(new Client(null, "Yvain", "Virginie", "77866"));
    	r.save(new Reservation(null, 62, 2, "10-1-1", "23-1-1"));
    	r.save(new Reservation(null, 51, 2, "12-1-1", "22-1-1"));
    	r.save(new Reservation(null, 50, 2, "7-1-1", "23-1-1"));


    	cli.save(new Client(null, "Guenievre", "Jean", "68334"));
    	r.save(new Reservation(null, 63, 3, "12-1-1", "23-1-1"));
    	r.save(new Reservation(null, 45, 3, "10-1-1", "20-1-1"));
    	r.save(new Reservation(null, 1, 3, "8-1-1", "24-1-1"));


    	cli.save(new Client(null, "Guenievre", "Christophe", "93303"));
    	r.save(new Reservation(null, 59, 4, "5-1-1", "23-1-1"));
    	r.save(new Reservation(null, 72, 4, "14-1-1", "20-1-1"));
    	r.save(new Reservation(null, 16, 4, "6-1-1", "20-1-1"));


    	cli.save(new Client(null, "Gauvin", "Jean", "86175"));
    	r.save(new Reservation(null, 37, 5, "4-1-1", "21-1-1"));
    	r.save(new Reservation(null, 34, 5, "20-1-1", "23-1-1"));
    	r.save(new Reservation(null, 76, 5, "14-1-1", "22-1-1"));


    	cli.save(new Client(null, "Guenievre", "Paul", "81990"));
    	r.save(new Reservation(null, 82, 6, "12-1-1", "24-1-1"));
    	r.save(new Reservation(null, 54, 6, "10-1-1", "21-1-1"));
    	r.save(new Reservation(null, 45, 6, "5-1-1", "24-1-1"));


    	cli.save(new Client(null, "Caradoc", "Paul", "84226"));
    	r.save(new Reservation(null, 72, 7, "10-1-1", "21-1-1"));
    	r.save(new Reservation(null, 4, 7, "13-1-1", "24-1-1"));
    	r.save(new Reservation(null, 9, 7, "10-1-1", "21-1-1"));
    	}
}