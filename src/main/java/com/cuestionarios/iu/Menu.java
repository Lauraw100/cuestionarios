package com.cuestionarios.iu;

import java.util.Optional;
import com.cuestionarios.capitulos.infrastructure.controller.ConsoleAdapterCapitulo;
import com.cuestionarios.categorias.infrastructure.controller.ConsoleAdapterCategorias;
import com.cuestionarios.encuestas.infrastructure.controller.ConsoleAdapterEncuesta;
import com.cuestionarios.funciones.Validaciones;
import com.cuestionarios.preguntas.infrastructure.controller.ConsoleAdapterPreguntas;
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
                    """;
        Optional<Integer> opcion = Validaciones.mostrarOpciones(opciones,1,10);

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
                break;

            case 2:
                ConsoleAdapterUsuarioRol menuUsuarioRol = new ConsoleAdapterUsuarioRol();
                menuUsuarioRol.Start();
                break;
            case 3:
                ConsoleAdapterRoles menuRoles = new ConsoleAdapterRoles();
                menuRoles.Start();
                
                break;
            case 4:
                ConsoleAdapterSubOpcionesRespuesta menuSubOpciones = new ConsoleAdapterSubOpcionesRespuesta();
                menuSubOpciones.Start();
                break;
            case 5:
                //ConsoleAdapterRespuesta menuRespuesta = new ConsoleAdapterRespuesta();
                //menuRespuesta.Start();
                
                break;
            case 6:
                ConsoleAdapterPreguntas menuPregunta = new ConsoleAdapterPreguntas();
                menuPregunta.Start();
                break;
            case 7:
                //ConsoleAdapterOpcionesRespuesta menuOpcionesRespuesta = new ConsoleAdapterOpcionesRespuesta();
                //menuOpcionesRespuesta.Start();
                
                break;
            case 8:
                ConsoleAdapterEncuesta menuEncuesta = new ConsoleAdapterEncuesta();
                menuEncuesta.Start();

                break;
            case 9:
                ConsoleAdapterCategorias menuCatalogo = new ConsoleAdapterCategorias();
                menuCatalogo.Start();
                
                break;
            case 10:
                ConsoleAdapterCapitulo menuCapitulo = new ConsoleAdapterCapitulo();
                menuCapitulo.Start();

                
                break;
        
            default:
                break;
        }

    }
}
