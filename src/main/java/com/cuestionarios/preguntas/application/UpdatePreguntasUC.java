package com.cuestionarios.preguntas.application;

import com.cuestionarios.preguntas.domain.entity.Preguntas;
import com.cuestionarios.preguntas.domain.service.PreguntasService;

public class UpdatePreguntasUC {

    private PreguntasService preguntaService;

    public UpdatePreguntasUC(PreguntasService preguntaService) {
        this.preguntaService = preguntaService;
    }

    public void execute(Preguntas pregunta){
        preguntaService.updatePregunta(pregunta);
    }
}
