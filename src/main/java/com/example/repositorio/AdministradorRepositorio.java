package com.example.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.dominio.Administrador;

public interface AdministradorRepositorio extends CrudRepository<Administrador, Integer> {
	List<Administrador> findAll();
}
