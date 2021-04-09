package com.example.LibraryProject.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryProject.dto.EscritoresDTO;
import com.example.LibraryProject.entities.Escritores;
import com.example.LibraryProject.services.EscritoresService;

@RestController
@RequestMapping(value="/escritores")
public class EscritoresResource {
	
	@Autowired
	private EscritoresService service;
	
	@GetMapping
	public ResponseEntity<List<EscritoresDTO>> findAll(){
		List<Escritores> list = service.findAll();
		List<EscritoresDTO> listDTO = list.stream().map(x -> new EscritoresDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Escritores> findById(@PathVariable Long id){
		Escritores obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
