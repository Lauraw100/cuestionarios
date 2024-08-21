package com.cuestionarios.Capitulos.application;

import java.util.List;
import com.cuestionarios.Capitulos.domain.entity.Capitulo;
import com.cuestionarios.Capitulos.domain.service.CapituloService;

public class FindAllCapituloUC {

    private CapituloService capituloService;

    public FindAllCapituloUC(CapituloService capituloService) {
        this.capituloService = capituloService;
    }

    public List<Capitulo> execute(){
        return capituloService.FindAllCapitulo();
    }
}
