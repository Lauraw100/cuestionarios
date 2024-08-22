package com.cuestionarios.subopcionesRespuesta.infrastructure.controller;

import java.util.List;
import java.util.Optional;
import java.sql.Timestamp;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.cuestionarios.funciones.Validaciones;
import com.cuestionarios.subopcionesRespuesta.application.CreateSubOpcionesRespuestaUC;
import com.cuestionarios.subopcionesRespuesta.application.DeleteSubOpcionesRespuestaUC;
import com.cuestionarios.subopcionesRespuesta.application.FindAllSubOpcionesRespuestaUC;
import com.cuestionarios.subopcionesRespuesta.application.FindByidSubOpcionesRespuestaUC;
import com.cuestionarios.subopcionesRespuesta.application.UpdateSubOpcionesRespuestaUC;
import com.cuestionarios.subopcionesRespuesta.domain.entity.SubOpcionesRespuesta;
import com.cuestionarios.subopcionesRespuesta.domain.service.SubOpcionesRespuestaService;
import com.cuestionarios.subopcionesRespuesta.infrastructure.repository.SubOpcionesRespuestaRepository;

public class ConsoleAdapterSubOpcionesRespuesta {

    private SubOpcionesRespuestaService subOpcionesRespuestaService;
    private CreateSubOpcionesRespuestaUC createSO;
    private DeleteSubOpcionesRespuestaUC delSO;
    private FindAllSubOpcionesRespuestaUC allSO;
    private FindByidSubOpcionesRespuestaUC idSO;
    private UpdateSubOpcionesRespuestaUC updSO;


    public ConsoleAdapterSubOpcionesRespuesta() {
        this.subOpcionesRespuestaService = new SubOpcionesRespuestaRepository();
        this.createSO = new CreateSubOpcionesRespuestaUC(subOpcionesRespuestaService);
        this.delSO = new DeleteSubOpcionesRespuestaUC(subOpcionesRespuestaService);
        this.allSO = new FindAllSubOpcionesRespuestaUC(subOpcionesRespuestaService);
        this.idSO = new FindByidSubOpcionesRespuestaUC(subOpcionesRespuestaService);
        this.updSO = new UpdateSubOpcionesRespuestaUC(subOpcionesRespuestaService);
    }

