package com.cuestionarios.subopcionesRespuesta.application;

import com.cuestionarios.subopcionesRespuesta.domain.entity.SubOpcionesRespuesta;
import com.cuestionarios.subopcionesRespuesta.domain.service.SubOpcionesRespuestaService;

public class CreateSubOpcionesRespuestaUC {

    private SubOpcionesRespuestaService subOpcionesRespuestaService;

    public CreateSubOpcionesRespuestaUC(SubOpcionesRespuestaService subOpcionesRespuestaService) {
        this.subOpcionesRespuestaService = subOpcionesRespuestaService;
    }

    public void execute(SubOpcionesRespuesta subOpcionesRespuesta){
        subOpcionesRespuestaService.CreateSubOpcionesRespuesta(subOpcionesRespuesta);

    }

}
