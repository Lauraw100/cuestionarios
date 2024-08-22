package com.cuestionarios.rolusuario.application;

import java.util.List;
import com.cuestionarios.rolusuario.domain.entity.UsuarioRol;
import com.cuestionarios.rolusuario.domain.service.UsuarioRolService;

public class FindAllUsuarioRolUC {

    private UsuarioRolService usuarioRolService;

    public FindAllUsuarioRolUC(UsuarioRolService usuarioRolService) {
        this.usuarioRolService = usuarioRolService;
    }

    public List<UsuarioRol> execute(){
        return usuarioRolService.FindAllUsuarioRol();
    }
}
