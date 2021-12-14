package com.hotel.HotelService.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hotel.HotelService.Model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,Long>{
	
	Optional<Hotel> findById(Long id);
	List<Hotel> findAll();
}

