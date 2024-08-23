package com.cuestionarios.preguntas.domain.service;

import java.util.List;
import java.util.Optional;
import com.cuestionarios.preguntas.domain.entity.Preguntas;

public interface PreguntasService {

    public void CreatePregunta(Preguntas pregunta);
    public void deletePregunta(int id);
    public void updatePregunta(Preguntas pregunta);
    public List<Preguntas> FindAllPregunta();
    public Optional<Preguntas> FindByIdPregunta(int id);
}
