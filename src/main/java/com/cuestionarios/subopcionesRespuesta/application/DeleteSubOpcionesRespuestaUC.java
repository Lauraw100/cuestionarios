package com.cuestionarios.subopcionesRespuesta.application;

import com.cuestionarios.subopcionesRespuesta.domain.service.SubOpcionesRespuestaService;

public class DeleteSubOpcionesRespuestaUC {

     private SubOpcionesRespuestaService subOpcionesRespuestaService;

    public DeleteSubOpcionesRespuestaUC(SubOpcionesRespuestaService subOpcionesRespuestaService) {
        this.subOpcionesRespuestaService = subOpcionesRespuestaService;
    }

    public void execute(int id) {
        subOpcionesRespuestaService.deleteSubOpcionesRespuesta(id);
    }
}
