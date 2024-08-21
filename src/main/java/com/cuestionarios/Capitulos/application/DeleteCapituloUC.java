package com.cuestionarios.Capitulos.application;

import com.cuestionarios.Capitulos.domain.service.CapituloService;

public class DeleteCapituloUC {

    private CapituloService capituloService;

    public DeleteCapituloUC(CapituloService capituloService) {
        this.capituloService = capituloService;
    }

    public void execute(int id){
        capituloService.deleteCapitulo(id);
    }
}
