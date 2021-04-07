package com.example.LibraryProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LibraryProject.entities.Escritores;
import com.example.LibraryProject.repositories.EscritoresRepository;

@Service
public class EscritoresService {

	@Autowired
	public EscritoresRepository respository;
	
	public List<Escritores> findAll(){
		return respository.findAll();
	}
	
	public Escritores findById(Long id) {
		Optional<Escritores> bk = respository.findById(id);
		return bk.get();
	}
}
