package com.cuestionarios.generarCuestionarios.application;

import com.cuestionarios.generarCuestionarios.domain.service.GenerarCuestionariosService;

public class RetornarSubOpidUC {
    private GenerarCuestionariosService generarCuestionariosService;

    public RetornarSubOpidUC(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public int execute(int idEncuesta, int numCap,int numPreg,int valorOpc,int numSubOpcion) {
     return generarCuestionariosService.retornaridSubOpcion(idEncuesta, numCap, numPreg, valorOpc, numSubOpcion);
    }
}
