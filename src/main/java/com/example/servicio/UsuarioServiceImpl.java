package com.example.servicio;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dominio.Usuario;
import com.example.repositorio.UsuarioRepositorio;

public class UsuarioServiceImpl {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	public Usuario crearUsuario(String nombres, String apellidoPaterno, String apellidoMaterno, String email, String password){
		Usuario usuario = new Usuario(nombres,apellidoPaterno,apellidoMaterno,email,password);
		usuarioRepositorio.save(usuario);
		return usuario;
	}
	
	public void updateUsuario(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }
	
	public Usuario getUsuario(Integer ID_usuario) {
        return usuarioRepositorio.findOne(ID_usuario);
    }
}
