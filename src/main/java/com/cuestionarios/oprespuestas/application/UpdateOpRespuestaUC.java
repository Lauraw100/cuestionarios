package com.cuestionarios.oprespuestas.application;

import com.cuestionarios.oprespuestas.domain.entity.OpRespuesta;
import com.cuestionarios.oprespuestas.domain.service.OpRespuestaService;

public class UpdateOpRespuestaUC {

    private OpRespuestaService opcionesRespuestaService;

    public UpdateOpRespuestaUC(OpRespuestaService opcionesRespuestaService) {
        this.opcionesRespuestaService = opcionesRespuestaService;
    }

    public void execute(OpRespuesta opcionesRespuesta){
        opcionesRespuestaService.updateOpcionesRespuesta(opcionesRespuesta);
    }
}
