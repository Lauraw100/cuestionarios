package com.cuestionarios.generarCuestionarios.application;

import java.util.Optional;

import com.cuestionarios.generarCuestionarios.domain.service.GenerarCuestionariosService;

public class MostrarOpcionidPadreUC {
    private GenerarCuestionariosService generarCuestionariosService;

    public MostrarOpcionidPadreUC(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public Optional<Integer> execute(int numpregunta,int numCap, int idEncuesta){
        return generarCuestionariosService.mostraopciondelosidpadres(numpregunta,numCap,idEncuesta);
    }
}
