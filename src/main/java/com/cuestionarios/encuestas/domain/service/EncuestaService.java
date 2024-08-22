package com.cuestionarios.encuestas.domain.service;

import java.util.List;
import java.util.Optional;

import com.cuestionarios.encuestas.domain.entity.Encuesta;

public interface EncuestaService {

    public void CreateEncuesta(Encuesta encuesta);
    public void deleteEncuesta(int id);
    public void updateEncuesta(Encuesta encuesta);
    public List<Encuesta> FindAllEncuesta();
    public Optional<Encuesta> FindByIdEncuesta(int id);
}
