package com.cuestionarios.generarCuestionarios.application;

import com.cuestionarios.generarCuestionarios.domain.service.GenerarCuestionariosService;

public class RetornarSubOpidvalorUC {
    private GenerarCuestionariosService generarCuestionariosService;

    public RetornarSubOpidvalorUC(GenerarCuestionariosService generarCuestionariosService) {
        this.generarCuestionariosService = generarCuestionariosService;
    }

    public int execute(int idOpcion, int valorSub){
        return generarCuestionariosService.retornaridSubOpcionPorvalor(idOpcion, valorSub);
    }
}
