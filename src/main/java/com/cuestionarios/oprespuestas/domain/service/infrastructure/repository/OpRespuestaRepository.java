package com.cuestionarios.oprespuestas.domain.service.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import com.cuestionarios.database.Database;
import com.cuestionarios.oprespuestas.domain.entity.OpRespuesta;
import com.cuestionarios.oprespuestas.domain.service.OpRespuestaService;

public class OpRespuestaRepository implements OpRespuestaService{

    @Override
    public void CreateOpcionesRespuesta(OpRespuesta opcionesRespuesta) {
        String sql = "INSERT INTO opciones_respuesta (valor_opcion, id_categoria_catalogo, id_pregunta, creado_en, actualizado_en, id_opcion_padre , tipo_componente_html, comentario_respuesta, texto_opcion) VALUES (?, ?, ?, NOW(), NOW(),?,?,?,?)";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, opcionesRespuesta.getValorOpcion());
            ps.setInt(2, opcionesRespuesta.getIdCategoriaCatalogo());
            ps.setInt(3, opcionesRespuesta.getIdPregunta());
            ps.setInt(4, opcionesRespuesta.getIdOpcionPadre());
            ps.setString(5, opcionesRespuesta.getTipoComponenteHtml());
            ps.setString(6, opcionesRespuesta.getComentarioRespuesta());
            ps.setString(7, opcionesRespuesta.getTextoOpcion());


            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "OpcionesRespuesta agregado con exito");

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public List<OpRespuesta> FindAllOpcionesRespuesta() {
        String sql = "SELECT id ,valor_opcion, id_categoria_catalogo, id_pregunta, creado_en, actualizado_en, id_opcion_padre, tipo_componente_html, comentario_respuesta, texto_opcion FROM opciones_respuesta";
        List<OpRespuesta> resp = new ArrayList<>();
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs  = ps.executeQuery()) {
            while (rs.next()) {

                int ID = rs.getInt("id");
                int valor_opcion = rs.getInt("valor_opcion");
                int id_categoria_catalogo = rs.getInt("id_categoria_catalogo");
                int id_pregunta = rs.getInt("id_pregunta");
                Timestamp creado_en = rs.getTimestamp("creado_en");
                Timestamp actualizado_en= rs.getTimestamp("actualizado_en");
                int id_opcion_padre = rs.getInt("id_opcion_padre");
                String tipo_componente_html = rs.getString("tipo_componente_html");
                String comentario_respuesta = rs.getString("comentario_respuesta");
                String texto_opcion = rs.getString("texto_opcion");


                OpRespuesta rsp = new OpRespuesta(ID, valor_opcion, id_categoria_catalogo,id_pregunta,creado_en,actualizado_en,id_opcion_padre,tipo_componente_html,comentario_respuesta,texto_opcion);
                resp.add(rsp);
            }   
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    @Override
    public Optional<OpRespuesta> FindByIdOpcionesRespuesta(int id) {
        String sql = "SELECT id ,valor_opcion, id_categoria_catalogo, id_pregunta, creado_en, actualizado_en, id_opcion_padre, tipo_componente_html, comentario_respuesta, texto_opcion FROM opciones_respuesta WHERE id = ?";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int ID = rs.getInt("id");
                int valor_opcion = rs.getInt("valor_opcion");
                int id_categoria_catalogo = rs.getInt("id_categoria_catalogo");
                int id_pregunta = rs.getInt("id_pregunta");
                Timestamp creado_en = rs.getTimestamp("creado_en");
                Timestamp actualizado_en= rs.getTimestamp("actualizado_en");
                int id_opcion_padre = rs.getInt("id_opcion_padre");
                String tipo_componente_html = rs.getString("tipo_componente_html");
                String comentario_respuesta = rs.getString("comentario_respuesta");
                String texto_opcion = rs.getString("texto_opcion");


                OpRespuesta rsp = new OpRespuesta(ID, valor_opcion, id_categoria_catalogo,id_pregunta,creado_en,actualizado_en,id_opcion_padre,tipo_componente_html,comentario_respuesta,texto_opcion);
   
                return Optional.of(rsp);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return Optional.empty();
    }

    @Override
    public void deleteOpcionesRespuesta(int id) {
        String sql = "DELETE FROM opciones_respuesta WHERE id = ?";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "OpcionesRespuesta eliminado con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void updateOpcionesRespuesta(OpRespuesta opcionesRespuesta) {
        String sql = "UPDATE opciones_respuesta SET valor_opcion = ?, id_categoria_catalogo = ?, id_pregunta = ?, actualizado_en = NOW(), id_opcion_padre = ? , tipo_componente_html = ?, comentario_respuesta = ?, texto_opcion = ?  WHERE id = ?";
        try (Connection con = Database.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, opcionesRespuesta.getValorOpcion());
            ps.setInt(2, opcionesRespuesta.getIdCategoriaCatalogo());
            ps.setInt(3, opcionesRespuesta.getIdPregunta());
            ps.setInt(4, opcionesRespuesta.getIdOpcionPadre());
            ps.setString(5, opcionesRespuesta.getTipoComponenteHtml());
            ps.setString(6, opcionesRespuesta.getComentarioRespuesta());
            ps.setString(7, opcionesRespuesta.getTextoOpcion());
            ps.setInt(8, opcionesRespuesta.getId());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,  "opcionesRespuesta actualizado con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
