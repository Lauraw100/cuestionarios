package com.cuestionarios.rol.application;

import com.cuestionarios.rol.domain.entity.Roles;
import com.cuestionarios.rol.domain.service.RolesService;

public class CreateRolUC {

     private RolesService rolesService;

    public CreateRolUC(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    public void execute(Roles roles){
        rolesService.CreateRoles(roles);
    }
}