    public void Start(){
    String menu = """
                        1. Agregar Sub Opciones
                        2. Eliminar Sub Opciones
                        3. Listar todos las Sub Opciones
                        4. Buscar Sub Opciones por id
                        5. Actualizar Sub Opciones
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
                try {
                    String numeroSubopcionstr = JOptionPane.showInputDialog(null, "Escriba el numero de Subopcion: ");
                    int numeroSubopcion = Integer.parseInt(numeroSubopcionstr);
                    String idOpcionRespuestastr = JOptionPane.showInputDialog(null, "Escriba el id de la Opcion de Respuesta al que tiene relacion la sub opcion: ");
                    int idOpcionRespuesta = Integer.parseInt(idOpcionRespuestastr);
                    String componenteHtml = JOptionPane.showInputDialog(null, "Escriba el componente Html: ");
                    String textoSubopcion = JOptionPane.showInputDialog(null, "Escriba el texto de la Sub opcion: ");

                    SubOpcionesRespuesta sor = new SubOpcionesRespuesta(numeroSubopcion, idOpcionRespuesta, componenteHtml, textoSubopcion);
                    createSO.execute(sor);
                    Start();
                        
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                    Start();
                }

                break;
            case 2:
                try {
                    String iddel = JOptionPane.showInputDialog(null, "Escriba el id de la Subopcion para eliminar: ");
                    int iddelete = Integer.parseInt(iddel);
                    delSO.execute(iddelete);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                    Start();
                }
                
                break;
            case 3:
                StringBuilder mensaje = new StringBuilder("Lista de subopciones:\n");
                List<SubOpcionesRespuesta> sor = allSO.execute();
                for (SubOpcionesRespuesta sortext : sor) {
                    int id = sortext.getId();
                    int numeroSubopcion = sortext.getNumeroSubopcion();
                    Timestamp creadoEn = sortext.getCreadoEn();
                    Timestamp actualizadoEn = sortext.getActualizadoEn();
                    int idOpcionRespuesta = sortext.getIdOpcionRespuesta();
                    String componenteHtml = sortext.getComponenteHtml();
                    String textoSubopcion = sortext.getTextoSubopcion();
                    

                    mensaje.append("ID: ").append(id).append("\n")
                    .append("numero Sub opcion: ").append(numeroSubopcion).append(", ")
                    .append("creado En: ").append(creadoEn).append(", ")
                    .append("actualizado En: ").append(actualizadoEn).append(", ")
                    .append("id Opcion Respuesta: ").append(idOpcionRespuesta).append(", ")
                    .append("componente Html: ").append(componenteHtml).append(", ")
                    .append("texto Sub opcion: ").append(textoSubopcion).append("\n\n");
     
                }

                JTextArea textArea = new JTextArea(mensaje.toString());
                textArea.setEditable(false); 
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300)); 

        
                JOptionPane.showMessageDialog(null, scrollPane, "Sub opciones", JOptionPane.INFORMATION_MESSAGE);
                
                Start();
                break;
            case 4:
                try {
                    String iduser = JOptionPane.showInputDialog(null, "Escriba el id de la Subopcion para buscar: ");
                    int iduserbu = Integer.parseInt(iduser);
                    Optional<SubOpcionesRespuesta> dato = idSO.execute(iduserbu);
                    StringBuilder mensajeid = new StringBuilder("usuarios:\n");

                    if (dato.isPresent()) {
                        SubOpcionesRespuesta sub = dato.get();
                        int id = sub.getId();
                        int numeroSubopcion = sub.getNumeroSubopcion();
                        Timestamp creadoEn = sub.getCreadoEn();
                        Timestamp actualizadoEn = sub.getActualizadoEn();
                        int idOpcionRespuesta = sub.getIdOpcionRespuesta();
                        String componenteHtml = sub.getComponenteHtml();
                        String textoSubopcion = sub.getTextoSubopcion();
                        

                        mensajeid.append("ID: ").append(id).append("\n")
                        .append("numero Sub opcion: ").append(numeroSubopcion).append("\n")
                        .append("creado En: ").append(creadoEn).append("\n")
                        .append("actualizado En: ").append(actualizadoEn).append("\n")
                        .append("id Opcion Respuesta: ").append(idOpcionRespuesta).append("\n")
                        .append("componente Html: ").append(componenteHtml).append("\n")
                        .append("texto Sub opcion: ").append(textoSubopcion).append("\n\n");
        
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
                boolean bandera = true;
                String idsub = JOptionPane.showInputDialog(null, "Escriba el id de la SubOpcion para buscar: ");
                int idByupd = Integer.parseInt(idsub);
                Optional<SubOpcionesRespuesta> dato = idSO.execute(idByupd);
                SubOpcionesRespuesta datoupd = dato.get();
                while (bandera) {
                    String opcionesUpd = """
                        1. Numero Sub opcion
                        2. Id Opcion de Respuesta
                        3. ComponenteHtml
                        4. Texto Sub opcion
                        5. Salir
                        """;

                    Optional<Integer> opc = Validaciones.mostrarOpciones(opcionesUpd,1,5);

                    if (opc.isPresent()) {
                        int numero = opc.get();
                        
                        switch (numero) {
                            case 1:
                                try {
                                    int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo numero de Sub opcion"));
                                    datoupd.setNumeroSubopcion(num);
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                                    Start();
                                }
                               
                                break;
                            case 2:
                                try {
                                    int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo id de la Opcion de Respuesta al que tiene relacion la sub opcion"));
                                    datoupd.setIdOpcionRespuesta(num);
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                                    Start();
                                }
                                break;
                            case 3:
                                datoupd.setComponenteHtml(JOptionPane.showInputDialog(null, "Ingrese el nuevo id de la Opcion de Respuesta al que tiene relacion la sub opcion"));
                                
                                break;
                            case 4:
                                datoupd.setTextoSubopcion(JOptionPane.showInputDialog(null, "Ingrese el nuevo id de la Opcion de Respuesta al que tiene relacion la sub opcion"));    
                                break;
                            case 5:
                                bandera = false;
                                break;
                            }
                        }
                } 
                updSO.execute(datoupd);
                
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
