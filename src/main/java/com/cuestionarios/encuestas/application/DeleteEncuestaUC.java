package com.cuestionarios.encuestas.application;

import com.cuestionarios.encuestas.domain.service.EncuestaService;

public class DeleteEncuestaUC {

    private EncuestaService encuestaService;

    public DeleteEncuestaUC(EncuestaService encuestaService) {
        this.encuestaService = encuestaService;
    }

    public void execute(int id){
        encuestaService.deleteEncuesta(id);
    }
}
