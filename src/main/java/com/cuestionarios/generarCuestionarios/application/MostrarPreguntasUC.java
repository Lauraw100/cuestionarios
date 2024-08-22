package com.cuestionarios.generarCuestionarios.application;

import java.util.List;
import com.cuestionarios.generarCuestionarios.domain.entity.GenerarCuestionarios;
import com.cuestionarios.generarCuestionarios.domain.service.GenerarCuestionariosService;

public class MostrarPreguntasUC {

    private GenerarCuestionariosService generarCuestionariosService;

    public MostrarPreguntasUC(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public List<GenerarCuestionarios> execute(int capitulo){
        return generarCuestionariosService.mostrar_preguntas(capitulo);
    }
}
