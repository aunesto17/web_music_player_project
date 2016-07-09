package com.example.servicio;

import com.example.dominio.Usuario;

public interface UsuarioService {
	
	public Usuario crearUsuario(String nombres, String apellidoPaterno, String apellidoMaterno, String email, String password); //throws Exception;
	public void updateUsuario(Usuario usuario);
	public Usuario getUsuario(Integer id);
}
