package com.example.servicio;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dominio.Alumno;
import com.example.dominio.Curso;
import com.example.dominio.Matricula;
import com.example.repositorio.AlumnoRepositorio;
import com.example.repositorio.CursoRepositorio;
import com.example.repositorio.MatriculaRepositorio;

@Service
public class MatriculaServiceImpl implements MatriculaService {
	
	AlumnoRepositorio alumnoRepositorio;
	CursoRepositorio cursoRepositorio;
	MatriculaRepositorio matriculaRepositorio;

	@Autowired
	public MatriculaServiceImpl(AlumnoRepositorio ar, CursoRepositorio cr,
			MatriculaRepositorio mr) {
		this.alumnoRepositorio = ar;
		this.matriculaRepositorio = mr;
		this.cursoRepositorio = cr;
	}

	@Transactional
	@Override
	public void matricular(Integer alumnoId, String codigoCurso) throws Exception {
		Alumno alumno = alumnoRepositorio.findOne(alumnoId);
		Curso curso = cursoRepositorio.findOne(codigoCurso);
		Matricula matricula = matriculaRepositorio.findByAlumnoAndCurso(alumno, curso);
		if (matricula != null) {
			throw new Exception("MAtricula ya existente");
		}
		matricula = new Matricula();
		matricula.setAlumno(alumno);
		matricula.setCurso(curso);
		matricula.setFecha(new Date());
		matricula.setNota(null);
		
		matriculaRepositorio.save(matricula);
	}

	@Override
	public void retiroCurso(Integer alumnoId, String codigoCurso) {
		Alumno alumno = alumnoRepositorio.findOne(alumnoId);
		Curso curso = cursoRepositorio.findOne(codigoCurso);
		Matricula matricula = matriculaRepositorio.findByAlumnoAndCurso(alumno, curso);
		matriculaRepositorio.delete(matricula);
	}

}
