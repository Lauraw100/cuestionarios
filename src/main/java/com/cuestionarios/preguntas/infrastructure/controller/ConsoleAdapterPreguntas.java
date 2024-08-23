package com.cuestionarios.preguntas.infrastructure.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import com.cuestionarios.funciones.Validaciones;
import com.cuestionarios.preguntas.application.CreatePreguntasUC;
import com.cuestionarios.preguntas.application.DeletePreguntasUC;
import com.cuestionarios.preguntas.application.FindAllPreguntasUC;
import com.cuestionarios.preguntas.application.FindByidPreguntasUC;
import com.cuestionarios.preguntas.application.UpdatePreguntasUC;
import com.cuestionarios.preguntas.domain.entity.Preguntas;
import com.cuestionarios.preguntas.domain.service.PreguntasService;
import com.cuestionarios.preguntas.infrastructure.repository.PreguntasRepository;

public class ConsoleAdapterPreguntas {

    private PreguntasService preguntaService;
    private CreatePreguntasUC createPr;
    private DeletePreguntasUC delpr;
    private FindAllPreguntasUC allPr;
    private FindByidPreguntasUC idpr;
    private UpdatePreguntasUC updPr;

    public ConsoleAdapterPreguntas() {
        this.preguntaService = new PreguntasRepository();
        this.createPr = new CreatePreguntasUC(preguntaService);
        this.delpr = new DeletePreguntasUC(preguntaService);
        this.allPr = new FindAllPreguntasUC(preguntaService);
        this.idpr = new FindByidPreguntasUC(preguntaService);
        this.updPr = new UpdatePreguntasUC(preguntaService);
    }

