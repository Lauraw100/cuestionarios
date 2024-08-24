package com.cuestionarios.generarCuestionarios.application;

import java.util.List;
import java.util.Optional;

import com.cuestionarios.generarCuestionarios.domain.entity.GenerarCuestionarios;
import com.cuestionarios.generarCuestionarios.domain.service.GenerarCuestionariosService;

public class ObtenerOpcionByidUC {
    private GenerarCuestionariosService generarCuestionariosService;

    public ObtenerOpcionByidUC(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public  Optional<List<GenerarCuestionarios>> execute(int idpregunta){
        return generarCuestionariosService.obtenerOpcionesById(idpregunta);
    }
}
