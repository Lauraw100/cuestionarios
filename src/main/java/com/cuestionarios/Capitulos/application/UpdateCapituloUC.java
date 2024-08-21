package com.cuestionarios.capitulos.application;

import com.cuestionarios.capitulos.domain.entity.Capitulo;
import com.cuestionarios.capitulos.domain.service.CapituloService;

public class UpdateCapituloUC {

    private CapituloService capituloService;

    public UpdateCapituloUC(CapituloService capituloService) {
        this.capituloService = capituloService;
    }

    public void execute(Capitulo capitulo){
        capituloService.updateCapitulo(capitulo);
    }
}
