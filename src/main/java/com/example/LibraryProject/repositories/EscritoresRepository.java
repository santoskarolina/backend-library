package com.example.LibraryProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibraryProject.entities.Escritores;

@Repository
public interface EscritoresRepository extends JpaRepository<Escritores, Long>{
	
}
