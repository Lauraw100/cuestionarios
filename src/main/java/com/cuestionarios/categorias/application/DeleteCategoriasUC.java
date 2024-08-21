package com.cuestionarios.categorias.application;

import com.cuestionarios.categorias.domain.service.CategoriasService;

public class DeleteCategoriasUC {

    private CategoriasService categoriasService;

    public DeleteCategoriasUC(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    public void execute(int id) {
        categoriasService.deleteCategorias(id);
    }
}
