package com.cuestionarios.generarCuestionarios.domain.entity;

public class GenerarCuestionarios {
    private int indice;
    private int id;
    private String nombre;
    
    public GenerarCuestionarios(int id) {
        this.id = id;
    }

    public GenerarCuestionarios(int id, int indice, String nombre) {
        this.id = id;
        this.indice = indice;
        this.nombre = nombre;
    }

    public GenerarCuestionarios(int indice, String nombre) {
        this.indice = indice;
        this.nombre = nombre;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
