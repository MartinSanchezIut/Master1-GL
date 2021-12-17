package com.hotel.HotelService.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.HotelService.Model.Client;


public interface ClientRepository extends JpaRepository<Client,Long>{
	
	Optional<Client> findById(Long id);
	List<Client> findAll();
	
	/*
	@Modifying
	@Query(value = "insert into client (id, name, surname, card) values (:id, :name, :surname, :card)", nativeQuery = true)
	public void addClient(@Param("id") Long id,
						  @Param("name") String name,
						  @Param("surname") String surname,
						  @Param("card") String card) ;

	@Modifying
	@Query(value = "insert into client (name, surname, card) values (:name, :surname, :card)", nativeQuery = true)
	public void addClient2(@Param("name") String name,
						   @Param("surname") String surname,
						   @Param("card") String card) ;
	 */
}
