package com.cuestionarios.subopcionesRespuesta.application;

import java.util.List;

import com.cuestionarios.subopcionesRespuesta.domain.entity.SubOpcionesRespuesta;
import com.cuestionarios.subopcionesRespuesta.domain.service.SubOpcionesRespuestaService;

public class FindAllSubOpcionesRespuestaUC {

    private SubOpcionesRespuestaService subOpcionesRespuestaService;

    public FindAllSubOpcionesRespuestaUC(SubOpcionesRespuestaService subOpcionesRespuestaService) {
        this.subOpcionesRespuestaService = subOpcionesRespuestaService;
    }

    
    public List<SubOpcionesRespuesta> execute(){
        return subOpcionesRespuestaService.FindAllSubOpcionesRespuesta();
    }
}
