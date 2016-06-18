package com.example.dominio;

import javax.persistence.*;

@Entity

public class Timeline {
    @Id
    @SequenceGenerator(name = "Timeline_ID_GENERATOR", sequenceName = "Timeline_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Timeline_ID_GENERATOR")
    public Integer ID_timeline;
    public Integer ID_cancion;
    public String date;
    public Timeline(Integer ID_cancion,String date){
        this.ID_cancion=ID_cancion;
        this.date=date;
    }
}
