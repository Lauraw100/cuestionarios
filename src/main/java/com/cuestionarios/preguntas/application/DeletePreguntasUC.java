package com.cuestionarios.preguntas.application;

import com.cuestionarios.preguntas.domain.service.PreguntasService;

public class DeletePreguntasUC {

    private PreguntasService preguntasService;

    public DeletePreguntasUC(PreguntasService preguntasService) {
        this.preguntasService = preguntasService;
    }

    public void execute(int id){
        preguntasService.deletePregunta(id);
    }
}
