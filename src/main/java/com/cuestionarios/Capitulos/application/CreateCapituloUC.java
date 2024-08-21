package com.cuestionarios.Capitulos.application;

import com.cuestionarios.Capitulos.domain.entity.Capitulo;
import com.cuestionarios.Capitulos.domain.service.CapituloService;

public class CreateCapituloUC {

    private CapituloService capituloService;

    public CreateCapituloUC(CapituloService capituloService) {
        this.capituloService = capituloService;
    }

    public void execute(Capitulo capitulos){
        capituloService.CreateCapitulo(capitulos);
    }
}
