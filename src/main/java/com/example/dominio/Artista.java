package com.example.dominio;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import java.util.List;

@Entity
<<<<<<< HEAD
public class Artista{
	
	@Id
	@SequenceGenerator(name = "Artista_ID_GENERATOR", sequenceName = "Artista_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Artista_ID_GENERATOR")
	private Integer ID_artista;
	private String nombre;
	private String bio;
	
	@OneToMany(mappedBy = "artista")
	private List<Cancion> listaCanciones;
	
	public Artista(String nombre,String bio){
		this.nombre = nombre;
		this.bio	= bio;
	}
	
	public Integer getId(){
		return ID_artista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
<<<<<<< HEAD
}
=======
}
=======
@Table(name = "artista")
public class Artista {

    @Id
    @SequenceGenerator(name = "ARTISTA_ID_GENERATOR", sequenceName = "ARTISTA_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARTISTA_ID_GENERATOR")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed;

    @Column(nullable = false)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String genero;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "artistas")
    private List<Album> albums;

    protected Artista() {

    }

    public Artista(String nombre, String genero) {
        this.nombre = nombre;
        this.genero = genero;
    }

    public Artista(String nombre, String genero, Feed feed) {
        this.nombre = nombre;
        this.genero = genero;
        this.feed = feed;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public String getType() {
        return "Artista";
    }

    public String getLink() {
        return "artista/" + Long.toString(id);
    }


}
>>>>>>> ad66c8d2ac626bcd8db209fe7dcb87506675ed25
>>>>>>> master
