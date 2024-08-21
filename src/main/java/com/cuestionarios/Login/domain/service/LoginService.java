package com.cuestionarios.login.domain.service;

import java.util.Optional;

import com.cuestionarios.login.domain.entity.Login;

public interface LoginService {
    public Optional<Integer> validarusuario(String user, String contraseña);
    public void guardarusuario(Login usuario); 
    public Optional<Integer> roles(int id);

}
