package com.cuestionarios.preguntas.application;

import com.cuestionarios.preguntas.domain.entity.Preguntas;
import com.cuestionarios.preguntas.domain.service.PreguntasService;

public class CreatePreguntasUC {

    private PreguntasService preguntasService;

    public CreatePreguntasUC(PreguntasService preguntasService) {
        this.preguntasService = preguntasService;
    }
    
    public void execute(Preguntas preguntas){
        preguntasService.CreatePregunta(preguntas);
    }
}
