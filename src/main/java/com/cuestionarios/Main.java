package com.cuestionarios;

import java.sql.Connection;
import com.cuestionarios.database.Database;
import com.cuestionarios.encuestas.infrastructure.controller.ConsoleAdapterEncuesta;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.cuestionarios.database.Database;

import com.cuestionarios.capitulos.infrastructure.controller.ConsoleAdapterCapitulo;
import com.cuestionarios.categorias.infrastructure.controller.ConsoleAdapterCategorias;
import com.cuestionarios.generarCuestionarios.infrastructure.controller.ConsoleAdapterGenerarCuestionarios;
import com.cuestionarios.rol.infrastructure.controller.ConsoleAdapterRoles;
import com.cuestionarios.rolusuario.infrastructure.controller.ConsoleAdapterUsuarioRol;
import com.cuestionarios.subopcionesRespuesta.infrastructure.controller.ConsoleAdapterSubOpcionesRespuesta;
import com.cuestionarios.usuarios.infrastructure.controller.ConsoleAdapterUsuario;

public class Main {
    public static void main(String[] args) {
        
        ConsoleAdapterUsuario cs = new ConsoleAdapterUsuario();
        cs.Start();

        ConsoleAdapterUsuarioRol caur = new ConsoleAdapterUsuarioRol();
        caur.Start();

        ConsoleAdapterRoles car = new ConsoleAdapterRoles();
        car.Start();

        ConsoleAdapterSubOpcionesRespuesta casor = new ConsoleAdapterSubOpcionesRespuesta();
        casor.Start();

        // ConsoleAdapterRespuesta menuRespuesta = new ConsoleAdapterRespuesta();
        // menuRespuesta.Start();

        //ConsoleAdapterPregunta menuPregunta = new ConsoleAdapterPregunta();
        //menuPregunta.Start();

        // ConsoleAdapterOpcionesRespuesta menuOpcionesRespuesta = new ConsoleAdapterOpcionesRespuesta();
        // menuOpcionesRespuesta.Start();

        ConsoleAdapterEncuesta menuEncuesta = new ConsoleAdapterEncuesta();
        menuEncuesta.Start();

        ConsoleAdapterCategorias menuCatalogo = new ConsoleAdapterCategorias();
        menuCatalogo.Start();

        ConsoleAdapterCapitulo menuCapitulo = new ConsoleAdapterCapitulo();
        menuCapitulo.Start();

        ConsoleAdapterGenerarCuestionarios encuesta = new ConsoleAdapterGenerarCuestionarios();
        encuesta.Start();

    }                    
}