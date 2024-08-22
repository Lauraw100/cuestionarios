package com.cuestionarios.rol.domain.service;

import java.util.List;
import java.util.Optional;

import com.cuestionarios.rol.domain.entity.Roles;

public interface RolesService {

     public void CreateRoles(Roles roles);
    public void deleteRoles(int id);
    public void updateRoles(Roles roles);
    public List<Roles> FindAllRoles();
    public Optional<Roles> FindByIdRoles(int id);
}
