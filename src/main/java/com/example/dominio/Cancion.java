package com.example.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
//import java.io.FileInputStream;
import java.util.Date;	

@Entity
public class Cancion {

  @Id
  @SequenceGenerator(name = "CANCION_ID_GENERATOR", sequenceName = "CANCION_ID_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CANCION_ID_GENERATOR")
  private Integer 	ID_cancion;
  private String 	nombre;
  private String 	archivo;
  private String 	autor;
  private String 	genero;
  private Double 	duracion;
  private Date 		fecha_pub;
  private String 	letra;
  private Integer 	tamano;
  private Double 	calificacion;
  
  @ManyToOne
  @JoinColumn(name = "ARTISTA_ID")
  private Artista artista;  
  
  @ManyToOne
  @JoinColumn(name = "ALBUM_ID")
  private Album album;

  @ManyToMany (mappedBy = "canciones")
  private List<Playlist> playlistsTopTen;
  
  @OneToMany(mappedBy = "cancion")
  private List<Timeline> usuarios;
}
