package com.example.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Artista{
	
	@Id
	@SequenceGenerator(name = "Artista_ID_GENERATOR", sequenceName = "Artista_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Artista_ID_GENERATOR")
	public Integer id;
	public String nombre;	
	public String genero;
	
	public Integer id_album;
	public Integer id_cancion;
}