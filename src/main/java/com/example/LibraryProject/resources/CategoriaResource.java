package com.example.LibraryProject.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.LibraryProject.dto.CategoriasDTO;
import com.example.LibraryProject.entities.Categoria;
import com.example.LibraryProject.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public ResponseEntity<List<CategoriasDTO>> findAll(){
		List<Categoria> list = service.findAll();
		List<CategoriasDTO> listDTO = list.stream().map(x -> new CategoriasDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		Categoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> insert(@RequestBody Categoria obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
