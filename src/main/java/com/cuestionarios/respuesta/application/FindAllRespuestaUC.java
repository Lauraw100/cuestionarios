package com.cuestionarios.respuesta.application;

import java.util.List;
import com.cuestionarios.respuesta.domain.entity.Respuesta;
import com.cuestionarios.respuesta.domain.service.RespuestaService;

public class FindAllRespuestaUC {

    private RespuestaService respuestaService;

    public FindAllRespuestaUC(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }
  
    public List<Respuesta> execute(){
        return respuestaService.FindAllRespuesta();
    }
}
