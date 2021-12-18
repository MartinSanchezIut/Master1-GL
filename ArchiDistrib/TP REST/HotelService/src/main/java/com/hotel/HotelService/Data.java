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
    	h.save(new Hotel(null, "Hotel 0", 5, "Sete"));
    	c.save(new Chambre(null, "Chambre 0", 2, 47, 0));
    	c.save(new Chambre(null, "Chambre 1", 4, 33, 0));
    	c.save(new Chambre(null, "Chambre 2", 2, 39, 0));
    	c.save(new Chambre(null, "Chambre 3", 4, 55, 0));
    	c.save(new Chambre(null, "Chambre 4", 3, 43, 0));
    	c.save(new Chambre(null, "Chambre 5", 3, 35, 0));
    	c.save(new Chambre(null, "Chambre 6", 3, 37, 0));
    	c.save(new Chambre(null, "Chambre 7", 3, 28, 0));
    	c.save(new Chambre(null, "Chambre 8", 5, 37, 0));
    	c.save(new Chambre(null, "Chambre 9", 4, 32, 0));
    	c.save(new Chambre(null, "Chambre 10", 2, 51, 0));
    	c.save(new Chambre(null, "Chambre 11", 3, 62, 0));
    	p.save(new Partenaire(null, "Agence 0", "123", 25, 0));
    	p.save(new Partenaire(null, "Agence 1", "123", 20, 0));


    	h.save(new Hotel(null, "Hotel 1", 3, "Bordeau"));
    	c.save(new Chambre(null, "Chambre 0", 5, 44, 1));
    	c.save(new Chambre(null, "Chambre 1", 4, 25, 1));
    	c.save(new Chambre(null, "Chambre 2", 3, 60, 1));
    	c.save(new Chambre(null, "Chambre 3", 5, 58, 1));
    	c.save(new Chambre(null, "Chambre 4", 3, 23, 1));
    	c.save(new Chambre(null, "Chambre 5", 3, 50, 1));
    	c.save(new Chambre(null, "Chambre 6", 3, 23, 1));
    	c.save(new Chambre(null, "Chambre 7", 2, 54, 1));
    	c.save(new Chambre(null, "Chambre 8", 4, 51, 1));
    	c.save(new Chambre(null, "Chambre 9", 3, 44, 1));
    	c.save(new Chambre(null, "Chambre 10", 4, 44, 1));
    	c.save(new Chambre(null, "Chambre 11", 3, 33, 1));
    	p.save(new Partenaire(null, "Agence 0", "123", 73, 1));
    	p.save(new Partenaire(null, "Agence 1", "123", 22, 1));


    	h.save(new Hotel(null, "Hotel 2", 2, "Perpignan"));
    	c.save(new Chambre(null, "Chambre 0", 4, 38, 2));
    	c.save(new Chambre(null, "Chambre 1", 3, 50, 2));
    	c.save(new Chambre(null, "Chambre 2", 4, 34, 2));
    	c.save(new Chambre(null, "Chambre 3", 4, 52, 2));
    	c.save(new Chambre(null, "Chambre 4", 3, 56, 2));
    	c.save(new Chambre(null, "Chambre 5", 5, 45, 2));
    	c.save(new Chambre(null, "Chambre 6", 2, 42, 2));
    	c.save(new Chambre(null, "Chambre 7", 4, 57, 2));
    	c.save(new Chambre(null, "Chambre 8", 3, 45, 2));
    	c.save(new Chambre(null, "Chambre 9", 3, 53, 2));
    	c.save(new Chambre(null, "Chambre 10", 5, 57, 2));
    	c.save(new Chambre(null, "Chambre 11", 2, 51, 2));
    	p.save(new Partenaire(null, "Agence 0", "123", 75, 2));
    	p.save(new Partenaire(null, "Agence 1", "123", 40, 2));


    	h.save(new Hotel(null, "Hotel 3", 0, "Paris"));
    	c.save(new Chambre(null, "Chambre 0", 5, 51, 3));
    	c.save(new Chambre(null, "Chambre 1", 5, 29, 3));
    	c.save(new Chambre(null, "Chambre 2", 4, 38, 3));
    	c.save(new Chambre(null, "Chambre 3", 2, 60, 3));
    	c.save(new Chambre(null, "Chambre 4", 4, 53, 3));
    	c.save(new Chambre(null, "Chambre 5", 3, 28, 3));
    	c.save(new Chambre(null, "Chambre 6", 4, 63, 3));
    	c.save(new Chambre(null, "Chambre 7", 3, 33, 3));
    	c.save(new Chambre(null, "Chambre 8", 5, 64, 3));
    	c.save(new Chambre(null, "Chambre 9", 4, 48, 3));
    	c.save(new Chambre(null, "Chambre 10", 5, 50, 3));
    	c.save(new Chambre(null, "Chambre 11", 5, 36, 3));
    	p.save(new Partenaire(null, "Agence 0", "123", 47, 3));
    	p.save(new Partenaire(null, "Agence 1", "123", 40, 3));


    	h.save(new Hotel(null, "Hotel 4", 5, "Paris"));
    	c.save(new Chambre(null, "Chambre 0", 5, 38, 4));
    	c.save(new Chambre(null, "Chambre 1", 5, 28, 4));
    	c.save(new Chambre(null, "Chambre 2", 2, 60, 4));
    	c.save(new Chambre(null, "Chambre 3", 4, 65, 4));
    	c.save(new Chambre(null, "Chambre 4", 3, 26, 4));
    	c.save(new Chambre(null, "Chambre 5", 4, 45, 4));
    	c.save(new Chambre(null, "Chambre 6", 3, 64, 4));
    	c.save(new Chambre(null, "Chambre 7", 5, 27, 4));
    	c.save(new Chambre(null, "Chambre 8", 4, 60, 4));
    	c.save(new Chambre(null, "Chambre 9", 4, 22, 4));
    	c.save(new Chambre(null, "Chambre 10", 3, 33, 4));
    	c.save(new Chambre(null, "Chambre 11", 4, 22, 4));
    	p.save(new Partenaire(null, "Agence 0", "123", 79, 4));
    	p.save(new Partenaire(null, "Agence 1", "123", 22, 4));


    	h.save(new Hotel(null, "Hotel 5", 2, "Paris"));
    	c.save(new Chambre(null, "Chambre 0", 4, 59, 5));
    	c.save(new Chambre(null, "Chambre 1", 5, 62, 5));
    	c.save(new Chambre(null, "Chambre 2", 5, 59, 5));
    	c.save(new Chambre(null, "Chambre 3", 5, 31, 5));
    	c.save(new Chambre(null, "Chambre 4", 3, 25, 5));
    	c.save(new Chambre(null, "Chambre 5", 5, 59, 5));
    	c.save(new Chambre(null, "Chambre 6", 2, 62, 5));
    	c.save(new Chambre(null, "Chambre 7", 2, 62, 5));
    	c.save(new Chambre(null, "Chambre 8", 4, 58, 5));
    	c.save(new Chambre(null, "Chambre 9", 3, 55, 5));
    	c.save(new Chambre(null, "Chambre 10", 3, 23, 5));
    	c.save(new Chambre(null, "Chambre 11", 4, 53, 5));
    	p.save(new Partenaire(null, "Agence 0", "123", 77, 5));
    	p.save(new Partenaire(null, "Agence 1", "123", 30, 5));


    	h.save(new Hotel(null, "Hotel 6", 4, "Bordeau"));
    	c.save(new Chambre(null, "Chambre 0", 3, 27, 6));
    	c.save(new Chambre(null, "Chambre 1", 4, 26, 6));
    	c.save(new Chambre(null, "Chambre 2", 4, 59, 6));
    	c.save(new Chambre(null, "Chambre 3", 4, 25, 6));
    	c.save(new Chambre(null, "Chambre 4", 2, 63, 6));
    	c.save(new Chambre(null, "Chambre 5", 3, 56, 6));
    	c.save(new Chambre(null, "Chambre 6", 4, 52, 6));
    	c.save(new Chambre(null, "Chambre 7", 3, 26, 6));
    	c.save(new Chambre(null, "Chambre 8", 3, 36, 6));
    	c.save(new Chambre(null, "Chambre 9", 5, 40, 6));
    	c.save(new Chambre(null, "Chambre 10", 4, 64, 6));
    	c.save(new Chambre(null, "Chambre 11", 5, 44, 6));
    	p.save(new Partenaire(null, "Agence 0", "123", 21, 6));
    	p.save(new Partenaire(null, "Agence 1", "123", 22, 6));


    	cli.save(new Client(null, "Yvain", "Paul", "81216"));
    	r.save(new Reservation(null, 7, 0, "20-1-1", "20-1-1"));
    	r.save(new Reservation(null, 4, 0, "16-1-1", "21-1-1"));
    	r.save(new Reservation(null, 41, 0, "7-1-1", "20-1-1"));


    	cli.save(new Client(null, "Caradoc", "Christophe", "87956"));
    	r.save(new Reservation(null, 28, 1, "6-1-1", "22-1-1"));
    	r.save(new Reservation(null, 65, 1, "6-1-1", "23-1-1"));
    	r.save(new Reservation(null, 26, 1, "8-1-1", "20-1-1"));


    	cli.save(new Client(null, "Gauvin", "Jean", "70249"));
    	r.save(new Reservation(null, 59, 2, "5-1-1", "21-1-1"));
    	r.save(new Reservation(null, 64, 2, "18-1-1", "20-1-1"));
    	r.save(new Reservation(null, 15, 2, "1-1-1", "24-1-1"));


    	cli.save(new Client(null, "Guenievre", "Paul", "95565"));
    	r.save(new Reservation(null, 65, 3, "19-1-1", "23-1-1"));
    	r.save(new Reservation(null, 60, 3, "10-1-1", "24-1-1"));
    	r.save(new Reservation(null, 67, 3, "5-1-1", "22-1-1"));


    	cli.save(new Client(null, "Perceval", "Estelle", "92277"));
    	r.save(new Reservation(null, 26, 4, "16-1-1", "21-1-1"));
    	r.save(new Reservation(null, 75, 4, "12-1-1", "22-1-1"));
    	r.save(new Reservation(null, 83, 4, "9-1-1", "23-1-1"));


    	cli.save(new Client(null, "Provencal", "Jacques", "81656"));
    	r.save(new Reservation(null, 81, 5, "17-1-1", "22-1-1"));
    	r.save(new Reservation(null, 47, 5, "15-1-1", "21-1-1"));
    	r.save(new Reservation(null, 49, 5, "8-1-1", "20-1-1"));


    	cli.save(new Client(null, "Caradoc", "Jean", "75459"));
    	r.save(new Reservation(null, 20, 6, "12-1-1", "24-1-1"));
    	r.save(new Reservation(null, 41, 6, "15-1-1", "21-1-1"));
    	r.save(new Reservation(null, 40, 6, "17-1-1", "22-1-1"));
    	}
}