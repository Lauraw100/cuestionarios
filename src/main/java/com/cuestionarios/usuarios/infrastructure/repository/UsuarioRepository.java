package com.cuestionarios.usuarios.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import com.cuestionarios.database.Database;
import com.cuestionarios.usuarios.domain.entity.Usuario;
import com.cuestionarios.usuarios.domain.service.UsuarioService;

public class UsuarioRepository implements UsuarioService {

    @Override
    public void CreateUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios(habilitado, nombre_usuario, contraseña) VALUES (?,?,?)";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, usuario.isHabilitado());
            ps.setString(2, usuario.getNombreUsuario());
            ps.setString(3, usuario.getContrasena());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Usuario agregado con exito");

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public List<Usuario> FindAllUsuario() {
        String sql = "SELECT id , habilitado, nombre_usuario, contraseña FROM usuarios";
        List<Usuario> users = new ArrayList<>();
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs  = ps.executeQuery()) {
            while (rs.next()) {
                int ID = rs.getInt("id");
                boolean habilitado = rs.getBoolean("habilitado");
                String nombre = rs.getString("nombre_usuario");
                String password = rs.getString("contraseña");

                Usuario user = new Usuario(ID, habilitado, nombre, password);
                users.add(user);

            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Optional<Usuario> FindByIdUsuario(int id) {
        String sql = "SELECT id , habilitado, nombre_usuario, contraseña FROM usuarios WHERE id = ?";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("id");
                boolean habilitado = rs.getBoolean("habilitado");
                String nombre = rs.getString("nombre_usuario");
                String password = rs.getString("contraseña");

                Usuario user = new Usuario(ID, habilitado, nombre, password);
                return Optional.of(user);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return Optional.empty();
    }

    @Override
    public void deleteUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Usuario eliminado con exito :)");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET habilitado = ?, nombre_usuario = ?, contraseña = ? WHERE id = ?";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, usuario.isHabilitado());
            ps.setString(2, usuario.getNombreUsuario());
            ps.setString(3, usuario.getContrasena());
            ps.setInt(4, usuario.getId());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Usuario actualizado con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
