package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dominio.Alumno;
import com.example.repositorio.AlumnoRepositorio;

@EnableAutoConfiguration
@EntityScan(basePackageClasses = Alumno.class)
@Controller
public class DemoApplication {

	@Autowired
	AlumnoRepositorio repositorio;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/alumnos")
	@ResponseBody
	public List<Alumno> alumnos() {
		repositorio.save(new Alumno("Juan", "Perez", 10));
		return repositorio.findAll();
	}
}
