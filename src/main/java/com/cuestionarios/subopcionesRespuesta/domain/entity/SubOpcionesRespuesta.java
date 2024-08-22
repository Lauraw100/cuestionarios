package com.cuestionarios.subopcionesRespuesta.domain.entity;

import java.sql.Timestamp;

public class SubOpcionesRespuesta {


    private int id;
    private int numeroSubopcion;
    private Timestamp creadoEn;
    private Timestamp actualizadoEn;
    private int idOpcionRespuesta;
    private String componenteHtml;
    private String textoSubopcion;


    public SubOpcionesRespuesta() {
    }



    public SubOpcionesRespuesta(int numeroSubopcion, int idOpcionRespuesta, String componenteHtml,
            String textoSubopcion) {
        this.numeroSubopcion = numeroSubopcion;
        this.idOpcionRespuesta = idOpcionRespuesta;
        this.componenteHtml = componenteHtml;
        this.textoSubopcion = textoSubopcion;
    }



    public SubOpcionesRespuesta(int id, int numeroSubopcion, Timestamp creadoEn, Timestamp actualizadoEn, int idOpcionRespuesta,
            String componenteHtml, String textoSubopcion) {
        this.id = id;
        this.numeroSubopcion = numeroSubopcion;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
        this.idOpcionRespuesta = idOpcionRespuesta;
        this.componenteHtml = componenteHtml;
        this.textoSubopcion = textoSubopcion;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getNumeroSubopcion() {
        return numeroSubopcion;
    }


    public void setNumeroSubopcion(int numeroSubopcion) {
        this.numeroSubopcion = numeroSubopcion;
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


    public int getIdOpcionRespuesta() {
        return idOpcionRespuesta;
    }


    public void setIdOpcionRespuesta(int idOpcionRespuesta) {
        this.idOpcionRespuesta = idOpcionRespuesta;
    }


    public String getComponenteHtml() {
        return componenteHtml;
    }


    public void setComponenteHtml(String componenteHtml) {
        this.componenteHtml = componenteHtml;
    }


    public String getTextoSubopcion() {
        return textoSubopcion;
    }


    public void setTextoSubopcion(String textoSubopcion) {
        this.textoSubopcion = textoSubopcion;
    }

}
