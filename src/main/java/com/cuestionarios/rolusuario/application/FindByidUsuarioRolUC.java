package com.cuestionarios.rolusuario.application;

import java.util.Optional;
import com.cuestionarios.rolusuario.domain.entity.UsuarioRol;
import com.cuestionarios.rolusuario.domain.service.UsuarioRolService;

public class FindByidUsuarioRolUC {

    private UsuarioRolService usuarioRolService;

    public FindByidUsuarioRolUC(UsuarioRolService usuarioRolService) {
        this.usuarioRolService = usuarioRolService;
    }

    public Optional<UsuarioRol> execute(int id2){
        return usuarioRolService.FindByIdUsuarioRol(id2);
    }
}
