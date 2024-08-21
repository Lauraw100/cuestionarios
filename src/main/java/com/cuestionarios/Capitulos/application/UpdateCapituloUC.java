package com.cuestionarios.Capitulos.application;

import com.cuestionarios.Capitulos.domain.entity.Capitulo;
import com.cuestionarios.Capitulos.domain.service.CapituloService;

public class UpdateCapituloUC {

    private CapituloService capituloService;

    public UpdateCapituloUC(CapituloService capituloService) {
        this.capituloService = capituloService;
    }

    public void execute(Capitulo capitulo){
        capituloService.updateCapitulo(capitulo);
    }
}
