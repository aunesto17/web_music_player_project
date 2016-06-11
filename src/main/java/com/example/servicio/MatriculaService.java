package com.example.servicio;

public interface MatriculaService {

	void matricular(Integer alumnoId, String codigoCurso) throws Exception;

	void retiroCurso(Integer alumnoId, String codigoCurso);
}
