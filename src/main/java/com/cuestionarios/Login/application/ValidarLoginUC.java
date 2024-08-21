package com.cuestionarios.Login.application;

import java.util.Optional;
import com.cuestionarios.Login.domain.service.LoginService;

public class ValidarLoginUC {

    private LoginService loginService;

    public ValidarLoginUC(LoginService loginService) {
        this.loginService = loginService;
    }

    public Optional<Integer> execute(String user, String contraseña){
        return loginService.validarusuario(user, contraseña);
    }
}
