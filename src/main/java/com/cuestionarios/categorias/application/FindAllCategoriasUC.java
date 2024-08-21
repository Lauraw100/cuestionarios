package com.cuestionarios.categorias.application;

import java.util.List;

import com.cuestionarios.categorias.domain.entity.Categorias;
import com.cuestionarios.categorias.domain.service.CategoriasService;

public class FindAllCategoriasUC {

    private CategoriasService categoriasService;

    public FindAllCategoriasUC(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    public List<Categorias> execute() {
        return categoriasService.FindAllCategorias();
    }
}
