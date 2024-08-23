package com.cuestionarios.oprespuestas.application;

import com.cuestionarios.oprespuestas.domain.service.OpRespuestaService;

public class DeleteOpRespuestaUC {

    private OpRespuestaService opRespuestaService;

    public DeleteOpRespuestaUC(OpRespuestaService opRespuestaService) {
        this.opRespuestaService = opRespuestaService;
    }

    public void execute(int id){
        opRespuestaService.deleteOpcionesRespuesta(id);
    }
}
