package com.example.LibraryProject.dto;

import java.io.Serializable;

import com.example.LibraryProject.entities.Editora;

public class EditorasDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	public EditorasDTO() {
		
	}
	public EditorasDTO(Editora obj) {
		id = obj.getId();
		name = obj.getName();
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
}
