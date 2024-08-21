package com.cuestionarios.capitulos.domain.entity;

import java.sql.Timestamp;

public class Capitulo {

    private int id;
    private int idEncuesta;
    private Timestamp creadoEn;
    private Timestamp actualizadoEn;
    private String numeroCapitulo;
    private String tituloCapitulo;

    
    public Capitulo(int idEncuesta,  String tituloCapitulo) {
        this.idEncuesta = idEncuesta;
        this.tituloCapitulo = tituloCapitulo;
    }


    public Capitulo(int id, int idEncuesta, Timestamp creadoEn, Timestamp actualizadoEn, String numeroCapitulo,
            String tituloCapitulo) {
        this.id = id;
        this.idEncuesta = idEncuesta;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
        this.numeroCapitulo = numeroCapitulo;
        this.tituloCapitulo = tituloCapitulo;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getIdEncuesta() {
        return idEncuesta;
    }


    public void setIdEncuesta(int idEncuesta) {
        this.idEncuesta = idEncuesta;
    }


    public Timestamp getCreadoEn() {
        return creadoEn;
    }


    public void setCreadoEn(Timestamp creadoEn) {
        this.creadoEn = creadoEn;
    }


    public Timestamp getActualizadoEn() {
        return actualizadoEn;
    }


    public void setActualizadoEn(Timestamp actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }


    public String getNumeroCapitulo() {
        return numeroCapitulo;
    }


    public void setNumeroCapitulo(String numeroCapitulo) {
        this.numeroCapitulo = numeroCapitulo;
    }


    public String getTituloCapitulo() {
        return tituloCapitulo;
    }


    public void setTituloCapitulo(String tituloCapitulo) {
        this.tituloCapitulo = tituloCapitulo;
    }
}
