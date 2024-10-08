package com.cuestionarios.generarCuestionarios.application;

import java.util.List;
import java.util.Optional;

import com.cuestionarios.generarCuestionarios.domain.entity.GenerarCuestionarios;
import com.cuestionarios.generarCuestionarios.domain.service.GenerarCuestionariosService;

public class MostrarPreguntaByidUC {
    private GenerarCuestionariosService generarCuestionariosService;

    public MostrarPreguntaByidUC(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }
    
    public  Optional<List<GenerarCuestionarios>> execute(int id){
        return generarCuestionariosService.mostrarpreguntaporId(id);
    }
}
