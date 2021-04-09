package com.example.LibraryProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibraryProject.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
}
