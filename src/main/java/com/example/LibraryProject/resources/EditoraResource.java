package com.example.LibraryProject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryProject.entities.Editora;
import com.example.LibraryProject.services.EditoraService;

@RestController
@RequestMapping(value="/editoras")
public class EditoraResource {
	
	@Autowired
	private EditoraService service;
	
	@GetMapping
	public ResponseEntity<List<Editora>> findAll(){
		List<Editora> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Editora> findById(@PathVariable Long id){
		Editora obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
