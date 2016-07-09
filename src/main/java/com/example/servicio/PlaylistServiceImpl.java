package com.example.servicio;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dominio.Playlist;
import com.example.dominio.Usuario;
import com.example.repositorio.PlaylistRepositorio;

public class PlaylistServiceImpl {
	
	@Autowired
	private PlaylistRepositorio playlistRepositorio;
	
	public Playlist crearPlaylist(String nombre, Timestamp fecha_c,Usuario usr) {
        Playlist playlist = new Playlist(nombre,fecha_c,usr);
	       playlistRepositorio.save(playlist);
	       return playlist;
	}
	 
	public Playlist getPlaylist(Integer id){
		return playlistRepositorio.findOne(id);
	} 
}
