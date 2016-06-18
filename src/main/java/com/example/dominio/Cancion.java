package com.example.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

@Entity
public class Cancion{
	
	@Id
	@SequenceGenerator(name = "Cancion_ID_GENERATOR", sequenceName = "Cancion_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Cancion_ID_GENERATOR")
	public Integer id;
	public FileInputStream archivo;
	public Integer id_album;
	public String autor;
	public String album;
	public String genero;
	public Double duracion;
	public Date fecha_pub;
	public String letra;
	public Integer tamano;
	public Double calificacion;
	
}