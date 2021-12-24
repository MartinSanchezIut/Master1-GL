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
    	String img_path = "src/main/resources/IMG/" ;
    	h.save(new Hotel(null, "Hotel 1", 3, "Pau"));
    	c.save(new Chambre(null, "Chambre 1", 5, 53, (img_path + "chambre.jpg"), 1));
    	c.save(new Chambre(null, "Chambre 2", 3, 25, (img_path + "chambre.jpg"), 1));
    	c.save(new Chambre(null, "Chambre 3", 5, 43, (img_path + "chambre.jpg"), 1));
    	c.save(new Chambre(null, "Chambre 4", 4, 57, (img_path + "chambre.jpg"), 1));
    	c.save(new Chambre(null, "Chambre 5", 4, 45, (img_path + "chambre.jpg"), 1));
    	c.save(new Chambre(null, "Chambre 6", 5, 40, (img_path + "chambre.jpg"), 1));
    	c.save(new Chambre(null, "Chambre 7", 2, 64, (img_path + "chambre.jpg"), 1));
    	c.save(new Chambre(null, "Chambre 8", 3, 44, (img_path + "chambre.jpg"), 1));
    	c.save(new Chambre(null, "Chambre 9", 3, 61, (img_path + "chambre.jpg"), 1));
    	c.save(new Chambre(null, "Chambre 10", 3, 37, (img_path + "chambre.jpg"), 1));
    	c.save(new Chambre(null, "Chambre 11", 4, 64, (img_path + "chambre.jpg"), 1));
    	c.save(new Chambre(null, "Chambre 12", 3, 37, (img_path + "chambre.jpg"), 1));
    	p.save(new Partenaire(null, "Agence 1", "123", 35, 1));
    	p.save(new Partenaire(null, "Agence 2", "123", 47, 1));


    	h.save(new Hotel(null, "Hotel 2", 3, "Montpellier"));
    	c.save(new Chambre(null, "Chambre 1", 5, 29, (img_path + "chambre1.jpg"), 2));
    	c.save(new Chambre(null, "Chambre 2", 2, 41, (img_path + "chambre1.jpg"), 2));
    	c.save(new Chambre(null, "Chambre 3", 5, 28, (img_path + "chambre1.jpg"), 2));
    	c.save(new Chambre(null, "Chambre 4", 4, 62, (img_path + "chambre1.jpg"), 2));
    	c.save(new Chambre(null, "Chambre 5", 4, 35, (img_path + "chambre1.jpg"), 2));
    	c.save(new Chambre(null, "Chambre 6", 3, 46, (img_path + "chambre1.jpg"), 2));
    	c.save(new Chambre(null, "Chambre 7", 5, 32, (img_path + "chambre1.jpg"), 2));
    	c.save(new Chambre(null, "Chambre 8", 2, 45, (img_path + "chambre1.jpg"), 2));
    	c.save(new Chambre(null, "Chambre 9", 4, 58, (img_path + "chambre1.jpg"), 2));
    	c.save(new Chambre(null, "Chambre 10", 4, 59, (img_path + "chambre1.jpg"), 2));
    	c.save(new Chambre(null, "Chambre 11", 5, 61, (img_path + "chambre1.jpg"), 2));
    	c.save(new Chambre(null, "Chambre 12", 3, 29, (img_path + "chambre1.jpg"), 2));
    	p.save(new Partenaire(null, "Agence 1", "123", 79, 2));
    	p.save(new Partenaire(null, "Agence 2", "123", 52, 2));


    	h.save(new Hotel(null, "Hotel 3", 1, "Perpignan"));
    	c.save(new Chambre(null, "Chambre 1", 3, 27, (img_path + "chambre1.jpg"), 3));
    	c.save(new Chambre(null, "Chambre 2", 2, 29, (img_path + "chambre1.jpg"), 3));
    	c.save(new Chambre(null, "Chambre 3", 2, 31, (img_path + "chambre1.jpg"), 3));
    	c.save(new Chambre(null, "Chambre 4", 5, 29, (img_path + "chambre1.jpg"), 3));
    	c.save(new Chambre(null, "Chambre 5", 3, 44, (img_path + "chambre1.jpg"), 3));
    	c.save(new Chambre(null, "Chambre 6", 4, 37, (img_path + "chambre1.jpg"), 3));
    	c.save(new Chambre(null, "Chambre 7", 3, 52, (img_path + "chambre1.jpg"), 3));
    	c.save(new Chambre(null, "Chambre 8", 4, 49, (img_path + "chambre1.jpg"), 3));
    	c.save(new Chambre(null, "Chambre 9", 3, 65, (img_path + "chambre1.jpg"), 3));
    	c.save(new Chambre(null, "Chambre 10", 3, 63, (img_path + "chambre1.jpg"), 3));
    	c.save(new Chambre(null, "Chambre 11", 3, 64, (img_path + "chambre1.jpg"), 3));
    	c.save(new Chambre(null, "Chambre 12", 2, 33, (img_path + "chambre1.jpg"), 3));
    	p.save(new Partenaire(null, "Agence 1", "123", 35, 3));
    	p.save(new Partenaire(null, "Agence 2", "123", 65, 3));


    	h.save(new Hotel(null, "Hotel 4", 1, "Bordeau"));
    	c.save(new Chambre(null, "Chambre 1", 4, 62, (img_path + "chambre.jpg"), 4));
    	c.save(new Chambre(null, "Chambre 2", 3, 56, (img_path + "chambre.jpg"), 4));
    	c.save(new Chambre(null, "Chambre 3", 4, 22, (img_path + "chambre.jpg"), 4));
    	c.save(new Chambre(null, "Chambre 4", 4, 33, (img_path + "chambre.jpg"), 4));
    	c.save(new Chambre(null, "Chambre 5", 5, 40, (img_path + "chambre.jpg"), 4));
    	c.save(new Chambre(null, "Chambre 6", 2, 35, (img_path + "chambre.jpg"), 4));
    	c.save(new Chambre(null, "Chambre 7", 4, 44, (img_path + "chambre.jpg"), 4));
    	c.save(new Chambre(null, "Chambre 8", 4, 26, (img_path + "chambre.jpg"), 4));
    	c.save(new Chambre(null, "Chambre 9", 3, 28, (img_path + "chambre.jpg"), 4));
    	c.save(new Chambre(null, "Chambre 10", 5, 53, (img_path + "chambre.jpg"), 4));
    	c.save(new Chambre(null, "Chambre 11", 3, 61, (img_path + "chambre.jpg"), 4));
    	c.save(new Chambre(null, "Chambre 12", 5, 45, (img_path + "chambre.jpg"), 4));
    	p.save(new Partenaire(null, "Agence 1", "123", 15, 4));
    	p.save(new Partenaire(null, "Agence 2", "123", 45, 4));


    	h.save(new Hotel(null, "Hotel 5", 4, "Paris"));
    	c.save(new Chambre(null, "Chambre 1", 3, 22, (img_path + "chambre1.jpg"), 5));
    	c.save(new Chambre(null, "Chambre 2", 4, 46, (img_path + "chambre1.jpg"), 5));
    	c.save(new Chambre(null, "Chambre 3", 4, 62, (img_path + "chambre1.jpg"), 5));
    	c.save(new Chambre(null, "Chambre 4", 5, 44, (img_path + "chambre1.jpg"), 5));
    	c.save(new Chambre(null, "Chambre 5", 5, 43, (img_path + "chambre1.jpg"), 5));
    	c.save(new Chambre(null, "Chambre 6", 5, 44, (img_path + "chambre1.jpg"), 5));
    	c.save(new Chambre(null, "Chambre 7", 2, 38, (img_path + "chambre1.jpg"), 5));
    	c.save(new Chambre(null, "Chambre 8", 3, 42, (img_path + "chambre1.jpg"), 5));
    	c.save(new Chambre(null, "Chambre 9", 4, 64, (img_path + "chambre1.jpg"), 5));
    	c.save(new Chambre(null, "Chambre 10", 5, 46, (img_path + "chambre1.jpg"), 5));
    	c.save(new Chambre(null, "Chambre 11", 5, 32, (img_path + "chambre1.jpg"), 5));
    	c.save(new Chambre(null, "Chambre 12", 2, 35, (img_path + "chambre1.jpg"), 5));
    	p.save(new Partenaire(null, "Agence 1", "123", 75, 5));
    	p.save(new Partenaire(null, "Agence 2", "123", 33, 5));


    	h.save(new Hotel(null, "Hotel 6", 1, "Sete"));
    	c.save(new Chambre(null, "Chambre 1", 4, 52, (img_path + "chambre.jpg"), 6));
    	c.save(new Chambre(null, "Chambre 2", 3, 39, (img_path + "chambre.jpg"), 6));
    	c.save(new Chambre(null, "Chambre 3", 5, 48, (img_path + "chambre.jpg"), 6));
    	c.save(new Chambre(null, "Chambre 4", 5, 49, (img_path + "chambre.jpg"), 6));
    	c.save(new Chambre(null, "Chambre 5", 4, 24, (img_path + "chambre.jpg"), 6));
    	c.save(new Chambre(null, "Chambre 6", 3, 37, (img_path + "chambre.jpg"), 6));
    	c.save(new Chambre(null, "Chambre 7", 4, 39, (img_path + "chambre.jpg"), 6));
    	c.save(new Chambre(null, "Chambre 8", 4, 60, (img_path + "chambre.jpg"), 6));
    	c.save(new Chambre(null, "Chambre 9", 5, 47, (img_path + "chambre.jpg"), 6));
    	c.save(new Chambre(null, "Chambre 10", 4, 57, (img_path + "chambre.jpg"), 6));
    	c.save(new Chambre(null, "Chambre 11", 5, 31, (img_path + "chambre.jpg"), 6));
    	c.save(new Chambre(null, "Chambre 12", 4, 60, (img_path + "chambre.jpg"), 6));
    	p.save(new Partenaire(null, "Agence 1", "123", 76, 6));
    	p.save(new Partenaire(null, "Agence 2", "123", 71, 6));


    	h.save(new Hotel(null, "Hotel 7", 3, "Toulouse"));
    	c.save(new Chambre(null, "Chambre 1", 2, 34, (img_path + "chambre1.jpg"), 7));
    	c.save(new Chambre(null, "Chambre 2", 3, 59, (img_path + "chambre1.jpg"), 7));
    	c.save(new Chambre(null, "Chambre 3", 3, 32, (img_path + "chambre1.jpg"), 7));
    	c.save(new Chambre(null, "Chambre 4", 5, 30, (img_path + "chambre1.jpg"), 7));
    	c.save(new Chambre(null, "Chambre 5", 3, 31, (img_path + "chambre1.jpg"), 7));
    	c.save(new Chambre(null, "Chambre 6", 3, 41, (img_path + "chambre1.jpg"), 7));
    	c.save(new Chambre(null, "Chambre 7", 3, 46, (img_path + "chambre1.jpg"), 7));
    	c.save(new Chambre(null, "Chambre 8", 3, 49, (img_path + "chambre1.jpg"), 7));
    	c.save(new Chambre(null, "Chambre 9", 3, 38, (img_path + "chambre1.jpg"), 7));
    	c.save(new Chambre(null, "Chambre 10", 4, 61, (img_path + "chambre1.jpg"), 7));
    	c.save(new Chambre(null, "Chambre 11", 2, 29, (img_path + "chambre1.jpg"), 7));
    	c.save(new Chambre(null, "Chambre 12", 5, 64, (img_path + "chambre1.jpg"), 7));
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