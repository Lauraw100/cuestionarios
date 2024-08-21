package com.cuestionarios.capitulos.application;

import com.cuestionarios.capitulos.domain.service.CapituloService;

public class DeleteCapituloUC {

    private CapituloService capituloService;

    public DeleteCapituloUC(CapituloService capituloService) {
        this.capituloService = capituloService;
    }

    public void execute(int id){
        capituloService.deleteCapitulo(id);
    }
}
