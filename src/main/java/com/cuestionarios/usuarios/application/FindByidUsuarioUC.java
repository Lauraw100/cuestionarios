package com.cuestionarios.usuarios.application;

import java.util.Optional;
import com.cuestionarios.usuarios.domain.entity.Usuario;
import com.cuestionarios.usuarios.domain.service.UsuarioService;

public class FindByidUsuarioUC {

    private UsuarioService usuarioService;

    public FindByidUsuarioUC(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    public Optional<Usuario> execute(int id){
        return usuarioService.FindByIdUsuario(id);
    }
}
