package com.cuestionarios.usuarios.application;

import com.cuestionarios.usuarios.domain.service.UsuarioService;

public class DeleteUsuarioUC {

    private UsuarioService usuarioService;

    public DeleteUsuarioUC(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void execute(int id){
        usuarioService.deleteUsuario(id);
    }
}
