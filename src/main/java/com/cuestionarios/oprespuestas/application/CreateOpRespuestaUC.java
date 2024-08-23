package com.cuestionarios.oprespuestas.application;

import com.cuestionarios.oprespuestas.domain.entity.OpRespuesta;
import com.cuestionarios.oprespuestas.domain.service.OpRespuestaService;

public class CreateOpRespuestaUC {

    private OpRespuestaService opRespuestaService;

    public CreateOpRespuestaUC(OpRespuestaService opcionesRespuestaService) {
        this.opRespuestaService = opcionesRespuestaService;
    }

    public void execute(OpRespuesta opcionesRespuesta){
        opRespuestaService.CreateOpcionesRespuesta(opcionesRespuesta);
    }
}
