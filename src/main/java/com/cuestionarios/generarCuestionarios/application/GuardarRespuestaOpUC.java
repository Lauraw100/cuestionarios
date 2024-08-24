package com.cuestionarios.generarCuestionarios.application;

import com.cuestionarios.generarCuestionarios.domain.service.GenerarCuestionariosService;

public class GuardarRespuestaOpUC {
    private GenerarCuestionariosService generarCuestionariosService;

    public GuardarRespuestaOpUC(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }
    
    public void execute(int idOpcion){
        generarCuestionariosService.guardar_respuestaOpcion(idOpcion);
    }
}
