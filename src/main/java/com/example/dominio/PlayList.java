package com.example.dominio;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@SuppressWarnings("serial")
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
