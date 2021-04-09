package com.example.LibraryProject.dto;

import java.io.Serializable;

import com.example.LibraryProject.entities.Book;

public class BooksDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String photo;
	
	public BooksDTO() {
		
	}

	public BooksDTO(Book obj) {
		id = obj.getId();
		name = obj.getName();
		photo = obj.getPhoto();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}	
}
