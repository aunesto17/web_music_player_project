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
@Table(name = "log")
public class Log implements Serializable, BaseEntity<Long> {

    public enum LogLevel {INFO, WARNING, ERROR}

    @Id
    @SequenceGenerator(name = "LOG_ID_GENERATOR", sequenceName = "LOG_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOG_ID_GENERATOR")
    private Long id;

    @Column(nullable = false)
    private String msg;

    @Column(nullable = false)
    private LogLevel level;

    @Column(nullable = false)
    private Timestamp timestamp;

    protected Log() {
    }

    public Log(String msg, LogLevel level) {
        this.msg = msg;
        this.level = level;
        this.timestamp =new Timestamp((new java.util.Date()).getTime());
    }

    public Long getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
