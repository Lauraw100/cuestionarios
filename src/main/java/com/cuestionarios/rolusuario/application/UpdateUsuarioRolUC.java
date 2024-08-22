package com.cuestionarios.rolusuario.application;

import com.cuestionarios.rolusuario.domain.entity.UsuarioRol;
import com.cuestionarios.rolusuario.domain.service.UsuarioRolService;

public class UpdateUsuarioRolUC {

    private UsuarioRolService usuarioRolService;

    public UpdateUsuarioRolUC(UsuarioRolService usuarioRolService) {
        this.usuarioRolService = usuarioRolService;
    }
    
    public void execute(UsuarioRol usuarioRol) {
        usuarioRolService.updateUsuarioRol(usuarioRol);
    }
}
