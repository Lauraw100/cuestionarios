package com.cuestionarios.oprespuestas.application;

import java.util.List;

import com.cuestionarios.oprespuestas.domain.entity.OpRespuesta;
import com.cuestionarios.oprespuestas.domain.service.OpRespuestaService;
public class FindAllOpRespuestaUC {

    private OpRespuestaService opRespuestaService;

    public FindAllOpRespuestaUC(OpRespuestaService opRespuestaService) {
        this.opRespuestaService = opRespuestaService;
    }

    public List<OpRespuesta> execute(){
        return opRespuestaService.FindAllOpcionesRespuesta(); 
    }
}
