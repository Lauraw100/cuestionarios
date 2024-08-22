package com.cuestionarios.generarCuestionarios.domain.entity;

public class GenerarCuestionarios {

    private int indice;
    private String nombre;
    
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

}
