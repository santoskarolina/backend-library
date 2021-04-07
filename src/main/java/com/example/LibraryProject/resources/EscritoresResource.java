package com.example.LibraryProject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryProject.entities.Escritores;
import com.example.LibraryProject.services.EscritoresService;

@RestController
@RequestMapping(value="/escritores")
public class EscritoresResource {
	
	@Autowired
	private EscritoresService service;
	
	@GetMapping
	public ResponseEntity<List<Escritores>> findAll(){
		List<Escritores> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Escritores> findById(@PathVariable Long id){
		Escritores obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
