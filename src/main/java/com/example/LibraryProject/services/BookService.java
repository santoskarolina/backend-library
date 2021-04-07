package com.example.LibraryProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LibraryProject.entities.Book;
import com.example.LibraryProject.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	public BookRepository respository;
	
	public List<Book> findAll(){
		return respository.findAll();
	}
	
	public Book findById(Long id) {
		Optional<Book> bk = respository.findById(id);
		return bk.get();
	}
	
	public Book insert(Book obj) {
		return respository.save(obj);
	}
	
	public Book update(Long id, Book obj) {
		Book entity = respository.getOne(id);
		updateDate(entity,obj);
		return respository.save(entity);
	}

	private void updateDate(Book entity, Book obj) {
		entity.setName(obj.getName());
		entity.setPhoto(obj.getPhoto());
	}
}
