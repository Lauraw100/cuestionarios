package com.cuestionarios.Capitulos.infrastructure.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import com.cuestionarios.Capitulos.application.CreateCapituloUC;
import com.cuestionarios.Capitulos.application.DeleteCapituloUC;
import com.cuestionarios.Capitulos.application.FindAllCapituloUC;
import com.cuestionarios.Capitulos.application.FindByidCapituloUC;
import com.cuestionarios.Capitulos.application.UpdateCapituloUC;
import com.cuestionarios.Capitulos.domain.entity.Capitulo;
import com.cuestionarios.Capitulos.domain.service.CapituloService;
import com.cuestionarios.Capitulos.infrastructure.repository.CapituloRepository;
import com.cuestionarios.funciones.Validaciones;

public class ConsoleAdapterCapitulo {

    private CapituloService capituloService;
    private CreateCapituloUC createCap;
    private DeleteCapituloUC delCap;
    private FindAllCapituloUC allCap;
    private FindByidCapituloUC idCap;
    private UpdateCapituloUC updCap;
    
    public ConsoleAdapterCapitulo() {
        this.capituloService = new CapituloRepository();
        this.createCap = new CreateCapituloUC(capituloService);
        this.delCap = new DeleteCapituloUC(capituloService);
        this.allCap = new FindAllCapituloUC(capituloService);
        this.idCap = new FindByidCapituloUC(capituloService);
        this.updCap = new UpdateCapituloUC(capituloService);
    }

    public void Start(){
    String menu = """
                        1. Agregar Capitulo
                        2. Eliminar Capitulo
                        3. Listar todos las Capitulos
                        4. Buscar Capitulo por id
                        5. Actualizar Capitulo
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
                int idEncuesta = Integer.parseInt(JOptionPane.showInputDialog(null, "Escriba el id de la encuesta relacionada:"));   
                String tituloCapitulo = JOptionPane.showInputDialog(null, "Escriba el nombre del Capitulo: ");

                Capitulo capitulo = new Capitulo(idEncuesta, tituloCapitulo);
                createCap.execute(capitulo);
                Start();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,  "Problemas en el ingreso de datos,Vuelve a intentarlo");
                Start();
            }

                break;
            case 2:
                try {
                    String iddel = JOptionPane.showInputDialog(null, "Escriba el id del Capitulo para eliminar: ");
                    int iddelete = Integer.parseInt(iddel);
                    delCap.execute(iddelete);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "Problemas en el ingreso de datos,Vuelve a intentarlo");
                    Start();
                }
                
                break;
            case 3:

                StringBuilder mensaje = new StringBuilder("Lista de Capitulos:\n");
                List<Capitulo> Capitulos = allCap.execute();
                for (Capitulo capitulo : Capitulos) {

                    int id = capitulo.getId();
                    int idEncuesta = capitulo.getIdEncuesta();
                    Timestamp creadoEn = capitulo.getCreadoEn();
                    Timestamp actualizadoEn = capitulo.getActualizadoEn();
                    String numerocap =  capitulo.getNumeroCapitulo();
                    String titulo =  capitulo.getTituloCapitulo();


                    mensaje.append("ID: ").append(id).append("\n")
                    .append("Id Encuesta: ").append(idEncuesta).append("\n")
                    .append("Creado en: ").append(creadoEn).append("\n")
                    .append("Actualizado en: ").append(actualizadoEn).append("\n")
                    .append("Numero capitulo: ").append(numerocap).append("\n")
                    .append("Titulo capitulo: ").append(titulo).append("\n\n");
     
                }
                JTextArea textArea = new JTextArea(mensaje.toString());
                textArea.setEditable(false); 
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));

                JOptionPane.showMessageDialog(null, scrollPane, "Capitulos", JOptionPane.INFORMATION_MESSAGE);
                
                Start();
                break;
            case 4:
                try {
                    String iduser = JOptionPane.showInputDialog(null, "Escriba el id del Capitulo para buscar: ");
                    int iduserbu = Integer.parseInt(iduser);
                    Optional<Capitulo> dato = idCap.execute(iduserbu);
                    StringBuilder mensajeid = new StringBuilder("Capitulos:\n");
                    if (dato.isPresent()) {
                        Capitulo datopre = dato.get();
                        int id = datopre.getId();
                        int idEncuesta = datopre.getIdEncuesta();
                        Timestamp creadoEn = datopre.getCreadoEn();
                        Timestamp actualizadoEn = datopre.getActualizadoEn();
                        String numerocap =  datopre.getNumeroCapitulo();
                        String titulo =  datopre.getTituloCapitulo();


                        mensajeid.append("ID: ").append(id).append("\n")
                        .append("Id Encuesta: ").append(idEncuesta).append("\n")
                        .append("Creado en: ").append(creadoEn).append("\n")
                        .append("Actualizado en: ").append(actualizadoEn).append("\n")
                        .append("Numero capitulo: ").append(numerocap).append("\n")
                        .append("Titulo capitulo: ").append(titulo).append("\n\n");
        
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
                String idbyuser = JOptionPane.showInputDialog(null, "Escriba el id del Capitulo para buscar: ");
                int iduserupd = Integer.parseInt(idbyuser);
                Optional<Capitulo> dato = idCap.execute(iduserupd);
                Capitulo CapituloUpd = dato.get();
                while (bandera) {
                    String opcionesUpd = """
                        1. Id encuesta
                        2. Titulo Capitulo
                        3. Salir
                        """;

                    Optional<Integer> opc = Validaciones.mostrarOpciones(opcionesUpd,1,4);

                    if (opc.isPresent()) {
                        int numero = opc.get();
                        
                        switch (numero) {
                            case 1:
                                try {
                                    CapituloUpd.setIdEncuesta(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el nuevo id de la encuesta")));
                                    
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null,  "Problemas en el ingreso de datos,Vuelve a intentarlo");
                                    Start();
                                } 
                                break;
                            case 2:
                                CapituloUpd.setTituloCapitulo(JOptionPane.showInputDialog(null," Ingrese el titulo del Capitulo: "));
                                break;
                            case 3:
                                bandera = false;
                                break;
                            }
                        }
                } 
                updCap.execute(CapituloUpd);
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
