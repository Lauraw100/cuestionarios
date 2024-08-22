package com.cuestionarios.rol.application;

import java.util.Optional;

import com.cuestionarios.rol.domain.entity.Roles;
import com.cuestionarios.rol.domain.service.RolesService;

public class FindByidRolUC {

    private RolesService rolesService;

    public FindByidRolUC(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    public Optional<Roles> execute(int id) {
        return rolesService.FindByIdRoles(id);
    }

}
