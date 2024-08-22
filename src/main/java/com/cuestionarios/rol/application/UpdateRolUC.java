package com.cuestionarios.rol.application;

import com.cuestionarios.rol.domain.entity.Roles;
import com.cuestionarios.rol.domain.service.RolesService;

public class UpdateRolUC {

    private RolesService rolesService;

    public UpdateRolUC(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    public void execute(Roles roles){
        rolesService.updateRoles(roles);
    }
}
