package com.cuestionarios;

import java.sql.Connection;

import com.cuestionarios.capitulos.infrastructure.controller.ConsoleAdapterCapitulo;
import com.cuestionarios.database.Database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Main {
    public static void main(String[] args) {
        
        // ConsoleAdapterUsuario cs = new ConsoleAdapterUsuario();
        // cs.Start();

        // ConsoleAdapterUsuarioRol caur = new ConsoleAdapterUsuarioRol();
        // caur.Start();

        // ConsoleAdapterRoles car = new ConsoleAdapterRoles();
        // car.Start();

        // ConsoleAdapterSubOpcionesRespuesta casor = new ConsoleAdapterSubOpcionesRespuesta();
        // casor.Start();

        // ConsoleAdapterRespuesta menuRespuesta = new ConsoleAdapterRespuesta();
        // menuRespuesta.Start();

        //ConsoleAdapterPregunta menuPregunta = new ConsoleAdapterPregunta();
        //menuPregunta.Start();

        // ConsoleAdapterOpcionesRespuesta menuOpcionesRespuesta = new ConsoleAdapterOpcionesRespuesta();
        // menuOpcionesRespuesta.Start();

        // ConsoleAdapterEncuesta menuEncuesta = new ConsoleAdapterEncuesta();
        // menuEncuesta.Start();

        // ConsoleAdapterCategoriasCatalogo menuCatalogo = new ConsoleAdapterCategoriasCatalogo();
        // menuCatalogo.Start();

        //ConsoleAdapterCapitulo menuCapitulo = new ConsoleAdapterCapitulo();
        //menuCapitulo.Start();

        // ConsoleAdapterGenerarCuestionarios encuesta = new ConsoleAdapterGenerarCuestionarios();
        // encuesta.Start();

    }                    
}