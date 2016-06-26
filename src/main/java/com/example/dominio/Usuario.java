package com.example.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Usuario extends Persona {
	@Id
	@SequenceGenerator(name = "Persona_ID_GENERATOR", sequenceName = "Persona_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Persona_ID_GENERATOR")
	public 	Integer ID_usuario;
	private String correo;
	private String contrasena;
	public 	Boolean state; // Activo o Inactivo
	//Viendo si conviene o no
	//public Integer followers;
	//public Integer following;
	
	//Crear tabla seguidores_seguidos	
	@ManyToMany
	@JoinTable(name = "following_followers",
		joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "ID_usuario", nullable = false),
		inverseJoinColumns = @JoinColumn(name = "follower_id", referencedColumnName = "ID_usuario",nullable = false))
	private List<Usuario> seguidores;
	
	//relaciones para el timeline
		@OneToMany(mappedBy="usuario")
		private List<Timeline> timeline;
	
	public Integer getID_usuario() {
		return ID_usuario;
	}

	public void setID_usuario(Integer iD_usuario) {
		ID_usuario = iD_usuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public List<Usuario> getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(List<Usuario> seguidores) {
		this.seguidores = seguidores;
	}

	public List<Timeline> getTimeline() {
		return timeline;
	}

	public void setTimeline(List<Timeline> timeline) {
		this.timeline = timeline;
	}
}
	