package com.example.dominio;

import javax.persistence.*;

<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
=======
import org.codehaus.jackson.annotate.JsonIgnore;
import java.io.Serializable;
import java.util.List;
>>>>>>> master

@SuppressWarnings("serial")
@Entity
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master
public class Usuario {
	@Id
	@SequenceGenerator(name = "Persona_ID_GENERATOR", sequenceName = "Persona_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Persona_ID_GENERATOR")
	private Integer ID_usuario;
	private String  nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String email;
	private String password;
	private Boolean state; // Activo o Inactivo
<<<<<<< HEAD
	
	//Crear tabla seguidores_seguidos	
	@ManyToMany
	@JoinTable(name = "following_followers",
		joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "ID_usuario", nullable = false),
		inverseJoinColumns = @JoinColumn(name = "follower_id", referencedColumnName = "ID_usuario",nullable = false))
	private List<Usuario> seguidores;
	
	//relaciones para el timeline
	@OneToMany(mappedBy="usuario")
	private List<Timeline> canciones;
	
	//getters and setters
	public Usuario(String nombres, String apellidoPaterno, String apellidoMaterno, String email, String password) {
		this.nombres 			= nombres;
        this.apellidoPaterno 	= apellidoPaterno;
        this.apellidoMaterno    = apellidoMaterno;
        this.email				= email;
        this.password			= password;
        this.state				= true;
    }
	
	public Integer getId(){
		return ID_usuario;
	}
	
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getEmail() {
		return email;
=======
	
	//Crear tabla seguidores_seguidos	
	@ManyToMany
	@JoinTable(name = "following_followers",
		joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "ID_usuario", nullable = false),
		inverseJoinColumns = @JoinColumn(name = "follower_id", referencedColumnName = "ID_usuario",nullable = false))
	private List<Usuario> seguidores;
	
	//relaciones para el timeline
	@OneToMany(mappedBy="usuario")
	private List<Timeline> canciones;
	
	//getters and setters
	public Usuario(String nombres, String apellidoPaterno, String apellidoMaterno, String email, String password) {
		this.nombres 			= nombres;
        this.apellidoPaterno 	= apellidoPaterno;
        this.apellidoMaterno    = apellidoMaterno;
        this.email				= email;
        this.password			= password;
        this.state				= true;
    }
	
	public Integer getId(){
		return ID_usuario;
	}
	
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getEmail() {
		return email;
=======
@Table(name = "usuario")
@NamedQuery(name = Usuario.FIND_BY_USERNAME, query = "select a from Account a where a.username = :username")
public class Usuario implements Serializable, BaseEntity<Long>, Followable {

	public static final String FIND_BY_USERNAME = "Usuario.findByUsername";

	@Id
	@SequenceGenerator(name = "USUARIO_ID_GENERATOR", sequenceName = "USUARIO_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_ID_GENERATOR")
	private Long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_feed", joinColumns = {
            @JoinColumn(name = "usuario_id") },
            inverseJoinColumns = { @JoinColumn(name = "feed_id") })
    private List<Feed> following;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed;

    @Column(unique = true, length = 20)
    private String username;

	@Column(unique = true)
	private String email;

	private String password;

    @Column
    private String role = "ROLE_USER";

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    public List<PlayList> playlists;
	
	public 	Boolean state; // Activo o Inactivo

	protected Usuario() {

	}

    public Usuario(String username, String email, String password, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

	public Usuario(String username, String email, String password, String role, Feed feed) {
        this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
        this.feed = feed;
	}

	public Long getId() {
		return id;
	}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public Boolean getState() {
		return state;
>>>>>>> ad66c8d2ac626bcd8db209fe7dcb87506675ed25
>>>>>>> master
	}

	public void setEmail(String email) {
		this.email = email;
	}

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}
<<<<<<< HEAD
=======
=======

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public List<PlayList> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<PlayList> playlists) {
        this.playlists = playlists;
    }

    public List<Feed> getFollowing() {
        return following;
    }

    public void addFollowing(Feed follow) {
        following.add(follow);
    }

    public String getType() {
        return "User";
    }

    public String getName() {
        return username;
    }

    public String getLink() {
        return username;
    }
>>>>>>> ad66c8d2ac626bcd8db209fe7dcb87506675ed25
>>>>>>> master
}
