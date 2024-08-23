package com.cuestionarios.respuesta.application;

import com.cuestionarios.respuesta.domain.service.RespuestaService;

public class DeleteRespuestaUC {

    private RespuestaService respuestaService;

    public DeleteRespuestaUC(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    public void execute(int id) {
        respuestaService.deleteRespuesta(id);
    }
}
