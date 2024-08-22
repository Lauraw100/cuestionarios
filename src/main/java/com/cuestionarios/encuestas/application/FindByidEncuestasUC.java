package com.cuestionarios.encuestas.application;

import java.util.Optional;

import com.cuestionarios.encuestas.domain.entity.Encuesta;
import com.cuestionarios.encuestas.domain.service.EncuestaService;

public class FindByidEncuestasUC {

    private EncuestaService encuestaService;

    public FindByidEncuestasUC(EncuestaService encuestaService) {
        this.encuestaService = encuestaService;
    }

    public Optional<Encuesta> execute(int id){
        return encuestaService.FindByIdEncuesta(id);
    }
}

