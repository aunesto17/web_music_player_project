package com.example.dominio;

import javax.persistence.*;

@Entity
public class Playlist {
    @Id
    @SequenceGenerator(name = "Playlist_ID_GENERATOR", sequenceName = "Playlist_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Playlist_ID_GENERATOR")
    public Integer ID_playlist;
    public Cancion lista_cancion;
    public String nombre_playlist;
    public Playlist() {
    }

    public Playlist(Cancion lista_cancion, String nombre_playlist) {
        this.lista_cancion = lista_cancion;
        this.nombre_playlist = nombre_playlist;
    }
}
