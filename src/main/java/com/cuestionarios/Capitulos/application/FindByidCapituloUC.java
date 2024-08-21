package com.cuestionarios.capitulos.application;

import java.util.Optional;

import com.cuestionarios.capitulos.domain.entity.Capitulo;
import com.cuestionarios.capitulos.domain.service.CapituloService;

public class FindByidCapituloUC {

    private CapituloService capituloService;

    public FindByidCapituloUC(CapituloService capituloService) {
        this.capituloService = capituloService;
    }

    public Optional<Capitulo> execute(int id){
        return capituloService.FindByIdCapitulo(id);
    }
}
