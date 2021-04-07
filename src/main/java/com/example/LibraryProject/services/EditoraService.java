package com.example.LibraryProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LibraryProject.entities.Editora;
import com.example.LibraryProject.repositories.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	public EditoraRepository respository;
	
	public List<Editora> findAll(){
		return respository.findAll();
	}
	
	public Editora findById(Long id) {
		Optional<Editora> bk = respository.findById(id);
		return bk.get();
	}
}
