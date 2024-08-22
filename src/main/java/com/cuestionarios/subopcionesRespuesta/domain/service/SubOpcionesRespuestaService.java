package com.cuestionarios.subopcionesRespuesta.domain.service;

import java.util.List;
import java.util.Optional;

import com.cuestionarios.subopcionesRespuesta.domain.entity.SubOpcionesRespuesta;

public interface SubOpcionesRespuestaService {

    public void CreateSubOpcionesRespuesta(SubOpcionesRespuesta subOpcionesRespuesta);
    public void deleteSubOpcionesRespuesta(int id);
    public void updateSubOpcionesRespuesta(SubOpcionesRespuesta subOpcionesRespuesta);
    public List<SubOpcionesRespuesta> FindAllSubOpcionesRespuesta();
    public Optional<SubOpcionesRespuesta> FindByIdSubOpcionesRespuesta(int id);
}


