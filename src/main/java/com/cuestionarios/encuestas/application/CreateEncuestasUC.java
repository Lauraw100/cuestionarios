package com.cuestionarios.encuestas.application;

import com.cuestionarios.encuestas.domain.entity.Encuesta;
import com.cuestionarios.encuestas.domain.service.EncuestaService;

public class CreateEncuestasUC {

    private EncuestaService encuestaService;

    public CreateEncuestasUC(EncuestaService encuestaService) {
        this.encuestaService = encuestaService;
    }

    public void execute(Encuesta encuesta){
        encuestaService.CreateEncuesta(encuesta);
    }
}
