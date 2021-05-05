package com.example.LibraryProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.LibraryProject.entities.Book;
import com.example.LibraryProject.repositories.BookRepository;
import com.example.LibraryProject.services.exception.ResourceNotFoundException;

@Service
public class BookService {

	@Autowired
	public BookRepository respository;
	
	public Book findById(Long id) {
		Optional<Book> bk = respository.findById(id);
		return bk.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Book insert(Book obj) {
		return respository.save(obj);
	}
	
	public Book update(Long id, Book obj) {
		Book entity = respository.getOne(id);
		updateDate(entity,obj);
		return respository.save(entity);
	}

	public void delete(Long id) {
		Book obj = findById(id);
		try {
			respository.delete(obj);
		}catch(DataIntegrityViolationException e ) {
			throw new ResourceNotFoundException("Categoria não pode ser deletada! Possui livros associados");
		}	
	}
	private void updateDate(Book entity, Book obj) {
		entity.setName(obj.getName());
		entity.setPhoto(obj.getPhoto());
		entity.setEditora(obj.getEditora());
	}
	
	public List<Book> findbyCategoria(Long categoriaId){
		return respository.findBooks(categoriaId);
	}
}
