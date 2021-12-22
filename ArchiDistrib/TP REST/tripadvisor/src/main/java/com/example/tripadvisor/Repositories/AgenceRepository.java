package com.example.tripadvisor.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tripadvisor.Model.Agence;

public interface AgenceRepository extends JpaRepository<Agence,Long>{
	
	Optional<Agence> findById(Long id);
	List<Agence> findAll();
}
