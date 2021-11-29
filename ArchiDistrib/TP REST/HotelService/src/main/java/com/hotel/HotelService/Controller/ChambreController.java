package com.hotel.HotelService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.HotelService.Model.Chambre;
import com.hotel.HotelService.Repositories.ChambreRepository;

@RestController
public class ChambreController {
	
	@Autowired
	public ChambreRepository repo;
	
	@GetMapping("/chambres")
	public List<Chambre> getAllChambres(){
		return repo.findAll();
	}

}
