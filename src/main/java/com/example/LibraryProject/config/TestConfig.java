package com.example.LibraryProject.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.LibraryProject.entities.Book;
import com.example.LibraryProject.entities.Categoria;
import com.example.LibraryProject.entities.Editora;
import com.example.LibraryProject.entities.Escritores;
import com.example.LibraryProject.repositories.BookRepository;
import com.example.LibraryProject.repositories.CategoriaRepository;
import com.example.LibraryProject.repositories.EditoraRepository;
import com.example.LibraryProject.repositories.EscritoresRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private EscritoresRepository escritoresRepository;
	
	@Autowired
	private EditoraRepository editoraRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Escritores e1 = new Escritores(null, "JK Rowling");
		Escritores e2 = new Escritores(null, "R. J. Palacio");
		Escritores e3 = new Escritores(null, "Ruy Barbosa");
		escritoresRepository .saveAll(Arrays.asList(e1,e2,e3));
		
		Editora ed1 = new Editora(null, "Arqueiro");
		Editora ed2 = new Editora(null, "Rocco");
		Editora ed3 = new Editora(null, "Intrínseca");
		editoraRepository.saveAll(Arrays.asList(ed1,ed2,ed3));
		
		Categoria c1 = new Categoria(null, "Romance");
		Categoria c2 = new Categoria(null, "Ação");
		Categoria c3 = new Categoria(null, "Cientifico");
		Categoria c4 = new Categoria(null, "Drama");
		categoriaRepository.saveAll(Arrays.asList(c1,c2,c3,c4));
		
		Book b1 = new Book(null, "Wonder", "photo1", ed1);
		Book b2 = new Book(null, "Harry Potter 2", "photo1", ed3);
		Book b3 = new Book(null, "Bible", "photo1", ed1);
		Book b4 = new Book(null, "New Book", "photo3",ed2);
		bookRepository.saveAll(Arrays.asList(b1,b2,b3,b4));
		
		b1.getEscritores().add(e1);
		b1.getCategorias().add(c1);
		b1.getCategorias().add(c2);
		bookRepository.saveAll(Arrays.asList(b1,b1,b2));
		
		b2.getEscritores().add(e2);
		b2.getEscritores().add(e3);
		b2.getCategorias().add(c3);
		bookRepository.saveAll(Arrays.asList(b2,b2,b2));
		
		b3.getEscritores().add(e2);
		b3.getCategorias().add(c4);
		bookRepository.saveAll(Arrays.asList(b3,b3));
		
		b4.getEscritores().add(e3);
		b4.getCategorias().add(c1);
		bookRepository.saveAll(Arrays.asList(b4,b4));
	}	
}
