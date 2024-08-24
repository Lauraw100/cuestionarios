package com.cuestionarios.generarCuestionarios.application;

import java.util.List;
import java.util.Optional;

import com.cuestionarios.generarCuestionarios.domain.entity.GenerarCuestionarios;
import com.cuestionarios.generarCuestionarios.domain.service.GenerarCuestionariosService;

public class ObtenerOpcionidUC {
    private GenerarCuestionariosService generarCuestionariosService;

    public ObtenerOpcionidUC(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }
    public  Optional<List<GenerarCuestionarios>> execute(int id_encuesta,int numero_capitulo, int numero_pregunta, int valor_opcion){
        return generarCuestionariosService.opbteneridopcion(id_encuesta, numero_capitulo, numero_pregunta, valor_opcion);
    }
}
