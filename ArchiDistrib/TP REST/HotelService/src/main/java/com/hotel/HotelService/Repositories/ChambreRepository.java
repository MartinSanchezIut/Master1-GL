package com.hotel.HotelService.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotel.HotelService.Model.Chambre;


public interface ChambreRepository extends JpaRepository<Chambre,Long>{
	
	Optional<Chambre> findById(Long id);
	List<Chambre> findAll();
	
	@Query(value = "SELECT * FROM chambre WHERE hotel = :id", nativeQuery = true)	
	List<Chambre> findChambreDe(@Param(value="id") long id);
	
}
