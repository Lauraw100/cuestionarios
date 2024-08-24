package com.cuestionarios.generarCuestionarios.application;

import com.cuestionarios.generarCuestionarios.domain.service.GenerarCuestionariosService;

public class GuardarRespuestaOpAbiertaUC {
    private GenerarCuestionariosService generarCuestionariosService;

    public GuardarRespuestaOpAbiertaUC(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public void execute(int idopcionAbierta,String respuestaAbierta) {
        generarCuestionariosService.guardar_respuestaOpcionAbierta(idopcionAbierta,respuestaAbierta);
    }
}
