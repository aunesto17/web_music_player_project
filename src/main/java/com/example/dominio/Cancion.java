package com.example.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Cancion {

  @Id
  @SequenceGenerator(name = "CANCION_ID_GENERATOR", sequenceName = "CANCION_ID_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CANCION_ID_GENERATOR")
  private Integer id;

  private String nombre;
  
//  @ManyToOne
//  @JoinColumn(name = "ARTISTA_ID")
//  private Artista artista;
  
  @ManyToOne
  @JoinColumn(name = "ALBUM_ID")
  private Album album;

  @ManyToMany (mappedBy = "canciones")
  private List<Playlist> playlistsTopTen;
}
