package com.cuestionarios.rol.application;

import com.cuestionarios.rol.domain.service.RolesService;

public class DeleteRolUC {

    private RolesService rolesService;

    public DeleteRolUC(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    public void execute(int id) {
        rolesService.deleteRoles(id);
    }
}
