package com.example.dominio;

<<<<<<< HEAD
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
=======
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "playlist")
public class PlayList implements PlayListable, BaseEntity<Long>, Followable {

    @Id
    @SequenceGenerator(name = "ALBUM_ID_GENERATOR", sequenceName = "ALBUM_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALBUM_ID_GENERATOR")
    private Long id;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed;

    @Column(nullable = false)
    private String nombre;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "playlist_cancion", joinColumns = {
            @JoinColumn(name = "playlist_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "cancion_id",
                    nullable = false, updatable = false) })
    private List<Cancion> canciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private Usuario owner;

    @Column(nullable = false)
    private Timestamp createdOn;

    protected PlayList() {
    }

    public PlayList(String nombre, List<Cancion> canciones, Usuario owner) {
        this.nombre = nombre;
        this.canciones = canciones;
        this.owner = owner;
    }

    public PlayList(String nombre, List<Cancion> canciones, Usuario owner, Timestamp createdOn, Feed feed) {
		this.nombre = nombre;
        this.canciones = canciones;
        this.owner = owner;
        this.feed = feed;
        this.createdOn = createdOn;
    }
>>>>>>> master

    public String getNombre() {
        return nombre;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void addCancion(Cancion cancion) {
        canciones.add( cancion );
    }

    public Usuario getOwner() {
        return owner;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return "Playlist";
    }

    public String getName() {
        return nombre;
    }

    public String getLink() {
        return owner.getUsername() + "/playlists/" + Long.toString(getId());
    }
}
