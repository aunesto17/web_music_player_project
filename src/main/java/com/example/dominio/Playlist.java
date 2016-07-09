package com.example.dominio;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class Playlist {
  @Id
  @SequenceGenerator(name = "PLAYLIST_ID_GENERATOR", sequenceName = "PLAYLIST_ID_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLAYLIST_ID_GENERATOR")
  private Integer	ID_playlist;
  private String 	nombre;
  private Timestamp fecha_creacion;

  @ManyToMany
  @JoinTable(name = "playlist_cancion",
      joinColumns = @JoinColumn(name = "PLAYLIST_ID", referencedColumnName = "ID_playlist"),
      inverseJoinColumns = @JoinColumn(name = "CANCION_ID", referencedColumnName = "ID_cancion"))
  private List<Cancion> canciones;
  
  @ManyToOne
  @JoinColumn(name = "usuario_id")
  private Usuario usuario;
  
  public Playlist(String nombre,Timestamp fecha_creacion,Usuario usuario){
	  this.nombre = nombre;
	  this.fecha_creacion = fecha_creacion;
	  this.usuario = usuario;
  }

  public Integer getID_playlist() {
	  return ID_playlist;
  }

  public String getNombre() {
	  return nombre;
  }

  public void setNombre(String nombre) {
	  this.nombre = nombre;
  }

  public Timestamp getFecha_creacion() {
	  return fecha_creacion;
  }

  public void setFecha_creacion(Timestamp fecha_creacion) {
	  this.fecha_creacion = fecha_creacion;
  }

  public Usuario getUsuario() {
	  return usuario;
  }

  public void setUsuario(Usuario usuario) {
	  this.usuario = usuario;
  }
   
}

