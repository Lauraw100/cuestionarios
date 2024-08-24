package com.cuestionarios.iu;


import javax.swing.JOptionPane;
import java.util.Optional;
import com.cuestionarios.capitulos.infrastructure.controller.ConsoleAdapterCapitulo;
import com.cuestionarios.categorias.infrastructure.controller.ConsoleAdapterCategorias;
import com.cuestionarios.encuestas.infrastructure.controller.ConsoleAdapterEncuesta;
import com.cuestionarios.funciones.Validaciones;
import com.cuestionarios.oprespuestas.domain.service.infrastructure.controller.ConsoleAdapterOpRespuesta;
import com.cuestionarios.preguntas.infrastructure.controller.ConsoleAdapterPreguntas;
import com.cuestionarios.respuesta.infrastructure.controller.ConsoleAdapterRespuesta;
import com.cuestionarios.rol.infrastructure.controller.ConsoleAdapterRoles;
import com.cuestionarios.rolusuario.infrastructure.controller.ConsoleAdapterUsuarioRol;
import com.cuestionarios.subopcionesRespuesta.infrastructure.controller.ConsoleAdapterSubOpcionesRespuesta;
import com.cuestionarios.usuarios.infrastructure.controller.ConsoleAdapterUsuario;

public class Menu {

    public void Start(){
            String opciones = """
                    1. Administrar Clientes_
                    2. Administrar Usuarios-Rol_
                    3. Administrar Roles_
                    4. Administrar SubOpciones_
                    5. Administrar Respuestas_
                    6. Administrar Preguntas_
                    7. Administrar Opciones_
                    8. Administrar Encuestas_
                    9. Administrar Categorias_
                    10. Administrar Capitulos_
                    11. Salir_
                    """;
        Optional<Integer> opcion = Validaciones.mostrarOpciones(opciones,1,11);

        if (opcion.isPresent()) {
            int numero = opcion.get();
            ejecutarOpcion(numero);
        } 
    }
    public void ejecutarOpcion(int numero){
        switch (numero) {
            case 1:
                ConsoleAdapterUsuario menuClientes = new ConsoleAdapterUsuario();
                menuClientes.Start();
                Start();
                break;

            case 2:
                ConsoleAdapterUsuarioRol menuUsuarioRol = new ConsoleAdapterUsuarioRol();
                menuUsuarioRol.Start();
                Start();
                break;
            case 3:
                ConsoleAdapterRoles menuRoles = new ConsoleAdapterRoles();
                menuRoles.Start();
                Start();
                break;
            case 4:
                ConsoleAdapterSubOpcionesRespuesta menuSubOpciones = new ConsoleAdapterSubOpcionesRespuesta();
                menuSubOpciones.Start();
                Start();
                break;
            case 5:
                ConsoleAdapterRespuesta menuRespuesta = new ConsoleAdapterRespuesta();
                menuRespuesta.Start();
                Start();
                
                break;
            case 6:
                ConsoleAdapterPreguntas menuPregunta = new ConsoleAdapterPreguntas();
                menuPregunta.Start();
                Start();
                break;
            case 7:
                ConsoleAdapterOpRespuesta menuOpcionesRespuesta = new ConsoleAdapterOpRespuesta();
                menuOpcionesRespuesta.Start();
                Start();
                break;
            case 8:
                ConsoleAdapterEncuesta menuEncuesta = new ConsoleAdapterEncuesta();
                menuEncuesta.Start();
                Start();
                break;
            case 9:
                ConsoleAdapterCategorias menuCatalogo = new ConsoleAdapterCategorias();
                menuCatalogo.Start();
                Start();
                break;
            case 10:
                ConsoleAdapterCapitulo menuCapitulo = new ConsoleAdapterCapitulo();
                menuCapitulo.Start();
                Start();
                
                break;
            case 11:
                JOptionPane.showMessageDialog(null, "Saliendo Del Programa");
                break;
        
            default:
                break;
        }

    }
}
