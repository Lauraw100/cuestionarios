package com.cuestionarios.preguntas.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import com.cuestionarios.database.Database;
import com.cuestionarios.preguntas.domain.entity.Preguntas;
import com.cuestionarios.preguntas.domain.service.PreguntasService;

public class PreguntasRepository implements PreguntasService{

     @Override
    public void CreatePregunta(Preguntas pregunta) {
        String sql = "CALL validarnumeroPregunta(?,?,?,?)";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, pregunta.getIdCapitulo());
            ps.setString(2, pregunta.getTipoRespuesta());
            ps.setString(3, pregunta.getComentarioPregunta());
            ps.setString(4, pregunta.getTextoPregunta());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Preguntas agregado con exito");

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,  "verfica los datos ingresados");
            e.printStackTrace();
        }
        
    }

    @Override
    public List<Preguntas> FindAllPregunta() {
        String sql = "SELECT id, id_capitulo, creado_en, actualizado_en, numero_pregunta, tipo_respuesta, comentario_pregunta, texto_pregunta FROM  preguntas";
        List<Preguntas> resp = new ArrayList<>();
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs  = ps.executeQuery()) {
            while (rs.next()) {
                int ID = rs.getInt("id");
                int id_capitulo = rs.getInt("id_capitulo");
                Timestamp creado_en = rs.getTimestamp("creado_en");
                Timestamp actualizado_en = rs.getTimestamp("actualizado_en");
                String numero_pregunta = rs.getString("numero_pregunta");
                String tipo_Pregunta = rs.getString("tipo_respuesta");
                String comentario_pregunta = rs.getString("comentario_pregunta");
                String texto_pregunta = rs.getString("texto_pregunta");


                Preguntas rsp = new Preguntas(ID, id_capitulo, creado_en, actualizado_en,numero_pregunta, tipo_Pregunta, comentario_pregunta, texto_pregunta);
                resp.add(rsp);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    @Override
    public Optional<Preguntas> FindByIdPregunta(int id) {
        String sql = "SELECT id ,id_capitulo, creado_en, actualizado_en, numero_pregunta, tipo_respuesta, comentario_pregunta, texto_pregunta FROM preguntas WHERE id = ?";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("id");
                int id_capitulo = rs.getInt("id_capitulo");
                Timestamp creado_en = rs.getTimestamp("creado_en");
                Timestamp actualizado_en = rs.getTimestamp("actualizado_en");
                String numero_pregunta = rs.getString("numero_pregunta");
                String tipo_Pregunta = rs.getString("tipo_respuesta");
                String comentario_pregunta = rs.getString("comentario_pregunta");
                String texto_pregunta = rs.getString("texto_pregunta");


                Preguntas rsp = new Preguntas(ID, id_capitulo, creado_en, actualizado_en,numero_pregunta, tipo_Pregunta, comentario_pregunta, texto_pregunta);
                return Optional.of(rsp);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return Optional.empty();
    }

    @Override
    public void deletePregunta(int id) {
        String sql = "DELETE FROM Preguntas WHERE id = ?";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Pregunta eliminado con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void updatePregunta(Preguntas preguntas) {
        String sql = "CALL actualizarpregunta(?,?,?,?,?)";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(2,  preguntas.getIdCapitulo());
            ps.setString(3, preguntas.getTipoRespuesta());
            ps.setString(4, preguntas.getComentarioPregunta());
            ps.setString(5, preguntas.getTextoPregunta());
            ps.setInt(1, preguntas.getId());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "Pregunta actualizado con exito");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,  "verfica los datos ingresados y que el numero de pregunta sea unico");
            e.printStackTrace();
        }
        
    }
}
