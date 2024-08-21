package com.cuestionarios.Capitulos.application;

import java.util.Optional;
import com.cuestionarios.Capitulos.domain.entity.Capitulo;
import com.cuestionarios.Capitulos.domain.service.CapituloService;

public class FindByidCapituloUC {

    private CapituloService capituloService;

    public FindByidCapituloUC(CapituloService capituloService) {
        this.capituloService = capituloService;
    }

    public Optional<Capitulo> execute(int id){
        return capituloService.FindByIdCapitulo(id);
    }
}
