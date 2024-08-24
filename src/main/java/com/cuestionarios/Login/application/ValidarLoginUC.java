package com.cuestionarios.login.application;

import java.util.Optional;

import com.cuestionarios.login.domain.entity.Login;
import com.cuestionarios.login.domain.service.LoginService;

public class ValidarLoginUC {

    private LoginService loginService;

    public ValidarLoginUC(LoginService loginService) {
        this.loginService = loginService;
    }

    public Optional<Login> execute(String user, String contraseña){
        return loginService.validarusuario(user, contraseña);
    }
}
