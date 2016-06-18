package com.example.dominio;

//No es entity ya que nunca se instancia una clase abstracta.
//@Entity
public abstract class Persona {
	public String nombres;
	public String apellidoPaterno;
	public String apellidoMaterno;
	public String correo;
	public String contrasena;
	
	
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
		this.contrasena	    = contrasena;
	}
	
	
}
