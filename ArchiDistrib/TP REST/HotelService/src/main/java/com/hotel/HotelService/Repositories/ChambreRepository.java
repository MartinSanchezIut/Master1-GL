package com.hotel.HotelService.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.HotelService.Model.Chambre;


public interface ChambreRepository extends JpaRepository<Chambre,Long>{
	
	Optional<Chambre> findById(Long id);
	List<Chambre> findAll();
}
