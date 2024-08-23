package com.cuestionarios.respuesta.application;

import com.cuestionarios.respuesta.domain.entity.Respuesta;
import com.cuestionarios.respuesta.domain.service.RespuestaService;

public class CreateRespuestaUC {

    private RespuestaService respuestaService;

    public CreateRespuestaUC(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    public void execute(Respuesta respuesta) {
        respuestaService.CreateRespuesta(respuesta);
    }
    
}
