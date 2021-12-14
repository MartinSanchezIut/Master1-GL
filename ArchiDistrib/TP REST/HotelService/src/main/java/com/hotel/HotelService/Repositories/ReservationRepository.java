package com.hotel.HotelService.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.HotelService.Model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long>{
	
	Optional<Reservation> findById(Long id);
	List<Reservation> findAll();

}
