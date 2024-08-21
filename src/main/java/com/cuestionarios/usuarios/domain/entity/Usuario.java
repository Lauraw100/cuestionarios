package com.cuestionarios.usuarios.domain.entity;

public class Usuario {

    private int id;
    private boolean habilitado;
    private String nombreUsuario;
    private String contrasena;

    public Usuario(boolean habilitado, String nombreUsuario, String contrasena) {
        this.habilitado = habilitado;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public Usuario(int id, boolean habilitado, String nombreUsuario, String contrasena) {
        this.id = id;
        this.habilitado = habilitado;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean isHabilitado() {
        return habilitado;
    }
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String toString() {
        return "ID: " + id + "\n" +
               "Nombre: " + nombreUsuario + "\n" +
               "Habilitado: " + (habilitado ? "Sí" : "No") + "\n" +
               "Contraseña: " + contrasena + "\n";
    }
}
