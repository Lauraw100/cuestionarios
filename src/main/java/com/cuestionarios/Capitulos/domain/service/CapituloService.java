package com.cuestionarios.capitulos.domain.service;

import java.util.List;
import java.util.Optional;

import com.cuestionarios.capitulos.domain.entity.Capitulo;

public interface CapituloService {

    public void CreateCapitulo(Capitulo capitulo);
    public void deleteCapitulo(int id);
    public void updateCapitulo(Capitulo capitulo);
    public List<Capitulo> FindAllCapitulo();
    public Optional<Capitulo> FindByIdCapitulo(int id);
}
