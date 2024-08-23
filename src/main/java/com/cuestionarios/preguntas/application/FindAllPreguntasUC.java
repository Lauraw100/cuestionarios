package com.cuestionarios.preguntas.application;

import java.util.List;

import com.cuestionarios.preguntas.domain.entity.Preguntas;
import com.cuestionarios.preguntas.domain.service.PreguntasService;

public class FindAllPreguntasUC {

    private PreguntasService preguntaService;

    public FindAllPreguntasUC(PreguntasService preguntaService) {
        this.preguntaService = preguntaService;
    }

    public List<Preguntas> execute(){
        return preguntaService.FindAllPregunta();
    }
}
