package com.cuestionarios.capitulos.application;

import java.util.List;

import com.cuestionarios.capitulos.domain.entity.Capitulo;
import com.cuestionarios.capitulos.domain.service.CapituloService;

public class FindAllCapituloUC {

    private CapituloService capituloService;

    public FindAllCapituloUC(CapituloService capituloService) {
        this.capituloService = capituloService;
    }

    public List<Capitulo> execute(){
        return capituloService.FindAllCapitulo();
    }
}
