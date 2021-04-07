package com.example.LibraryProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LibraryProject.entities.Categoria;
import com.example.LibraryProject.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	public CategoriaRepository respository;
	
	public List<Categoria> findAll(){
		return respository.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> bk = respository.findById(id);
		return bk.get();
	}
	
	public Categoria insert(Categoria obj) {
		return respository.save(obj);
	}
	
	public Categoria update(Long id, Categoria obj) {
		Categoria entity = respository.getOne(id);
		updateDate(entity,obj);
		return respository.save(entity);
	}

	private void updateDate(Categoria entity, Categoria obj) {
		entity.setName(obj.getName());
	}
}
