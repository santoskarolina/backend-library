package com.example.LibraryProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.LibraryProject.entities.Categoria;
import com.example.LibraryProject.repositories.CategoriaRepository;
import com.example.LibraryProject.services.exception.DatabaseException;
import com.example.LibraryProject.services.exception.ResourceNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	public CategoriaRepository respository;
	
	public List<Categoria> findAll(){
		return respository.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> bk = respository.findById(id);
		return bk.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Categoria insert(Categoria obj) {
		return respository.save(obj);
	}
	
	public Categoria update(Long id, Categoria obj) {
		Categoria entity = respository.getOne(id);
		updateDate(entity,obj);
		return respository.save(entity);
	}
	
	public void delete(Long id) {
		try {
			respository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}

	private void updateDate(Categoria entity, Categoria obj) {
		entity.setName(obj.getName());
	}
	
}
