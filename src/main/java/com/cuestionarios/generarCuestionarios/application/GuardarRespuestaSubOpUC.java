package com.cuestionarios.generarCuestionarios.application;

import com.cuestionarios.generarCuestionarios.domain.service.GenerarCuestionariosService;

public class GuardarRespuestaSubOpUC {
    private GenerarCuestionariosService generarCuestionariosService;

    public GuardarRespuestaSubOpUC(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public void execute(int idSubopcion){
        generarCuestionariosService.guardar_respuestaSubOpcion(idSubopcion);
    }
}
