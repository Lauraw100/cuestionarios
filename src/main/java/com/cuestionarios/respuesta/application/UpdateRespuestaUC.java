package com.cuestionarios.respuesta.application;

import com.cuestionarios.respuesta.domain.entity.Respuesta;
import com.cuestionarios.respuesta.domain.service.RespuestaService;

public class UpdateRespuestaUC {

    private RespuestaService respuestaService;

    public UpdateRespuestaUC(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    public void execute(Respuesta respuesta){
        respuestaService.updateRespuesta(respuesta);
    }
}
