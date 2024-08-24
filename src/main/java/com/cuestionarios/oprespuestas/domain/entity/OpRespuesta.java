package com.cuestionarios.oprespuestas.domain.entity;

import java.sql.Timestamp;

public class OpRespuesta {

    private int id;
    private int valorOpcion;
    private int idCategoriaCatalogo;
    private int idPregunta;
    private Timestamp creadoEn;
    private Timestamp actualizadoEn;
    private int idOpcionPadre; 
    private String tipoComponenteHtml;
    private String comentarioRespuesta;
    private String textoOpcion;

    public OpRespuesta(int valorOpcion, int idCategoriaCatalogo, int idPregunta, int idOpcionPadre, String tipoComponenteHtml, String comentarioRespuesta, String textoOpcion) {
        this.valorOpcion = valorOpcion;
        this.idCategoriaCatalogo = idCategoriaCatalogo;
        this.idPregunta = idPregunta;
        this.idOpcionPadre = idOpcionPadre;
        this.tipoComponenteHtml = tipoComponenteHtml;
        this.comentarioRespuesta = comentarioRespuesta;
        this.textoOpcion = textoOpcion;
    }



    public OpRespuesta(int valorOpcion, int idCategoriaCatalogo, int idPregunta, Timestamp creadoEn,
        Timestamp actualizadoEn, String tipoComponenteHtml, String comentarioRespuesta, String textoOpcion) {
        this.valorOpcion = valorOpcion;
        this.idCategoriaCatalogo = idCategoriaCatalogo;
        this.idPregunta = idPregunta;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
        this.tipoComponenteHtml = tipoComponenteHtml;
        this.comentarioRespuesta = comentarioRespuesta;
        this.textoOpcion = textoOpcion;
    }



    public OpRespuesta(int id, int valorOpcion, int idCategoriaCatalogo, int idPregunta, Timestamp creadoEn,
        Timestamp actualizadoEn, int idOpcionPadre, String tipoComponenteHtml, String comentarioRespuesta,
        String textoOpcion) {
        this.id = id;
        this.valorOpcion = valorOpcion;
        this.idCategoriaCatalogo = idCategoriaCatalogo;
        this.idPregunta = idPregunta;
        this.creadoEn = creadoEn;
        this.actualizadoEn = actualizadoEn;
        this.idOpcionPadre = idOpcionPadre;
        this.tipoComponenteHtml = tipoComponenteHtml;
        this.comentarioRespuesta = comentarioRespuesta;
        this.textoOpcion = textoOpcion;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public int getValorOpcion() {
        return valorOpcion;
    }



    public void setValorOpcion(int valorOpcion) {
        this.valorOpcion = valorOpcion;
    }



    public int getIdCategoriaCatalogo() {
        return idCategoriaCatalogo;
    }



    public void setIdCategoriaCatalogo(int idCategoriaCatalogo) {
        this.idCategoriaCatalogo = idCategoriaCatalogo;
    }



    public int getIdPregunta() {
        return idPregunta;
    }



    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
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

    public String getTipoComponenteHtml() {
        return tipoComponenteHtml;
    }



    public void setTipoComponenteHtml(String tipoComponenteHtml) {
        this.tipoComponenteHtml = tipoComponenteHtml;
    }



    public String getComentarioRespuesta() {
        return comentarioRespuesta;
    }



    public void setComentarioRespuesta(String comentarioRespuesta) {
        this.comentarioRespuesta = comentarioRespuesta;
    }



    public String getTextoOpcion() {
        return textoOpcion;
    }



    public void setTextoOpcion(String textoOpcion) {
        this.textoOpcion = textoOpcion;
    }



    public int getIdOpcionPadre() {
        return idOpcionPadre;
    }



    public void setIdOpcionPadre(int idOpcionPadre) {
        this.idOpcionPadre = idOpcionPadre;
    }

}
