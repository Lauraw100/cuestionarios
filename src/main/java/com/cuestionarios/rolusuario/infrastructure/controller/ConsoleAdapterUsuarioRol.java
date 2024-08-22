package com.cuestionarios.rolusuario.infrastructure.controller;

import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import com.cuestionarios.funciones.Validaciones;
import com.cuestionarios.rolusuario.application.CreateUsuarioRolUC;
import com.cuestionarios.rolusuario.application.DeleteUsuarioRolUC;
import com.cuestionarios.rolusuario.application.FindAllUsuarioRolUC;
import com.cuestionarios.rolusuario.application.FindByidUsuarioRolUC;
import com.cuestionarios.rolusuario.application.UpdateUsuarioRolUC;
import com.cuestionarios.rolusuario.domain.entity.UsuarioRol;
import com.cuestionarios.rolusuario.domain.service.UsuarioRolService;
import com.cuestionarios.rolusuario.infrastructure.repository.UsuarioRolRepository;

public class ConsoleAdapterUsuarioRol {

     private UsuarioRolService usuarioRolService;
    private CreateUsuarioRolUC createUR;
    private DeleteUsuarioRolUC delUR;
    private UpdateUsuarioRolUC updUR;
    private FindByidUsuarioRolUC idUR;
    private FindAllUsuarioRolUC allUR;


    public ConsoleAdapterUsuarioRol() {

        this.usuarioRolService = new UsuarioRolRepository();
        this.createUR = new CreateUsuarioRolUC(usuarioRolService);
        this.delUR = new DeleteUsuarioRolUC(usuarioRolService);
        this.updUR = new UpdateUsuarioRolUC(usuarioRolService);
        this.idUR = new FindByidUsuarioRolUC(usuarioRolService);
        this.allUR = new FindAllUsuarioRolUC(usuarioRolService);
    }


    public void Start(){
        String menu = """
                            1. Agregar usuario rol
                            2. Eliminar usuario rol
                            3. Listar todos los usuarios y el rol
                            4. Actualizar rol del usuario
                            5. Salir
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
                    try {
                        String idrol = JOptionPane.showInputDialog(null, "Escriba el id del rol: ");
                        int idroles = Integer.parseInt(idrol);
                        String iduser = JOptionPane.showInputDialog(null, "Escriba el id del usuario: ");
                        int idusers = Integer.parseInt(iduser);
                        UsuarioRol ur = new UsuarioRol(idroles, idusers);
                        createUR.execute(ur);
                        
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                        Start();
                    }
                    
                    Start();
    
                    break;
                case 2:
                    try {
                        String idrol = JOptionPane.showInputDialog(null, "Escriba el id del rol: ");
                        int idroles = Integer.parseInt(idrol);
                        String iduser = JOptionPane.showInputDialog(null, "Escriba el id del usuario: ");
                        int idusers = Integer.parseInt(iduser);
                        delUR.execute(idroles, idusers);
                        
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                        Start();
                    }
                    break;
                case 3:
                    StringBuilder mensaje = new StringBuilder("Lista de usuarios:\n");
                    List<UsuarioRol> usuarios = allUR.execute();
                    for (UsuarioRol usuario : usuarios) {
                        int idr = usuario.getId_rol();
                        int idu = usuario.getId_usuario();

                        mensaje.append("ID rol: ").append(idr).append(" ")
                        .append("ID usuario: ").append(idu).append("\n");
                    }

                    JOptionPane.showMessageDialog(null, mensaje);
                    Start();
                    break;
                case 4:
                    try {
                        String idbyuser = JOptionPane.showInputDialog(null, "Escriba el id del usuario para buscar: ");
                        int iduserupd = Integer.parseInt(idbyuser);
                        Optional<UsuarioRol> ur = idUR.execute(iduserupd);
                        UsuarioRol usr = ur.get();
                        String idrol = JOptionPane.showInputDialog(null, "Escriba el id del nuevo rol para el usuario ");
                        int idroles = Integer.parseInt(idrol);
                        usr.setId_rol(idroles);
                        updUR.execute(usr);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                        Start();
                    }
                    
                    break;
                case 5:
                    break;
                default:
                    break;
             
            }
        }
}
