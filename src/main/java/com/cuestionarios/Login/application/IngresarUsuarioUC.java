package com.cuestionarios.Login.application;

import com.cuestionarios.Login.domain.entity.Login;
import com.cuestionarios.Login.domain.service.LoginService;

public class IngresarUsuarioUC {
    private LoginService loginService;

    public IngresarUsuarioUC(LoginService loginService) {
        this.loginService = loginService;
    }

    public void execute(Login usuario){
        loginService.guardarusuario(usuario);
    }
}
