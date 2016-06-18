package com.example.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Playlist {
    @Id
    public Integer ID_playlist;
    public Cancion lista_cancion;
    public String nombre_playlist;
}
