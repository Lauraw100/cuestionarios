package com.cuestionarios.usuarios.infrastructure.controller;

import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import com.cuestionarios.funciones.Validaciones;
import com.cuestionarios.usuarios.application.CreateUsuarioUC;
import com.cuestionarios.usuarios.application.DeleteUsuarioUC;
import com.cuestionarios.usuarios.application.FindAllUsuarioUC;
import com.cuestionarios.usuarios.application.FindByidUsuarioUC;
import com.cuestionarios.usuarios.application.UpdateUsuarioUC;
import com.cuestionarios.usuarios.domain.entity.Usuario;
import com.cuestionarios.usuarios.domain.service.UsuarioService;
import com.cuestionarios.usuarios.infrastructure.repository.UsuarioRepository;

public class ConsoleAdapterUsuario {

    private UsuarioService usuarioService;
    private CreateUsuarioUC createUsuario;
    private DeleteUsuarioUC delUsuario;
    private UpdateUsuarioUC updUsuario;
    private FindAllUsuarioUC allUsuario;
    private FindByidUsuarioUC idUsuario;


    public ConsoleAdapterUsuario() {
        this.usuarioService = new UsuarioRepository();
        this.createUsuario = new CreateUsuarioUC(usuarioService);
        this.delUsuario = new DeleteUsuarioUC(usuarioService);
        this.updUsuario = new UpdateUsuarioUC(usuarioService);
        this.allUsuario = new FindAllUsuarioUC(usuarioService);
        this.idUsuario = new FindByidUsuarioUC(usuarioService);
    }

    public void Start(){
    String menu = """
                        1. Agregar usuario
                        2. Eliminar usuario
                        3. Listar todos los usuarios
                        4. Buscar usuario por id
                        5. Actualizar usuario
                        6. Salir
                        """;
    Optional<Integer> opcion = Validaciones.mostrarOpciones(menu,1,6);

    if (opcion.isPresent()) {
        int numero = opcion.get();
        ejecutarOpcion(numero);
    } 

  
    }
    public void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:

                String nombre = JOptionPane.showInputDialog(null, "Escriba su nombre: ");
                String contraseña = JOptionPane.showInputDialog(null, "Escriba su contraseña: ");
                Usuario user = new Usuario(true, nombre, contraseña);
                createUsuario.execute(user);
                Start();

                break;
            case 2:
                try {
                    String iddel = JOptionPane.showInputDialog(null, "Escriba el id del usuario para eliminar: ");
                    int iddelete = Integer.parseInt(iddel);
                    delUsuario.execute(iddelete);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "Problemas en el ingreso de datos,Vuelve a intentarlo");
                    Start();
                }
                
                break;
            case 3:
                StringBuilder mensaje = new StringBuilder("Lista de usuarios:\n");
                List<Usuario> usuarios = allUsuario.execute();
                for (Usuario usuario : usuarios) {
                    int id = usuario.getId();
                    String name = usuario.getNombreUsuario();
                    boolean habil = usuario.isHabilitado();
                    String password =  usuario.getContrasena();

                    mensaje.append("ID: ").append(id).append("\n")
                    .append("Nombre: ").append(name).append(", ")
                    .append("Habilitado: ").append(habil ? "Sí" : "No").append(", ")
                    .append("Contraseña: ").append(password).append("\n\n");
     
                }
                JTextArea textArea = new JTextArea(mensaje.toString());
                textArea.setEditable(false); // Para que el texto no sea editable
                textArea.setCaretPosition(1); // Para que comience en la parte superior

                // Crear un JScrollPane y envolver el JTextArea
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300)); // Ajustar el tamaño preferido

                // Mostrar el JScrollPane en un JOptionPane
                JOptionPane.showMessageDialog(null, scrollPane, "Usuarios", JOptionPane.INFORMATION_MESSAGE);
                
                Start();
                break;
            case 4:
                try {
                    String iduser = JOptionPane.showInputDialog(null, "Escriba el id del usuario para buscar: ");
                    int iduserbu = Integer.parseInt(iduser);
                    Optional<Usuario> dato = idUsuario.execute(iduserbu);
                    StringBuilder mensajeid = new StringBuilder("usuarios:\n");
                    if (dato.isPresent()) {
                        Usuario datopre = dato.get();
                        int id = datopre.getId();
                        String name = datopre.getNombreUsuario();
                        boolean habil = datopre.isHabilitado();
                        String password =  datopre.getContrasena();
    
                        
                        mensajeid.append("ID: ").append(id).append("\n")
                            .append("Nombre: ").append(name).append("\n")
                            .append("Habilitado: ").append(habil ? "Sí" : "No").append("\n")
                            .append("Contraseña: ").append(password).append("\n");
                        
                    } 
                    JOptionPane.showMessageDialog(null, mensajeid);
                    Start();
    
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "Problemas en el ingreso de datos,Vuelve a intentarlo");
                    Start();
                }
               
                break;
            case 5:
            try {
                boolean bandera = true;
                String idbyuser = JOptionPane.showInputDialog(null, "Escriba el id del usuario para buscar: ");
                int iduserupd = Integer.parseInt(idbyuser);
                Optional<Usuario> dato = idUsuario.execute(iduserupd);
                Usuario usuarioUpd = dato.get();
                while (bandera) {
                    
                    String opcionesUpd = """
                        1. Nombre
                        2. Contraseña
                        3. Habilitado
                        4. Salir
                        """;

                    Optional<Integer> opc = Validaciones.mostrarOpciones(opcionesUpd,1,4);

                    if (opc.isPresent()) {
                        int numero = opc.get();
                        
                        switch (numero) {
                            case 1:
                                usuarioUpd.setNombreUsuario(JOptionPane.showInputDialog(null, "Ingrese el nuevo Nombre"));
                                break;
                            case 2:
                                usuarioUpd.setContrasena(JOptionPane.showInputDialog(null, "Ingrese la nueva contraseña"));
                                break;
                            case 3:
                                try {
                                    int habil = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese 1 para habilitado y 0 para desabilitar"));
                                    boolean estado = (habil == 1);
                                    usuarioUpd.setHabilitado(estado);
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null,  "Problemas en el ingreso de datos,Vuelve a intentarlo");
                                    Start();
                                }
                                
                                break;
                            case 4:
                                bandera = false;
                                break;
                            }
                        }
                } 
                updUsuario.execute(usuarioUpd); 
                
            } catch (Exception e) {
                e.printStackTrace();
                Start();
            }
                break;
            case 6:
                break;
            default:
                break;
        }
    }
}
