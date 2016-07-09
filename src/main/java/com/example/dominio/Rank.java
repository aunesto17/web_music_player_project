package com.example.dominio;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@SuppressWarnings("serial")
@Entity
@Table(name = "rank")
public class Rank implements Serializable, BaseEntity<Long> {

    @Id
    @SequenceGenerator(name = "RANK_ID_GENERATOR", sequenceName = "RANK_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RANK_ID_GENERATOR")
    private Long id;

    private int value;

    public Rank() {

    }

    @Override
    public Long getId() {
        return id;
    }
}
