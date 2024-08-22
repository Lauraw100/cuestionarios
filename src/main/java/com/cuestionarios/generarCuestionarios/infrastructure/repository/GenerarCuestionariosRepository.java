package com.cuestionarios.generarCuestionarios.infrastructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import com.cuestionarios.database.Database;
import com.cuestionarios.generarCuestionarios.domain.entity.GenerarCuestionarios;
import com.cuestionarios.generarCuestionarios.domain.service.GenerarCuestionariosService;

public class GenerarCuestionariosRepository implements GenerarCuestionariosService {

    @Override
    public List<GenerarCuestionarios> mostrar_encuestas() {
        String sql = "SELECT id, descripcion, nombre FROM encuestas";
        List<GenerarCuestionarios> encuestas = new ArrayList<>();
        try (Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                GenerarCuestionarios cuestionario = new GenerarCuestionarios(id, nombre);
                encuestas.add(cuestionario); 
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!, vuelve a intenntarlo ");
            e.printStackTrace();
        }
        return encuestas;
    }

    @Override
    public List<GenerarCuestionarios> mostrar_capitulos(int encuestaid) {
        String sql = "SELECT numero_capitulo, titulo_capitulo FROM capitulos WHERE id_encuesta = ?";
        List<GenerarCuestionarios> capitulos = new ArrayList<>();
        try (Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, encuestaid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int numero_capitulo = rs.getInt("numero_capitulo");
                String tituloCapitulo = rs.getString("titulo_capitulo");
                 
                GenerarCuestionarios capitulo = new GenerarCuestionarios(numero_capitulo, tituloCapitulo);
                capitulos.add(capitulo);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!, vuelve a intenntarlo ");
            e.printStackTrace();
        }
        return capitulos;
    }

    @Override
    public List<GenerarCuestionarios> mostrar_preguntas(int capituloid) {
        String sql = "SELECT numero_pregunta, texto_pregunta FROM preguntas WHERE id_capitulo = ?";
        List<GenerarCuestionarios> capitulos = new ArrayList<>();
        try (Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, capituloid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int numero_pregunta = rs.getInt("numero_pregunta");
                String texto_pregunta = rs.getString("texto_pregunta");
                 
                GenerarCuestionarios capitulo = new GenerarCuestionarios(numero_pregunta, texto_pregunta);
                capitulos.add(capitulo);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!, vuelve a intenntarlo ");
            e.printStackTrace();
        }
        return capitulos;
    }

    @Override
    public Optional<List<GenerarCuestionarios>> mostrar_opciones(int pregunta) {
        String sql = "SELECT valor_opcion, texto_opcion FROM opciones_respuesta WHERE id_pregunta = ?";
        List<GenerarCuestionarios> capitulos = new ArrayList<>();
        try (Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, pregunta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int numero_pregunta = rs.getInt("valor_opcion");
                String texto_pregunta = rs.getString("texto_opcion");
                 
                GenerarCuestionarios capitulo = new GenerarCuestionarios(numero_pregunta, texto_pregunta);
                capitulos.add(capitulo);
            }
            if (capitulos.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(capitulos);       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!, vuelve a intenntarlo ");
            e.printStackTrace();
        }
        
        return Optional.empty();
    }

    @Override
    public Optional<List<GenerarCuestionarios>> mostrar_subopciones(int opc) {
        String sql = "SELECT numero_subopcion, texto_subopcion FROM subopciones_respuesta WHERE id_opcion_respuesta = ?";
        List<GenerarCuestionarios> capitulos = new ArrayList<>();
        try (Connection connection = Database.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, opc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int numero_subopcion = rs.getInt("numero_subopcion");
                String texto_subopcion = rs.getString("texto_subopcion");
                 
                GenerarCuestionarios capitulo = new GenerarCuestionarios(numero_subopcion, texto_subopcion);
                capitulos.add(capitulo);
            }
            if (capitulos.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(capitulos);       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Error!, vuelve a intentarlo ");
            e.printStackTrace();
        }
        
        return Optional.empty();
    }
    
}
