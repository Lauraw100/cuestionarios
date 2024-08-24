package com.cuestionarios.login.domain.entity;

public class Login {
    private String password;
    private String user;
    private int idrol;
    private boolean idhabilitado;


    public Login(int idrol, boolean idhabilitado) {
        this.idrol = idrol;
        this.idhabilitado = idhabilitado;
    }

    public Login(String password, String user) {
        this.password = password;
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public boolean isIdhabilitado() {
        return idhabilitado;
    }

    public void setIdhabilitado(boolean idhabilitado) {
        this.idhabilitado = idhabilitado;
    }


}
