package com.example.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.dominio.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {
	List<Usuario> findAll();
}
