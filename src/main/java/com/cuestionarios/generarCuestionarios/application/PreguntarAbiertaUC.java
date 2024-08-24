package com.cuestionarios.generarCuestionarios.application;

import java.util.Optional;

import com.cuestionarios.generarCuestionarios.domain.service.GenerarCuestionariosService;

public class PreguntarAbiertaUC {
    private GenerarCuestionariosService generarCuestionariosService;

    public PreguntarAbiertaUC(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public Optional<String> execute(int id){
        return generarCuestionariosService.preguntaabierta(id);
    }
}
