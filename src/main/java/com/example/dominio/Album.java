package com.example.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;

import java.util.Date;
import java.util.List;

@Entity
public class Album{
	@Id
	@SequenceGenerator(name = "Album_ID_GENERATOR", sequenceName = "Album_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Album_ID_GENERATOR")
	private Integer ID_album;
	private String nombre;	
	private Date fechaCreacion;
	
	//@OneToMany(mappedBy = "album")
	//private List<Cancion> listaCanciones;
	
	
	@ManyToMany
	@JoinTable(name = "album_artista",
	      joinColumns = @JoinColumn(name = "ALBUM_ID", referencedColumnName = "ID_album"),
	      inverseJoinColumns = @JoinColumn(name = "ARTISTA_ID", referencedColumnName = "ID_artista"))
	private List<Artista> listaArtistas;
}
