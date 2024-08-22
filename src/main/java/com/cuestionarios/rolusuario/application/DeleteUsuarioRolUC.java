package com.cuestionarios.rolusuario.application;

import com.cuestionarios.rolusuario.domain.service.UsuarioRolService;

public class DeleteUsuarioRolUC {

    private UsuarioRolService usuarioRolService;

    public DeleteUsuarioRolUC(UsuarioRolService usuarioRolService) {
        this.usuarioRolService = usuarioRolService;
    }

    public void execute(int id_rol, int id_usuario){
        usuarioRolService.deleteUsuarioRol(id_rol, id_usuario);
    }
}
