package com.cuestionarios.encuestas.domain.entity;

import java.sql.Timestamp;

public class Encuesta {

    private int id;
    private Timestamp creadoEn;
    private Timestamp actualizadoEn;
    private String descripcion;
    private String nombre;


    public Encuesta(String descripcion, String nombre) {
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public Encuesta(int id, Timestamp creadoEn, Timestamp actualizadoEn, String descripcion, String nombre) {
        this.id = id;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
        this.descripcion = descripcion;
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
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
