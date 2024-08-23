package com.cuestionarios.respuesta.domain.entity;

public class Respuesta {

    private int id;
    private int idRespuesta;
    private int idSubrespuesta;
    private String textoRespuesta;
    
    public Respuesta(int id, int idRespuesta, int idSubrespuesta, String textoRespuesta) {
        this.id = id;
        this.idRespuesta = idRespuesta;
        this.idSubrespuesta = idSubrespuesta;
        this.textoRespuesta = textoRespuesta;
    }

    public Respuesta(int idRespuesta, int idSubrespuesta, String textoRespuesta) {
        this.idRespuesta = idRespuesta;
        this.idSubrespuesta = idSubrespuesta;
        this.textoRespuesta = textoRespuesta;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdRespuesta() {
        return idRespuesta;
    }
    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }
    public int getIdSubrespuesta() {
        return idSubrespuesta;
    }
    public void setIdSubrespuesta(int idSubrespuesta) {
        this.idSubrespuesta = idSubrespuesta;
    }
    public String getTextoRespuesta() {
        return textoRespuesta;
    }
    public void setTextoRespuesta(String textoRespuesta) {
        this.textoRespuesta = textoRespuesta;
    }
}
