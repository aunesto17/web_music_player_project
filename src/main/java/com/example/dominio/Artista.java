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
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "artista")
public class Artista implements Serializable, BaseEntity<Long>, Followable {

    @Id
    @SequenceGenerator(name = "ARTISTA_ID_GENERATOR", sequenceName = "ARTISTA_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARTISTA_ID_GENERATOR")
    private Integer id;

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

    public Author(String name, String genero) {
        this.nombre = nombre;
        this.genero = genero;
    }

    public Author(String nombre, String genero, Feed feed) {
        this.nombre = nombre;
        this.genero = genero;
        this.feed = feed;
    }

    public Integer getId() {
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
