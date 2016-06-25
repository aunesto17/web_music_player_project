package com.example.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
//Relacion Uno a Muchos
import javax.persistence.OneToMany;

import java.util.Date;

@Entity
public class Album{
	@Id
	@SequenceGenerator(name = "Album_ID_GENERATOR", sequenceName = "Album_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Album_ID_GENERATOR")
	public Integer id_alb;
	public String nombre_alb;	
	public Integer Artista;
	/*
	//lista
	public Integer id_cancion;
	public Date fechaCreacion;
	*/
	@OneToMany(mappedBy = "album")
	private List<Cancion> canciones;
}
