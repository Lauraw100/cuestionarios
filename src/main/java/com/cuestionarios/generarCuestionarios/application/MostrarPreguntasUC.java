package com.cuestionarios.generarCuestionarios.application;

import java.util.List;
import java.util.Optional;
import com.cuestionarios.generarCuestionarios.domain.entity.GenerarCuestionarios;
import com.cuestionarios.generarCuestionarios.domain.service.GenerarCuestionariosService;

public class MostrarPreguntasUC {
    private GenerarCuestionariosService generarCuestionariosService;

    public MostrarPreguntasUC(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public Optional<List<GenerarCuestionarios>> execute(int numcapitulo, int idencuesta){
        return generarCuestionariosService.mostrar_preguntas(numcapitulo,idencuesta);
    }
}
