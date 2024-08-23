package com.cuestionarios.oprespuestas.application;

import java.util.Optional;

import com.cuestionarios.oprespuestas.domain.entity.OpRespuesta;
import com.cuestionarios.oprespuestas.domain.service.OpRespuestaService;

public class FindByidOpRespuestaUC {

    private OpRespuestaService opRespuestaService;

    public FindByidOpRespuestaUC(OpRespuestaService opRespuestaService) {
        this.opRespuestaService = opRespuestaService;
    }

    public Optional<OpRespuesta> execute(int id){
        return opRespuestaService.FindByIdOpcionesRespuesta(id);
    }
}        