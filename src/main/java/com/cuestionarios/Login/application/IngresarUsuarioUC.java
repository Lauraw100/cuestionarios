package com.cuestionarios.login.application;

import com.cuestionarios.login.domain.entity.Login;
import com.cuestionarios.login.domain.service.LoginService;

public class IngresarUsuarioUC {
    private LoginService loginService;

    public IngresarUsuarioUC(LoginService loginService) {
        this.loginService = loginService;
    }

    public void execute(Login usuario){
        loginService.guardarusuario(usuario);
    }
}
