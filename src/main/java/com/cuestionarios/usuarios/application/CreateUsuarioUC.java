package com.cuestionarios.usuarios.application;

import com.cuestionarios.usuarios.domain.entity.Usuario;
import com.cuestionarios.usuarios.domain.service.UsuarioService;

public class CreateUsuarioUC {

    private UsuarioService usuarioService;

    public CreateUsuarioUC(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void execute(Usuario usuario){
        usuarioService.CreateUsuario(usuario);
    }
}
