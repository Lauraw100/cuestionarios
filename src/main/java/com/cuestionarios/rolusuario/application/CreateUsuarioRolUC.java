package com.cuestionarios.rolusuario.application;

import com.cuestionarios.rolusuario.domain.entity.UsuarioRol;
import com.cuestionarios.rolusuario.domain.service.UsuarioRolService;

public class CreateUsuarioRolUC {

    private UsuarioRolService usuarioRolService;

    public CreateUsuarioRolUC(UsuarioRolService usuarioRolService) {
        this.usuarioRolService = usuarioRolService;
    }

    public void execute(UsuarioRol usuarioRol){
        usuarioRolService.CreateUsuarioRol(usuarioRol);
    }
}
