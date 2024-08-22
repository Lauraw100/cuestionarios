package com.cuestionarios.encuestas.application;

import com.cuestionarios.encuestas.domain.entity.Encuesta;
import com.cuestionarios.encuestas.domain.service.EncuestaService;

public class UpdateEncuestasUC {

    private EncuestaService encuestaService;

    public UpdateEncuestasUC(EncuestaService encuestaService) {
        this.encuestaService = encuestaService;
    }

    public void execute(Encuesta encuesta){
        encuestaService.updateEncuesta(encuesta);
    }
}
