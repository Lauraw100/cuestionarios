package com.cuestionarios.generarCuestionarios.application;

import java.util.List;
import java.util.Optional;
import com.cuestionarios.generarCuestionarios.domain.entity.GenerarCuestionarios;
import com.cuestionarios.generarCuestionarios.domain.service.GenerarCuestionariosService;


public class MostrarOpcionesUC {
    private GenerarCuestionariosService generarCuestionariosService;

    public MostrarOpcionesUC(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public Optional<List<GenerarCuestionarios>> execute(int numpregunta,int numCap, int idEncuesta){
        return generarCuestionariosService.mostrar_opciones(numpregunta,numCap,idEncuesta);
    }
}
