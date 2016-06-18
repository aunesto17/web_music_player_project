package com.example.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
<<<<<<< HEAD
// Prueba con Branch alex_baylon
=======

>>>>>>> master
@Entity
public class Persona {
	@Id
	@SequenceGenerator(name = "Persona_ID_GENERATOR", sequenceName = "Persona_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Persona_ID_GENERATOR")
	public Integer id;
	public String nombres;
	public String apellidoPaterno;
	public String apellidoMaterno;
	public String correo;
	private String contrasena;
	
	
	public Persona() {
	}

	public Persona(	String nombres, 
					String apellidoPaterno,
					String apellidoMaterno,
					String correo,
					String contrasena) {
		this.nombres 		= nombres;
		this.apellidoPaterno= apellidoPaterno;
		this.apellidoMaterno= apellidoMaterno;
		this.correo 		= correo;
		this.contrasena = contrasena;
	}
}
