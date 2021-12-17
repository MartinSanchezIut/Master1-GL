package com.hotel.HotelService.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotel.HotelService.Model.Partenaire;

public interface PartenaireRepository extends JpaRepository<Partenaire,Long>{
	
	Optional<Partenaire> findById(Long id);
	List<Partenaire> findAll();
	
	@Query(value = "SELECT * FROM partenaire WHERE hotel = :id", nativeQuery = true)	
	List<Partenaire> findPartenairesDe(@Param(value="id") long id);
	
	
}
