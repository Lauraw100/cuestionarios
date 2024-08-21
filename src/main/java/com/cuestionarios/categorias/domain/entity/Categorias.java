package com.cuestionarios.categorias.domain.entity;

import java.sql.Timestamp;

public class Categorias {

    private int id;
    private Timestamp creadoEn;
    private Timestamp actualizadoEn;
    private String nombre;

    public Categorias(String nombre) {
        this.nombre = nombre;
    }

    public Categorias(int id, Timestamp creadoEn, Timestamp actualizadoEn, String nombre) {
        this.id = id;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
