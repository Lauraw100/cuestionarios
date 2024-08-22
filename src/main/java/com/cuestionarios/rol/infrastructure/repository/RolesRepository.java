package com.cuestionarios.rol.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import com.cuestionarios.database.Database;
import com.cuestionarios.rol.domain.entity.Roles;
import com.cuestionarios.rol.domain.service.RolesService;

public class RolesRepository implements RolesService{

    @Override
    public void CreateRoles(Roles roles) {
        String sql = "INSERT INTO roles (nombre) VALUES (?)";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, roles.getNombre());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "rol agregado con exito");
  
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public List<Roles> FindAllRoles() {
       String sql = "SELECT id , nombre FROM roles";
        List<Roles> rol = new ArrayList<>();
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs  = ps.executeQuery()) {
            while (rs.next()) {
                int ID = rs.getInt("id");
                String nombre = rs.getString("nombre");

                Roles role = new Roles(ID,nombre);
                rol.add(role);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rol;
    }

    @Override
    public Optional<Roles> FindByIdRoles(int id) {
        String sql = "SELECT id , nombre FROM roles WHERE id = ?";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("id");
                String nombre = rs.getString("nombre");

                Roles rol = new Roles(ID,nombre);
                return Optional.of(rol);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteRoles(int id) {
        String sql = "DELETE FROM roles WHERE id = ?";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "rol eliminado con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRoles(Roles roles) {
        String sql = "UPDATE roles SET nombre = ? WHERE id = ?";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, roles.getNombre());
            ps.setInt(2, roles.getId());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "rol actualizado con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
