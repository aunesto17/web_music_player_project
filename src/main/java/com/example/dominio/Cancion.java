package com.example.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Cancion{
	
	@Id
	@SequenceGenerator(name = "Cancion_ID_GENERATOR", sequenceName = "Cancion_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Cancion_ID_GENERATOR")
	public Integer id;
	public FileInputStream archivo;
	public integer id_album;
	public string autor;
	public string album;
	public string genero;
	public double duracion;
	public Date fecha_pub;
	public string letra;
	public integer tamano;
	public Double calificacion;
	
}