package com.example.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
<<<<<<< HEAD
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

//import java.io.FileInputStream;
import java.util.Date;	
=======
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
>>>>>>> ad66c8d2ac626bcd8db209fe7dcb87506675ed25

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Entity
<<<<<<< HEAD
public class Cancion {

  @Id
  @SequenceGenerator(name = "CANCION_ID_GENERATOR", sequenceName = "CANCION_ID_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CANCION_ID_GENERATOR")
  private Integer 	ID_cancion;
  private String 	nombre;
  private String 	genero;
  private String 	letra;
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
  
  public Cancion(String nombre, String genero, String letra, Album album, Artista artista) {
      this.nombre 		= nombre;
      this.genero 		= genero;
      this.letra  		= letra;
      this.album		= album;
      this.artista		= artista;
      this.calificacion = 0.00;
  }
  
  public Integer getId(){
	  return ID_cancion;
  }

  public String getNombre() {
	  return nombre;
  }

  public void setNombre(String nombre) {
	  this.nombre = nombre;
  }

  public String getGenero() {
	  return genero;
  }

  public void setGenero(String genero) {
	  this.genero = genero;
  }

  public String getLetra() {
	  return letra;
  }

  public void setLetra(String letra) {
	  this.letra = letra;
  }

  public Double getCalificacion() {
	  return calificacion;
  }

  public void setCalificacion(Double calificacion) {
	  this.calificacion = calificacion;
  }

  public Artista getArtista() {
	  return artista;
  }

  public void setArtista(Artista artista) {
	  this.artista = artista;
  }

  public Album getAlbum() {
	  return album;
  }

  public void setAlbum(Album album) {
	  this.album = album;
  }  
=======
@Table(name = "cancion")
public class Cancion implements Serializable, BaseEntity<Long> {

    @Id
    @SequenceGenerator(name = "CANCION_ID_GENERATOR", sequenceName = "CANCION_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CANCION_ID_GENERATOR")
    private Long id;
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, length = 11)
    private String youtubeId;

    @Column(columnDefinition = "TEXT")
    private String letra;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "cancion_artista", joinColumns = {
            @JoinColumn(name = "cancion_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "artista_id",
                    nullable = false, updatable = false) })
    private List<Artista> artistas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;

    @Column
    private double rank = 0;

    protected Cancion() {

    }

    public Cancion(String nombre, String youtubeId, List<Artista> artistas, Album album) {
        this.nombre = nombre;
        this.youtubeId = youtubeId;
        this.artistas = artistas;
        this.album = album;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public String getLetra() {
        return letra;
    }

    public void setLyrics(String letra) {
        this.letra = letra;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }
>>>>>>> ad66c8d2ac626bcd8db209fe7dcb87506675ed25
}
