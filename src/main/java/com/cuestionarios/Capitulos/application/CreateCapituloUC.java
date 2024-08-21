package com.cuestionarios.capitulos.application;

import com.cuestionarios.capitulos.domain.entity.Capitulo;
import com.cuestionarios.capitulos.domain.service.CapituloService;

public class CreateCapituloUC {

    private CapituloService capituloService;

    public CreateCapituloUC(CapituloService capituloService) {
        this.capituloService = capituloService;
    }

    public void execute(Capitulo capitulos){
        capituloService.CreateCapitulo(capitulos);
    }
}
