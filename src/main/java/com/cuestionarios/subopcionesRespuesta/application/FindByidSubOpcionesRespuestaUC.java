package com.cuestionarios.subopcionesRespuesta.application;

import java.util.Optional;

import com.cuestionarios.subopcionesRespuesta.domain.entity.SubOpcionesRespuesta;
import com.cuestionarios.subopcionesRespuesta.domain.service.SubOpcionesRespuestaService;

public class FindByidSubOpcionesRespuestaUC {

    private SubOpcionesRespuestaService subOpcionesRespuestaService;

    public FindByidSubOpcionesRespuestaUC(SubOpcionesRespuestaService subOpcionesRespuestaService) {
        this.subOpcionesRespuestaService = subOpcionesRespuestaService;
    }

    public Optional<SubOpcionesRespuesta> execute(int id){
        return subOpcionesRespuestaService.FindByIdSubOpcionesRespuesta(id);
    }
}
