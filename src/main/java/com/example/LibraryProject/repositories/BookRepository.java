package com.example.LibraryProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.LibraryProject.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Book obj WHERE obj.categoria.id = :categoriaId ORDER BY obj.name")
	public List<Book> findBooks(@Param("categoriaId") Long categoriaId);
	
}
