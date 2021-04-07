package com.example.LibraryProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibraryProject.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
}
