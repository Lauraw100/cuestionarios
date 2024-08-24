package com.cuestionarios.respuesta.infrastructure.controller;

import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import com.cuestionarios.funciones.Validaciones;
import com.cuestionarios.respuesta.application.CreateRespuestaUC;
import com.cuestionarios.respuesta.application.DeleteRespuestaUC;
import com.cuestionarios.respuesta.application.FindAllRespuestaUC;
import com.cuestionarios.respuesta.application.FindByidRespuestaUC;
import com.cuestionarios.respuesta.application.UpdateRespuestaUC;
import com.cuestionarios.respuesta.domain.entity.Respuesta;
import com.cuestionarios.respuesta.domain.service.RespuestaService;
import com.cuestionarios.respuesta.infrastructure.repository.RespuestaRepository;

public class ConsoleAdapterRespuesta {

    private RespuestaService respuestaService;
    private CreateRespuestaUC createrp;
    private DeleteRespuestaUC delrp;
    private FindAllRespuestaUC allrp;
    private FindByidRespuestaUC idrp;
    private UpdateRespuestaUC updrp;

    

    public ConsoleAdapterRespuesta() {
            this.respuestaService = new RespuestaRepository();
            this.createrp = new CreateRespuestaUC(respuestaService);
            this.delrp = new DeleteRespuestaUC(respuestaService);
            this.allrp = new FindAllRespuestaUC(respuestaService);
            this.idrp = new FindByidRespuestaUC(respuestaService);
            this.updrp = new UpdateRespuestaUC(respuestaService);
        }
            
    public void Start(){
    String menu = """
                        1. Agregar Respuesta
                        2. Eliminar Respuesta
                        3. Listar todos las Respuestas
                        4. Buscar Respuesta por id
                        5. Actualizar Respuesta
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
                String idRespuestastr = JOptionPane.showInputDialog(null, "Escriba el id de la opcion escogida : ");
                int idRespuesta = Integer.parseInt(idRespuestastr);
                String idSubrespuestastr = JOptionPane.showInputDialog(null, "Escriba el id de la sub opcion escogida: ");
                int idSubrespuesta = Integer.parseInt(idSubrespuestastr);
                String textoRespuesta = JOptionPane.showInputDialog(null, "Escriba tu respuesta: ");
                
                Respuesta respuesta = new Respuesta(idRespuesta, idSubrespuesta, textoRespuesta);
                createrp.execute(respuesta);
                Start();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                Start();
            }

                break;
            case 2:
                try {
                    String iddel = JOptionPane.showInputDialog(null, "Escriba el id del Respuesta para eliminar: ");
                    int iddelete = Integer.parseInt(iddel);
                    delrp.execute(iddelete);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                    Start();
                }
                
                break;
            case 3:

                StringBuilder mensaje = new StringBuilder("Lista de Respuestas:\n");
                List<Respuesta> Respuestas = allrp.execute();
                for (Respuesta Respuesta : Respuestas) {
                    int id = Respuesta.getId();
                    int idRespuesta = Respuesta.getIdRespuesta();
                    int idSubrespuesta = Respuesta.getIdSubrespuesta();
                    String textoRespuesta =  Respuesta.getTextoRespuesta();

                    mensaje.append("ID: ").append(id).append("\n")
                    .append("idRespuesta: ").append(idRespuesta).append(", ")
                    .append("idSubrespuesta: ").append(idSubrespuesta).append(", ")
                    .append("textoRespuesta: ").append(textoRespuesta).append("\n\n");
     
                }
                JTextArea textArea = new JTextArea(mensaje.toString());
                textArea.setEditable(false); 
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));

                JOptionPane.showMessageDialog(null, scrollPane, "Respuestas", JOptionPane.INFORMATION_MESSAGE);
                
                Start();
                break;
            case 4:
                try {
                    String iduser = JOptionPane.showInputDialog(null, "Escriba el id del Respuesta para buscar: ");
                    int iduserbu = Integer.parseInt(iduser);
                    Optional<Respuesta> dato = idrp.execute(iduserbu);
                    StringBuilder mensajeid = new StringBuilder("Respuestas:\n");
                    if (dato.isPresent()) {
                        Respuesta datopre = dato.get();
                        int id = datopre.getId();
                        int idRespuesta = datopre.getIdRespuesta();
                        int idSubrespuesta = datopre.getIdSubrespuesta();
                        String textoRespuesta =  datopre.getTextoRespuesta();

                        mensajeid.append("ID: ").append(id).append("\n")
                        .append("idRespuesta: ").append(idRespuesta).append(", ")
                        .append("idSubrespuesta: ").append(idSubrespuesta).append(", ")
                        .append("textoRespuesta: ").append(textoRespuesta).append("\n\n");
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
                String idbyuser = JOptionPane.showInputDialog(null, "Escriba el id del Respuesta para buscar: ");
                int iduserupd = Integer.parseInt(idbyuser);
                Optional<Respuesta> dato = idrp.execute(iduserupd);
                Respuesta RespuestaUpd = dato.get();
                while (bandera) {
                    
                    String opcionesUpd = """
                        1. IdRespuesta
                        2. IdSubrespuesta
                        3. TextoRespuesta
                        4. Salir
                        """;

                    Optional<Integer> opc = Validaciones.mostrarOpciones(opcionesUpd,1,4);

                    if (opc.isPresent()) {
                        int numero = opc.get();
                        
                        switch (numero) {
                            case 1:
                                try {
                                    int respuesta = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo id Respuesta"));
                                    RespuestaUpd.setIdRespuesta(respuesta);
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                                    Start();
                                }
                                break;
                            case 2:
                                try {
                                    int respuesta = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo id Sub respuesta"));
                                    RespuestaUpd.setIdSubrespuesta(respuesta);
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                                    Start();
                                }
                                break;
                            case 3:
                                RespuestaUpd.setTextoRespuesta(JOptionPane.showInputDialog(null, "Ingrese el nuevo texto"));
                                break;
                            case 4:
                                bandera = false;
                                break;
                            }
                        } else {
                            bandera = false;
                        }
                } 
                updrp.execute(RespuestaUpd);
                Start();
                
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
