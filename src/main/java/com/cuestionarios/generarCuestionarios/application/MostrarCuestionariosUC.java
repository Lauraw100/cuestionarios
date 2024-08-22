package com.cuestionarios.generarCuestionarios.application;

import java.util.List;
import com.cuestionarios.generarCuestionarios.domain.entity.GenerarCuestionarios;
import com.cuestionarios.generarCuestionarios.domain.service.GenerarCuestionariosService;

public class MostrarCuestionariosUC {

    private GenerarCuestionariosService generarCuestionariosService;

    public MostrarCuestionariosUC(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public List<GenerarCuestionarios> execute(){
        return generarCuestionariosService.mostrar_encuestas();
    }

}
