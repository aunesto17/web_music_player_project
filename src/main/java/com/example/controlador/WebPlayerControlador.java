package com.example.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.repositorio.UsuarioRepositorio;
import com.example.repositorio.AdministradorRepositorio;

@RestController
public class WebPlayerControlador {
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	@Autowired
	AdministradorRepositorio AdministradorRepositorio;
	
	
}
