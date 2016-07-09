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
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@SuppressWarnings("serial")
@Entity
<<<<<<< HEAD
public class Album{
	@Id
	@SequenceGenerator(name = "Album_ID_GENERATOR", sequenceName = "Album_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Album_ID_GENERATOR")
	private Integer ID_album;
	private String nombre;	
	private Date fechaCreacion;

	
	@ManyToMany
	@JoinTable(name = "album_artista",
	      joinColumns = @JoinColumn(name = "ALBUM_ID", referencedColumnName = "ID_album"),
	      inverseJoinColumns = @JoinColumn(name = "ARTISTA_ID", referencedColumnName = "ID_artista"))
	private List<Artista> listaArtistas;
	
	public Album (String nombre, Date fechaCreacion){
		this.nombre 		= nombre;
		this.fechaCreacion 	= fechaCreacion;
	}
	
	public Integer getId(){
		return ID_album;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
=======
@Table(name = "album")
public class Album implements Serializable, PlayListable, BaseEntity<Long> {

    @Id
    @SequenceGenerator(name = "ALBUM_ID_GENERATOR", sequenceName = "ALBUM_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALBUM_ID_GENERATOR")
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
	public Date fechaCreacion;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "album_artista", joinColumns = {
            @JoinColumn(name = "album_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "artista_id",
                    nullable = false, updatable = false) })
    private List<Artista> artistas;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "album")
    public List<Cancion> canciones;

    protected Album() {

    }

    public Album(String nombre, Date fechaCreacion, List<Artista> artistas) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.artistas = artistas;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }

    public void addArtista(Artista artista){ this.artistas.add(artista); }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }
>>>>>>> ad66c8d2ac626bcd8db209fe7dcb87506675ed25
}
