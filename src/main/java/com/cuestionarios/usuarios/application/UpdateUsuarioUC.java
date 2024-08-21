package com.cuestionarios.usuarios.application;

import com.cuestionarios.usuarios.domain.entity.Usuario;
import com.cuestionarios.usuarios.domain.service.UsuarioService;

public class UpdateUsuarioUC {

    private UsuarioService usuarioService;

    public UpdateUsuarioUC(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void execute(Usuario usuario){
        usuarioService.updateUsuario(usuario);
    }
}
