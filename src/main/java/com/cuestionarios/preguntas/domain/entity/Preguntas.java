package com.cuestionarios.preguntas.domain.entity;

import java.sql.Timestamp;

public class Preguntas {

    private int id;
    private int idCapitulo;
    private Timestamp creadoEn;
    private Timestamp actualizadoEn;
    private String numeroPregunta;
    private String tipoRespuesta;
    private String comentarioPregunta;
    private String textoPregunta;
    
    
    public Preguntas(int idCapitulo, String tipoRespuesta, String comentarioPregunta, String textoPregunta) {
        this.idCapitulo = idCapitulo;
        this.tipoRespuesta = tipoRespuesta;
        this.comentarioPregunta = comentarioPregunta;
        this.textoPregunta = textoPregunta;
    }

    public Preguntas(int idCapitulo, String numeroPregunta, String tipoRespuesta, String comentarioPregunta,String textoPregunta) {
        this.idCapitulo = idCapitulo;
        this.numeroPregunta = numeroPregunta;
        this.tipoRespuesta = tipoRespuesta;
        this.comentarioPregunta = comentarioPregunta;
        this.textoPregunta = textoPregunta;
    }

    public Preguntas(int id, int idCapitulo, Timestamp creadoEn, Timestamp actualizadoEn, String numeroPregunta,
            String tipoRespuesta, String comentarioPregunta, String textoPregunta) {
        this.id = id;
        this.idCapitulo = idCapitulo;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
        this.numeroPregunta = numeroPregunta;
        this.tipoRespuesta = tipoRespuesta;
        this.comentarioPregunta = comentarioPregunta;
        this.textoPregunta = textoPregunta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCapitulo() {
        return idCapitulo;
    }

    public void setIdCapitulo(int idCapitulo) {
        this.idCapitulo = idCapitulo;
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

    public String getNumeroPregunta() {
        return numeroPregunta;
    }

    public void setNumeroPregunta(String numeroPregunta) {
        this.numeroPregunta = numeroPregunta;
    }

    public String getTipoRespuesta() {
        return tipoRespuesta;
    }

    public void setTipoRespuesta(String tipoRespuesta) {
        this.tipoRespuesta = tipoRespuesta;
    }

    public String getComentarioPregunta() {
        return comentarioPregunta;
    }

    public void setComentarioPregunta(String comentarioPregunta) {
        this.comentarioPregunta = comentarioPregunta;
    }

    public String getTextoPregunta() {
        return textoPregunta;
    }

    public void setTextoPregunta(String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }
}
