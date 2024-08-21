package com.cuestionarios.capitulos.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;

import com.cuestionarios.capitulos.domain.entity.Capitulo;
import com.cuestionarios.capitulos.domain.service.CapituloService;
import com.cuestionarios.database.Database;

public class CapituloRepository implements CapituloService{

    @Override
    public void CreateCapitulo(Capitulo capitulo) {
        String sql = "CALL validarnumerocapitulo(?,?)";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, capitulo.getIdEncuesta());
            ps.setString(2, capitulo.getTituloCapitulo());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Capitulos agregados con exito");

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Capitulo> FindAllCapitulo() {
        String sql = "SELECT id, id_encuesta, creado_en, actualizado_en, numero_capitulo, titulo_capitulo FROM Capitulos";
        List<Capitulo> resp = new ArrayList<>();
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs  = ps.executeQuery()) {
            while (rs.next()) {
                int ID = rs.getInt("id");
                int id_Capitulo = rs.getInt("id_encuesta");
                Timestamp creado_en = rs.getTimestamp("creado_en"); 
                Timestamp actualizado_en = rs.getTimestamp("actualizado_en"); 
                String numero_capitulo = rs.getString("numero_capitulo");
                String titulo_capitulo = rs.getString("titulo_capitulo");


                Capitulo rsp = new Capitulo(ID, id_Capitulo, creado_en, actualizado_en, numero_capitulo, titulo_capitulo);
                resp.add(rsp);

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    @Override
    public void deleteCapitulo(int id) {
        String sql = "DELETE FROM Capitulos WHERE id = ?";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Capitulo eliminado con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateCapitulo(Capitulo capitulo) {
        String sql = "CALL actualizarcapitulo(?,?,?);";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(2, capitulo.getIdEncuesta());
            ps.setString(3, capitulo.getTituloCapitulo());
            ps.setInt(1, capitulo.getId());


            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Capitulo actualizado con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Capitulo> FindByIdCapitulo(int id) {
        String sql = "SELECT id ,id_encuesta, creado_en, actualizado_en, numero_capitulo, titulo_capitulo FROM Capitulos WHERE id = ?";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("id");
                int id_Capitulo = rs.getInt("id_encuesta");
                Timestamp creado_en = rs.getTimestamp("creado_en"); 
                Timestamp actualizado_en = rs.getTimestamp("actualizado_en"); 
                String numero_capitulo = rs.getString("numero_capitulo");
                String titulo_capitulo = rs.getString("titulo_capitulo");


                Capitulo rsp = new Capitulo( ID, id_Capitulo, creado_en, actualizado_en, numero_capitulo, titulo_capitulo);
                return Optional.of(rsp);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return Optional.empty();
    }

}
