package com.example.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Artista{
	
	@Id
	@SequenceGenerator(name = "Artista_ID_GENERATOR", sequenceName = "Artista_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Artista_ID_GENERATOR")
	private Integer ID_artista;
	private String nombre;
	private String bio;
	
	@OneToMany(mappedBy = "artista")
	private List<Cancion> listaCanciones;
	
	public Artista(String nombre,String bio){
		this.nombre = nombre;
		this.bio	= bio;
	}
	
	public Integer getId(){
		return ID_artista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
}