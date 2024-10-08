package com.cuestionarios.login.infrastructure.repository;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

import com.cuestionarios.database.Database;
import com.cuestionarios.login.domain.entity.Login;
import com.cuestionarios.login.domain.service.LoginService;

public class LoginRepository implements LoginService{

    @Override
    public void guardarusuario(Login usuario) {
        String sql = "INSERT INTO usuarios(habilitado, nombre_usuario, contraseña) VALUES (true,?,?)";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario.getUser());
            ps.setString(2, usuario.getPassword());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Usuario agregado con exito");

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    @Override 
    public Optional<Login> validarusuario(String user, String contraseña) {
        String sql = "SELECT id, habilitado FROM usuarios WHERE nombre_usuario = ? AND contraseña = ?";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, user);
            ps.setString(2, contraseña);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idusuario = rs.getInt("id");
                boolean idusuarioh = rs.getBoolean("habilitado");
                Login usuariohabilitado = new Login(idusuario, idusuarioh);
                return Optional.of(usuariohabilitado);
                
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    return Optional.empty();
    }
    @Override

    public Optional<Integer> roles(int id) {
        String sql = "SELECT  id_rol, id_usuario FROM usuarios_roles WHERE id_usuario = ?";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idusuario = rs.getInt("id_rol");
                return Optional.of(idusuario);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


}
