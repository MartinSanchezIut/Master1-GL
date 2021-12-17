package com.hotel.HotelService.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotel.HotelService.Model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long>{
	
	Optional<Reservation> findById(Long id);
	List<Reservation> findAll();
	
	@Query(value = "SELECT * FROM reservation WHERE chambre = :id", nativeQuery = true)
	List<Reservation> getReservationOfChambre(@Param(value="id") long id);
	
	/*
	@Modifying
	@Query(value = "insert into reservation(id, chambre, client, debut, fin) values (1, 1, 1, '0000-00-00', '1000-00-00')", nativeQuery = true)
	public void reserverChambre(@Param(value="id") long id);
	*/
}
