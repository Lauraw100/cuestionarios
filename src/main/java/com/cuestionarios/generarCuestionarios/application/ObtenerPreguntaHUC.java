package com.cuestionarios.generarCuestionarios.application;

import java.util.List;
import java.util.Optional;

import com.cuestionarios.generarCuestionarios.domain.entity.GenerarCuestionarios;
import com.cuestionarios.generarCuestionarios.domain.service.GenerarCuestionariosService;

public class ObtenerPreguntaHUC {
    private GenerarCuestionariosService generarCuestionariosService;

    public ObtenerPreguntaHUC(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }
    public  Optional<List<GenerarCuestionarios>> execute(int idopcion){
        return generarCuestionariosService.obtenerPreguntaHija(idopcion);
    }
}
