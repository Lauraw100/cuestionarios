package com.cuestionarios.rol.application;

import java.util.List;

import com.cuestionarios.rol.domain.entity.Roles;
import com.cuestionarios.rol.domain.service.RolesService;

public class FindAllRolUC {

    private RolesService rolesService;

    public FindAllRolUC(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    public List<Roles> execute() {
        return rolesService.FindAllRoles();
    }
}
