package com.cuestionarios.categorias.application;

import com.cuestionarios.categorias.domain.entity.Categorias;
import com.cuestionarios.categorias.domain.service.CategoriasService;

public class UpdateCategoriasUC {
    
    private CategoriasService categoriasService;

    public UpdateCategoriasUC(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    public void execute(Categorias categorias){
        categoriasService.updateCategorias(categorias);
    }
}
