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
import com.cuestionarios.iu.Menu;
import com.cuestionarios.login.infrastructure.controller.ConsoleAdapterLogin;
import com.cuestionarios.oprespuestas.domain.service.infrastructure.controller.ConsoleAdapterOpRespuesta;
import com.cuestionarios.preguntas.infrastructure.controller.ConsoleAdapterPreguntas;
import com.cuestionarios.respuesta.infrastructure.controller.ConsoleAdapterRespuesta;
import com.cuestionarios.rol.infrastructure.controller.ConsoleAdapterRoles;
import com.cuestionarios.rolusuario.infrastructure.controller.ConsoleAdapterUsuarioRol;
import com.cuestionarios.subopcionesRespuesta.infrastructure.controller.ConsoleAdapterSubOpcionesRespuesta;
import com.cuestionarios.usuarios.infrastructure.controller.ConsoleAdapterUsuario;

public class Main {
    public static void main(String[] args) {
        
        ConsoleAdapterLogin lg = new ConsoleAdapterLogin();
        lg.Start();

        Menu menu = new Menu();
        menu.Start();

        ConsoleAdapterUsuario cs = new ConsoleAdapterUsuario();
        cs.Start();

        ConsoleAdapterUsuarioRol caur = new ConsoleAdapterUsuarioRol();
        caur.Start();

        ConsoleAdapterRoles car = new ConsoleAdapterRoles();
        car.Start();

        ConsoleAdapterSubOpcionesRespuesta casr = new ConsoleAdapterSubOpcionesRespuesta();
        casr.Start();

        ConsoleAdapterRespuesta menuR = new ConsoleAdapterRespuesta();
        menuR.Start();

        ConsoleAdapterPreguntas menuPre = new ConsoleAdapterPreguntas();
        menuPre.Start();

        ConsoleAdapterOpRespuesta menuOpcionesRespuesta = new ConsoleAdapterOpRespuesta();
        menuOpcionesRespuesta.Start();

        ConsoleAdapterEncuesta menuEncu = new ConsoleAdapterEncuesta();
        menuEncu.Start();

        ConsoleAdapterCategorias menuCatal = new ConsoleAdapterCategorias();
        menuCatal.Start();

        ConsoleAdapterCapitulo menuCap = new ConsoleAdapterCapitulo();
        menuCap.Start();

        ConsoleAdapterGenerarCuestionarios encuesta = new ConsoleAdapterGenerarCuestionarios();
       encuesta.Start();

    }                    
}

//finishh :)