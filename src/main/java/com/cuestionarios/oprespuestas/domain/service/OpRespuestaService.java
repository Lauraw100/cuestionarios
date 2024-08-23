package com.cuestionarios.oprespuestas.domain.service;

import java.util.List;
import java.util.Optional;

import com.cuestionarios.oprespuestas.domain.entity.OpRespuesta;

public interface OpRespuestaService {

    public void CreateOpcionesRespuesta(OpRespuesta opcionesRespuesta);
    public void deleteOpcionesRespuesta(int id);
    public void updateOpcionesRespuesta(OpRespuesta opcionesRespuesta);
    public List<OpRespuesta> FindAllOpcionesRespuesta();
    public Optional<OpRespuesta> FindByIdOpcionesRespuesta(int id);
}
