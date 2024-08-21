package com.cuestionarios.categorias.infrastructure.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;

import com.cuestionarios.categorias.domain.entity.Categorias;
import com.cuestionarios.categorias.domain.service.CategoriasService;
import com.cuestionarios.database.Database;

public class CategoriasRepository implements CategoriasService{

    @Override 
    public void CreateCategorias(Categorias categorias) {
        String sql = "INSERT INTO categorias_catalogo (creado_en, actualizado_en, nombre) VALUES (NOW(),NOW(),?)";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(2, categorias.getNombre());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Categoria agregada con exito");

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Categorias> FindAllCategorias() {
        String sql = "SELECT id, creado_en, actualizado_en, nombre FROM categorias_catalogo";
        List<Categorias> resp = new ArrayList<>();
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs  = ps.executeQuery()) {
            while (rs.next()) {
                int ID = rs.getInt("id");
                Timestamp creado_en = rs.getTimestamp("creado_en"); 
                Timestamp actualizado_en = rs.getTimestamp("actualizado_en"); 
                String nombre = rs.getString("nombre");


                Categorias rsp = new Categorias(ID, creado_en, actualizado_en, nombre);
                resp.add(rsp);

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    @Override
    public Optional<Categorias> FindByIdCategorias(int id) {
        String sql = "SELECT id , creado_en, actualizado_en,  nombre FROM categorias_catalogo WHERE id = ?";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("id");
                Timestamp creado_en = rs.getTimestamp("creado_en"); 
                Timestamp actualizado_en = rs.getTimestamp("actualizado_en"); 
                String nombre = rs.getString("nombre");


                Categorias rsp = new Categorias(ID, creado_en, actualizado_en, nombre);
                return Optional.of(rsp);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return Optional.empty();
    }

    @Override
    public void deleteCategorias(int id) {
        String sql = "DELETE FROM CategoriasCatalogo WHERE id = ?";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Categoria eliminada con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCategorias(Categorias categorias) {
        String sql = "UPDATE categorias_catalogo SET actualizado_en = NOW(),  nombre = ? WHERE id = ?";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, categorias.getNombre());
            ps.setInt(2, categorias.getId());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Categoria actualizada con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
