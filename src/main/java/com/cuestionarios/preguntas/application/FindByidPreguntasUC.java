package com.cuestionarios.preguntas.application;

import java.util.Optional;

import com.cuestionarios.preguntas.domain.entity.Preguntas;
import com.cuestionarios.preguntas.domain.service.PreguntasService;


public class FindByidPreguntasUC {

    private PreguntasService preguntaService;

    public FindByidPreguntasUC(PreguntasService preguntasService) {
        this.preguntaService = preguntasService;
    }
    
    public Optional<Preguntas> execute(int id){
        return preguntaService.FindByIdPregunta(id);
    }
}