    public void Start(){
    String menu = """
                        1. Agregar Pregunta
                        2. Eliminar Pregunta
                        3. Listar todos las Preguntas
                        4. Buscar Pregunta por id
                        5. Actualizar Pregunta
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
                String idCapitulostr = JOptionPane.showInputDialog(null, "Escriba el id del Capitulo escogido: ");
                int idCapitulo = Integer.parseInt(idCapitulostr);
                String tipoPregunta = JOptionPane.showInputDialog(null, "Escriba tipo de Pregunta que se espera recibir: ");
                String comentarioPregunta = JOptionPane.showInputDialog(null, "Escriba el comentario a la Pregunta : ");
                String textoPregunta = JOptionPane.showInputDialog(null, "Escriba el texto de la Pregunta: ");

                
                Preguntas Pregunta = new Preguntas(idCapitulo, tipoPregunta, comentarioPregunta, textoPregunta);
                createPr.execute(Pregunta);
                Start();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                Start();
            }

                break;
            case 2:
                try {
                    String iddel = JOptionPane.showInputDialog(null, "Escriba el id de la pregunta para eliminar: ");
                    int iddelete = Integer.parseInt(iddel);
                    delpr.execute(iddelete);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                    Start();
                }
                
                break;
            case 3:

                StringBuilder mensaje = new StringBuilder("Lista de Preguntas:\n");
                List<Preguntas> Preguntas = allPr.execute();
                for (Preguntas Pregunta : Preguntas) {
                    int id = Pregunta.getId();
                    int idCapitulo = Pregunta.getIdCapitulo();
                    Timestamp creadoEn = Pregunta.getCreadoEn();
                    Timestamp actualizadoEn = Pregunta.getActualizadoEn();
                    String numeroPregunta = Pregunta.getNumeroPregunta();
                    String tipoRespuesta = Pregunta.getTipoRespuesta();
                    String comentarioPregunta = Pregunta.getComentarioPregunta();
                    String textoPregunta = Pregunta.getComentarioPregunta();

                    mensaje.append("ID: ").append(id).append("\n")
                    .append("id Capitulo: ").append(idCapitulo).append(", ")
                    .append("creado En: ").append(creadoEn).append("\n")
                    .append("actualizado En: ").append(actualizadoEn).append("\n")
                    .append("numero de Pregunta: ").append(numeroPregunta).append(", ")
                    .append("tipo de Respuesta: ").append(tipoRespuesta).append("\n")
                    .append("comentario Pregunta: ").append(comentarioPregunta).append("\n")
                    .append("texto Pregunta: ").append(textoPregunta).append("\n\n");
     
                }
                JTextArea textArea = new JTextArea(mensaje.toString());
                textArea.setEditable(false); 
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));

                JOptionPane.showMessageDialog(null, scrollPane, "Preguntas", JOptionPane.INFORMATION_MESSAGE);
                
                Start();
                break;
            case 4:
                try {
                    String iduser = JOptionPane.showInputDialog(null, "Escriba el id del Pregunta para buscar: ");
                    int iduserbu = Integer.parseInt(iduser);
                    Optional<Preguntas> dato = idpr.execute(iduserbu);
                    StringBuilder mensajeid = new StringBuilder("Preguntas:\n");
                    if (dato.isPresent()) {
                        Preguntas datopre = dato.get();
                        int id = datopre.getId();
                        int idCapitulo = datopre.getIdCapitulo();
                        Timestamp creadoEn = datopre.getCreadoEn();
                        Timestamp actualizadoEn = datopre.getActualizadoEn();
                        String numeroPregunta = datopre.getNumeroPregunta();
                        String tipoRespuesta = datopre.getTipoRespuesta();
                        String comentarioPregunta = datopre.getComentarioPregunta();
                        String textoPregunta = datopre.getComentarioPregunta();

                        mensajeid.append("ID: ").append(id).append("\n")
                        .append("id Capitulo: ").append(idCapitulo).append("\n")
                        .append("creado En: ").append(creadoEn).append("\n")
                        .append("actualizado En: ").append(actualizadoEn).append("\n")
                        .append("numero de Pregunta: ").append(numeroPregunta).append("\n")
                        .append("tipo de Respuesta: ").append(tipoRespuesta).append("\n")
                        .append("comentario Pregunta: ").append(comentarioPregunta).append("\n")
                        .append("texto Pregunta: ").append(textoPregunta).append("\n\n");
        
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
                String idbyuser = JOptionPane.showInputDialog(null, "Escriba el id del Pregunta para buscar: ");
                int iduserupd = Integer.parseInt(idbyuser);
                Optional<Preguntas> dato = idpr.execute(iduserupd);
                Preguntas PreguntaUpd = dato.get();
                while (bandera) {

                    String opcionesUpd = """
                        1. Id Capitulo
                        2. Numero Pregunta
                        3. Tipo Respuesta
                        4. Comentario Pregunta
                        5. TextoPregunta
                        6. Salir
                        """;

                    Optional<Integer> opc = Validaciones.mostrarOpciones(opcionesUpd,1,6);

                    if (opc.isPresent()) {
                        int numero = opc.get();
                        
                        switch (numero) {
                            case 1:
                                try {
                                    int Pregunta = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo id del capitulo"));
                                    PreguntaUpd.setIdCapitulo(Pregunta);
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null,  "problemas en el ingreso de datos,Vuelve a intentarlo");
                                    Start();
                                }
                                break;
                            case 2:
                                PreguntaUpd.setNumeroPregunta(JOptionPane.showInputDialog(null, "Ingrese el nuevo numero de Pregunta"));
                                break;
                            case 3:
                                PreguntaUpd.setTipoRespuesta(JOptionPane.showInputDialog(null, "Ingrese el nuevo tipo de Respuesta"));
                                break;
                            case 4:
                                PreguntaUpd.setComentarioPregunta(JOptionPane.showInputDialog(null, "Ingrese el nuevo comentario de la Pregunta"));
                                break;
                            case 5:
                                PreguntaUpd.setTextoPregunta(JOptionPane.showInputDialog(null, "Ingrese el nuevo texto"));
                                break;
                            case 6:
                                bandera = false;
                                break;
                            }
                        } else {
                            bandera = false;
                        }
                } 
                updPr.execute(PreguntaUpd);
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
