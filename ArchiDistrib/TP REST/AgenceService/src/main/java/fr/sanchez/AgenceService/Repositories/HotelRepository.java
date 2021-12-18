package fr.sanchez.AgenceService.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import fr.sanchez.AgenceService.Model.Hotel;

public interface HotelRepository  extends JpaRepository<Hotel,Long>{
	
	Optional<Hotel> findById(Long id);
	List<Hotel> findAll();
	
	
	@Query(value = "SELECT * FROM hotel WHERE agence = :id", nativeQuery = true)	
	List<Hotel> findHotelDe(@Param(value="id") long id);
}
