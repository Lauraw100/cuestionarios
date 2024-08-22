package com.cuestionarios.rol.infrastructure.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.cuestionarios.funciones.Validaciones;
import com.cuestionarios.rol.application.CreateRolUC;
import com.cuestionarios.rol.application.DeleteRolUC;
import com.cuestionarios.rol.application.FindAllRolUC;
import com.cuestionarios.rol.application.FindByidRolUC;
import com.cuestionarios.rol.application.UpdateRolUC;
import com.cuestionarios.rol.domain.entity.Roles;
import com.cuestionarios.rol.domain.service.RolesService;
import com.cuestionarios.rol.infrastructure.repository.RolesRepository;

public class ConsoleAdapterRoles {

    private RolesService rolesService;
    private CreateRolUC createRol;
    private DeleteRolUC delRol;
    private FindAllRolUC allRol;
    private FindByidRolUC idRol;
    private UpdateRolUC upRol;

    public ConsoleAdapterRoles() {
        this.rolesService = new RolesRepository();
        this.createRol = new CreateRolUC(rolesService);
        this.delRol = new DeleteRolUC(rolesService);
        this.allRol = new FindAllRolUC(rolesService);
        this.idRol = new FindByidRolUC(rolesService);
        this.upRol = new UpdateRolUC(rolesService);
    }
    public void Start(){
    String menu = """
                        1. Agregar rol
                        2. Eliminar rol
                        3. Listar todos los roles
                        4. Buscar rol por id
                        5. Actualizar rol
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

                String nombre = JOptionPane.showInputDialog(null, "Escriba el nombre del rol: ");
                Roles rol = new Roles(nombre);
                createRol.execute(rol);
                Start();

                break;
            case 2:
                try {
                    String iddel = JOptionPane.showInputDialog(null, "Escriba el id del rol para eliminar: ");
                    int iddelete = Integer.parseInt(iddel);
                    delRol.execute(iddelete);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                    Start();
                }
                
                break;
            case 3:
                StringBuilder mensaje = new StringBuilder("Lista de usuarios:\n");
                List<Roles> Roles = allRol.execute();
                for (Roles roles : Roles) {
                    int id = roles.getId();
                    String name = roles.getNombre();;

                    mensaje.append("\n").append("ID: ").append(id).append("    ")
                    .append("Nombre: ").append(name).append("\n");
                }
                JTextArea textArea = new JTextArea(mensaje.toString());
                textArea.setEditable(false); 
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300)); 

                JOptionPane.showMessageDialog(null, scrollPane, "Roles", JOptionPane.INFORMATION_MESSAGE);
                
                Start();
                break;
            case 4:
                try {
                    String iduser = JOptionPane.showInputDialog(null, "Escriba el id del Rol para buscar: ");
                    int iduserbu = Integer.parseInt(iduser);
                    Optional<Roles> dato = idRol.execute(iduserbu);
                    StringBuilder mensajeid = new StringBuilder("Roles:\n");

                    if (dato.isPresent()) {
                        Roles datopre = dato.get();
                        int id = datopre.getId();
                        String name = datopre.getNombre();
                        
                        mensajeid.append("ID: ").append(id).append("\n")
                            .append("Nombre: ").append(name).append("\n");     
                    } 
                    JOptionPane.showMessageDialog(null, mensajeid);
                    Start();
    
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                    Start();
                }
               
                break;
            case 5:
                try {
                    String idbyuser = JOptionPane.showInputDialog(null, "Escriba el id del Rol para actualizar: ");
                    int iduserupd = Integer.parseInt(idbyuser);
                    Optional<Roles> dato = idRol.execute(iduserupd);
                    Roles Rolesupd = dato.get();
                    Rolesupd.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nuevo Nombre"));
                    upRol.execute(Rolesupd);
                    Start();
                    break;
                            
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
