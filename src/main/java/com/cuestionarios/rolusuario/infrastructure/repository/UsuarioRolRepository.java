package com.cuestionarios.rolusuario.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import com.cuestionarios.database.Database;
import com.cuestionarios.rolusuario.domain.entity.UsuarioRol;
import com.cuestionarios.rolusuario.domain.service.UsuarioRolService;

public class UsuarioRolRepository implements UsuarioRolService {

    @Override
    public void CreateUsuarioRol(UsuarioRol UsuarioRol) {
        String sql = "INSERT INTO usuarios_roles (id_rol, id_usuario) VALUES (?,?)";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, UsuarioRol.getId_rol());
            ps.setInt(2, UsuarioRol.getId_usuario());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Usuario rol agregado con exito");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UsuarioRol> FindAllUsuarioRol() {
        String sql = "SELECT id_rol, id_usuario FROM usuarios_roles";
        List<UsuarioRol> users = new ArrayList<>();
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs  = ps.executeQuery()) {
            while (rs.next()) {
                int ID = rs.getInt("id_rol");
                int IDuser = rs.getInt("id_usuario");

                UsuarioRol user = new UsuarioRol(ID,IDuser);
                users.add(user);

            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Optional<UsuarioRol> FindByIdUsuarioRol(int idUSER) {
        String sql = "SELECT id_rol, id_usuario FROM usuarios_roles WHERE  id_usuario = ?";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idUSER);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("id_rol");
                int IDuser = rs.getInt("id_usuario");

                UsuarioRol user = new UsuarioRol(ID,IDuser);
                return Optional.of(user);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        return Optional.empty();
    }

    @Override
    public void deleteUsuarioRol(int idROL, int idUSER) {
        String sql = "DELETE FROM usuarios_roles WHERE id_rol = ? AND id_usuario = ?";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idROL);
            ps.setInt(2, idUSER);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Usuario rol eliminado con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void updateUsuarioRol(UsuarioRol UsuarioRol) {
        String sql = "UPDATE usuarios_roles SET id_rol = ? WHERE id_usuario = ?";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, UsuarioRol.getId_rol());
            ps.setInt(2, UsuarioRol.getId_usuario());


            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Usuario actualizado con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
}
