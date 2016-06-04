package com.example.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dominio.Alumno;
import com.example.dominio.Curso;
import com.example.repositorio.AlumnoRepositorio;
import com.example.repositorio.CursoRepositorio;

@RestController
public class AcademicoControlador {
	@Autowired
	AlumnoRepositorio alumnoRepositorio;

	@Autowired
	CursoRepositorio cursoRepositorio;

	@RequestMapping("/alumnos")
	@ResponseBody
	public List<Alumno> alumnos() {
		return alumnoRepositorio.findAll();
	}

	@RequestMapping(value = "/cursos", method = RequestMethod.POST)
	@ResponseBody
	public Curso guardarCurso(@RequestBody Curso curso) {
		return cursoRepositorio.save(curso);
	}

	//@RequestMapping("/cursos")
	@RequestMapping(value = "/cursos", method = RequestMethod.GET)
	@ResponseBody
	public List<Curso> cursos() {
		return cursoRepositorio.findAll();
	}

}
