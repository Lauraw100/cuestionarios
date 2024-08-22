package com.cuestionarios.generarCuestionarios.application;

import java.util.List;
import java.util.Optional;
import com.cuestionarios.generarCuestionarios.domain.entity.GenerarCuestionarios;
import com.cuestionarios.generarCuestionarios.domain.service.GenerarCuestionariosService;

public class MostrarSubOpcionesUC {

    private GenerarCuestionariosService generarCuestionariosService;

    public MostrarSubOpcionesUC(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }
    
    public Optional<List<GenerarCuestionarios>> execute(int opc){
        return generarCuestionariosService.mostrar_subopciones(opc);
    }
}
