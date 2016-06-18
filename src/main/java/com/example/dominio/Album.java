
package com.example.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Album{
	@Id
	@SequenceGenerator(name = "Album_ID_GENERATOR", sequenceName = "Album_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Album_ID_GENERATOR")
	public Integer id_Album;
	public String nombre;	
	public Integer Artista;
	//lista
	public Integer id_cancion;
	public Date fechaCreacion;
}
//+ ID_album: SERIAL
//+ ID_artista : INT
//+ nombre : STRING
//+ fechaCreación : DATE
//+ listaCanciones : CANCION
