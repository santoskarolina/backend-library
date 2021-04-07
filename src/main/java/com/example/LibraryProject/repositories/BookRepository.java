package com.example.LibraryProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LibraryProject.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	
}
