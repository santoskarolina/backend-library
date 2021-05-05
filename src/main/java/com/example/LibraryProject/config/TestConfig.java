package com.example.LibraryProject.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.LibraryProject.entities.Book;
import com.example.LibraryProject.entities.Categoria;
import com.example.LibraryProject.repositories.BookRepository;
import com.example.LibraryProject.repositories.CategoriaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		bookRepository.deleteAll();
		categoriaRepository.deleteAll();
		
		Categoria c1 = new Categoria(null, "Romance");
		Categoria c2 = new Categoria(null, "Ação");
		Categoria c3 = new Categoria(null, "Cientifico");
		Categoria c4 = new Categoria(null, "Drama");
		categoriaRepository.saveAll(Arrays.asList(c1,c2,c3,c4));
		
		Book b1 = new Book(null, "Wonder", "photo1", "Lorem lorem", "Rocco","John Bill" ,c1 );
		Book b2 = new Book(null, "Harry Potter 2", "photo1", "Lorem lorem", "Rocco", "Ruy Barsosa",c1);
		Book b3 = new Book(null, "Bible", "photo3", "Lorem lorem", "Rocco", "Justin Jason",c2);
		Book b4 = new Book(null, "New Book", "photo4","Lorem lorem", "Rocco","Anne jason", c3);
		Book b5 = new Book(null, "New Book2", "photo5","Lorem lorem", "Rocco", "Richard Green",c4);
		bookRepository.saveAll(Arrays.asList(b1,b2,b3,b4,b5));
	
		c1.getLivros().add(b1);
		c1.getLivros().add(b5);
		c2.getLivros().add(b2);
		c3.getLivros().add(b3);
		c4.getLivros().add(b4);
		categoriaRepository.saveAll(Arrays.asList(c1,c2,c3,c4));
	}	
}
