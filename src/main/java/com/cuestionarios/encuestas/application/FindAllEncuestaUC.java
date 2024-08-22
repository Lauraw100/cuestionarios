package com.cuestionarios.encuestas.application;

import java.util.List;

import com.cuestionarios.encuestas.domain.entity.Encuesta;
import com.cuestionarios.encuestas.domain.service.EncuestaService;

public class FindAllEncuestaUC {

    private EncuestaService encuestaService;

    public FindAllEncuestaUC(EncuestaService encuestaService) {
        this.encuestaService = encuestaService;
    }

    public List<Encuesta> execute(){
        return encuestaService.FindAllEncuesta();
    }
}
