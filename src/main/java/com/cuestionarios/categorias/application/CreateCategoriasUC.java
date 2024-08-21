package com.cuestionarios.categorias.application;

import com.cuestionarios.categorias.domain.entity.Categorias;
import com.cuestionarios.categorias.domain.service.CategoriasService;

public class CreateCategoriasUC {

    private CategoriasService categoriasService;

    public CreateCategoriasUC(CategoriasService categoriasCatalogoService) {
        this.categoriasService = categoriasCatalogoService;
    }

    public void execute(Categorias categoriasCatalogo) {
        categoriasService.CreateCategorias(categoriasCatalogo);
    }
}
