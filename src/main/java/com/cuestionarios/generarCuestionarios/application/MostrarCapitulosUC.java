package com.cuestionarios.generarCuestionarios.application;

import java.util.List;
import com.cuestionarios.generarCuestionarios.domain.entity.GenerarCuestionarios;
import com.cuestionarios.generarCuestionarios.domain.service.GenerarCuestionariosService;

public class MostrarCapitulosUC {

    private GenerarCuestionariosService generarCuestionariosService;

    public MostrarCapitulosUC(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public List<GenerarCuestionarios> execute(int encuestaid){
        return generarCuestionariosService.mostrar_capitulos(encuestaid);
    }
}
