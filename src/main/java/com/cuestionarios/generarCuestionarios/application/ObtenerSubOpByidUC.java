package com.cuestionarios.generarCuestionarios.application;

import java.util.List;
import java.util.Optional;

import com.cuestionarios.generarCuestionarios.domain.entity.GenerarCuestionarios;
import com.cuestionarios.generarCuestionarios.domain.service.GenerarCuestionariosService;

public class ObtenerSubOpByidUC {
    private GenerarCuestionariosService generarCuestionariosService;

    public ObtenerSubOpByidUC(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }
     public Optional<List<GenerarCuestionarios>> execute(int idopcion ){
        return generarCuestionariosService.obtenerSubOpcionesById(idopcion);
     }
}
