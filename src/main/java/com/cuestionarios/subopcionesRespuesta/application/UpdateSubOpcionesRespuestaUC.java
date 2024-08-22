package com.cuestionarios.subopcionesRespuesta.application;

import com.cuestionarios.subopcionesRespuesta.domain.entity.SubOpcionesRespuesta;
import com.cuestionarios.subopcionesRespuesta.domain.service.SubOpcionesRespuestaService;

public class UpdateSubOpcionesRespuestaUC {

    private SubOpcionesRespuestaService subOpcionesRespuestaService;

    public UpdateSubOpcionesRespuestaUC(SubOpcionesRespuestaService subOpcionesRespuestaService) {
        this.subOpcionesRespuestaService = subOpcionesRespuestaService;
    }

    public void execute(SubOpcionesRespuesta subOpcionesRespuesta){
        subOpcionesRespuestaService.updateSubOpcionesRespuesta(subOpcionesRespuesta);
    }
}
