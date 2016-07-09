package com.example.dominio;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.sql.Timestamp;

@SuppressWarnings("serial")
@Entity
@Table(name = "liket")
public class Like implements Serializable, BaseEntity<Long> {

    @Id
    @SequenceGenerator(name = "LINK_ID_GENERATOR", sequenceName = "LINK_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LINK_ID_GENERATOR")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Usuario usuario;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "song_id", nullable = false)
    private Cancion cancion;

    @Override
    public Long getId() {
        return id;
    }

    protected Like() {
        
    }

    public Like(Usuario usuario, Cancion cancion) {
        this.usuario = usuario;
        this.cancion = cancion;
    }

    public void setSong(Cancion cancion) {
        this.cancion = cancion;
    }

    public Cancion getCancion() {
        return this.cancion;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario(){
        return this.usuario;
    }

}
