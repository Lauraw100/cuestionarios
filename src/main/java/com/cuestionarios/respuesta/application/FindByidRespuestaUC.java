package com.cuestionarios.respuesta.application;

import java.util.Optional;
import com.cuestionarios.respuesta.domain.entity.Respuesta;
import com.cuestionarios.respuesta.domain.service.RespuestaService;

public class FindByidRespuestaUC {

    private RespuestaService respuestaService;

    public FindByidRespuestaUC(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    public Optional<Respuesta> execute(int id) {
        return respuestaService.FindByIdRespuesta(id);
    }
}
