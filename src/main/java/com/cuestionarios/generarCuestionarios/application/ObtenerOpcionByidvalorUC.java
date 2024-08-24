package com.cuestionarios.generarCuestionarios.application;

import java.util.Optional;

import com.cuestionarios.generarCuestionarios.domain.service.GenerarCuestionariosService;

public class ObtenerOpcionByidvalorUC {
    private GenerarCuestionariosService generarCuestionariosService;

    public ObtenerOpcionByidvalorUC(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public Optional<Integer>  execute(int idpregunta, int valor_opcion){
        return generarCuestionariosService.obtenerIdOpcionByvalor(idpregunta, valor_opcion);
     }
}
