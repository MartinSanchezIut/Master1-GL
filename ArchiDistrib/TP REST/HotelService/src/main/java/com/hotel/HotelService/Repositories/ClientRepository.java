package com.hotel.HotelService.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.HotelService.Model.Client;


public interface ClientRepository extends JpaRepository<Client,Long>{
	
	Optional<Client> findById(Long id);
	List<Client> findAll();
}
