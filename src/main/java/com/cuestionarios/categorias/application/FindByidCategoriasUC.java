package com.cuestionarios.categorias.application;

import java.util.Optional;

import com.cuestionarios.categorias.domain.entity.Categorias;
import com.cuestionarios.categorias.domain.service.CategoriasService;

public class FindByidCategoriasUC {

    private CategoriasService categoriasService;

    public FindByidCategoriasUC(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    public Optional<Categorias> execute(int id) {
        return categoriasService.FindByIdCategorias(id);
    }
}
