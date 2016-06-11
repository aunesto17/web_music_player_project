package com.example.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.example.dominio.Alumno;
import com.example.dominio.Curso;
import com.example.dominio.Matricula;

public interface MatriculaRepositorio extends CrudRepository<Matricula, Long>{

	Matricula findByAlumnoAndCurso(Alumno alumno, Curso curso);
	boolean deleteByAlumnoAndCurso(Alumno alumno, Curso curso);

}
