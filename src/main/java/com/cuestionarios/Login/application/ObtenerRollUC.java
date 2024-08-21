package com.cuestionarios.login.application;

import java.util.Optional;

import com.cuestionarios.login.domain.service.LoginService;

public class ObtenerRollUC {

    private LoginService loginService;

    public ObtenerRollUC(LoginService loginService) {
        this.loginService = loginService;
    }

    public Optional<Integer> execute(int id){
        return loginService.roles(id);
    }

}
