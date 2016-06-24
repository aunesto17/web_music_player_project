package com.example.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Playlist {
  @Id
  @SequenceGenerator(name = "PLAYLIST_ID_GENERATOR", sequenceName = "PLAYLIST_ID_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLAYLIST_ID_GENERATOR")
  private Integer id;

  @ManyToMany
  @JoinTable(name = "playlist_cancion",
      joinColumns = @JoinColumn(name = "PLAYLIST_ID", referencedColumnName = "ID"),
      inverseJoinColumns = @JoinColumn(name = "CANCION_ID", referencedColumnName = "ID"))
  private List<Cancion> canciones;
}

