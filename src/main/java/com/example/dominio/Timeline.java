package com.example.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Timeline {
    @Id
    public Integer ID_timeline;
    public Integer ID_cancion;
    public String date;
}
