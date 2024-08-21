package com.cuestionarios.usuarios.application;

import java.util.List;
import com.cuestionarios.usuarios.domain.entity.Usuario;
import com.cuestionarios.usuarios.domain.service.UsuarioService;

public class FindAllUsuarioUC {

    private UsuarioService usuarioService;

    public FindAllUsuarioUC(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    public List<Usuario> execute(){
        return usuarioService.FindAllUsuario();
    }
}
