package com.cuestionarios.categorias.domain.service;

import java.util.List;
import java.util.Optional;

import com.cuestionarios.categorias.domain.entity.Categorias;

public interface CategoriasService {

    public void CreateCategorias(Categorias categorias);
    public void deleteCategorias(int id);
    public void updateCategorias(Categorias categorias);
    public List<Categorias> FindAllCategorias();
    public Optional<Categorias> FindByIdCategorias(int id);
}
