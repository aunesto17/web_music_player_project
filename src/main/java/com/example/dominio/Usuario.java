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
public class Usuario {
	@Id
	@SequenceGenerator(name = "Persona_ID_GENERATOR", sequenceName = "Persona_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Persona_ID_GENERATOR")
	private Integer ID_usuario;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String correo;
	private String contrasena;
	private Boolean state; // Activo o Inactivo
	
	//Crear tabla seguidores_seguidos	
	@ManyToMany
	@JoinTable(name = "following_followers",
		joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "ID_usuario", nullable = false),
		inverseJoinColumns = @JoinColumn(name = "follower_id", referencedColumnName = "ID_usuario",nullable = false))
	private List<Usuario> seguidores;
	
	//relaciones para el timeline
	@OneToMany(mappedBy="usuario")
	private List<Timeline> canciones;
}
	