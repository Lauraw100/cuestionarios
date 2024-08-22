package com.cuestionarios.rolusuario.domain.entity;

public class UsuarioRol {

    private int id_rol;
    private int id_usuario;
    
    public UsuarioRol(int id_rol, int id_usuario) {
        this.id_rol = id_rol;
        this.id_usuario = id_usuario;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}
