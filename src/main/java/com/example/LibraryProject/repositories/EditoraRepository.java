package com.example.LibraryProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibraryProject.entities.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long>{
	
}
