package com.example.LibraryProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibraryProject.entities.Escritores;

public interface EscritoresRepository extends JpaRepository<Escritores, Long>{
	
}
