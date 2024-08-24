package com.cuestionarios.generarCuestionarios.infrastructure.controller;

import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;

import com.cuestionarios.generarCuestionarios.application.GuardarRespuestaOpAbiertaUC;
import com.cuestionarios.generarCuestionarios.application.GuardarRespuestaOpUC;
import com.cuestionarios.generarCuestionarios.application.GuardarRespuestaSubOpUC;
import com.cuestionarios.generarCuestionarios.application.MostrarCapitulosUC;
import com.cuestionarios.generarCuestionarios.application.MostrarCuestionariosUC;
import com.cuestionarios.generarCuestionarios.application.MostrarOpcionesUC;
import com.cuestionarios.generarCuestionarios.application.MostrarOpcionidPadreUC;
import com.cuestionarios.generarCuestionarios.application.MostrarPreguntaByidUC;
import com.cuestionarios.generarCuestionarios.application.MostrarPreguntasUC;
import com.cuestionarios.generarCuestionarios.application.MostrarSubOpcionesUC;
import com.cuestionarios.generarCuestionarios.application.ObtenerOpcionByidUC;
import com.cuestionarios.generarCuestionarios.application.ObtenerOpcionByidvalorUC;
import com.cuestionarios.generarCuestionarios.application.ObtenerOpcionidUC;
import com.cuestionarios.generarCuestionarios.application.ObtenerPreguntaHUC;
import com.cuestionarios.generarCuestionarios.application.ObtenerSubOpByidUC;
import com.cuestionarios.generarCuestionarios.application.PreguntarAbiertaUC;
import com.cuestionarios.generarCuestionarios.application.RetornarSubOpidUC;
import com.cuestionarios.generarCuestionarios.application.RetornarSubOpidvalorUC;
import com.cuestionarios.generarCuestionarios.domain.entity.GenerarCuestionarios;
import com.cuestionarios.generarCuestionarios.domain.service.GenerarCuestionariosService;
import com.cuestionarios.generarCuestionarios.infrastructure.repository.GenerarCuestionariosRepository;


    // ingresa cuestionario
/***
 * *ingresa capitulo 
 * *seleciona pregunta 
 * *if retorna id de la pregunta 
 * * con la funcion mostrar pregunta pasa el id y muestra la pregunta para contestarla 
 * *la siguiente automaticamente mostrar pregunta de seleccion pregunta
 ** sus opciones 
 * *y si no responde pregunta a normal
 * *mostra pregunta 
 * *sus opciones y subopciones
 ***/

public class ConsoleAdapterGenerarCuestionarios {
    private GenerarCuestionariosService generarCuestionariosService;
    private MostrarCuestionariosUC mostrar; 
    private MostrarCapitulosUC Capmostrar;
    private MostrarPreguntasUC Pregmostrar;
    private MostrarOpcionesUC Opcmostrar;
    private MostrarSubOpcionesUC Submostrar;
    private MostrarOpcionidPadreUC idpadremostrar;
    private MostrarPreguntaByidUC PregIDmostrar;
    private ObtenerOpcionidUC IdOpcionGet;
    private ObtenerPreguntaHUC PreguntaHijaGet;
    private ObtenerOpcionByidUC idcase;
    private RetornarSubOpidvalorUC opcionIdCase;
    private ObtenerSubOpByidUC subopcionByid;
    private ObtenerOpcionByidvalorUC idOpcionValor;
    private RetornarSubOpidUC retornarSubOpcion;
    private RetornarSubOpidvalorUC retornarSubValor;
    private PreguntarAbiertaUC preguntaAbierta;
    private GuardarRespuestaOpUC guardarOpcion;
    private GuardarRespuestaOpAbiertaUC guardarOpcionAbierta;
    private GuardarRespuestaSubOpUC guardarSubOpcion;

    

    public ConsoleAdapterGenerarCuestionarios() {
        this.generarCuestionariosService = new GenerarCuestionariosRepository();
        this.mostrar = new MostrarCuestionariosUC(generarCuestionariosService);
        this.Capmostrar = new MostrarCapitulosUC(generarCuestionariosService);
        this.Pregmostrar = new MostrarPreguntasUC(generarCuestionariosService);
        this.Opcmostrar = new MostrarOpcionesUC(generarCuestionariosService);
        
        this.Submostrar = new MostrarSubOpcionesUC(generarCuestionariosService);
        this.idpadremostrar = new MostrarOpcionidPadreUC(generarCuestionariosService);
        this.PregIDmostrar = new MostrarPreguntaByidUC(generarCuestionariosService);
        this.IdOpcionGet = new ObtenerOpcionidUC(generarCuestionariosService);
        this.PreguntaHijaGet = new ObtenerPreguntaHUC(generarCuestionariosService);
        this.idcase = new ObtenerOpcionByidUC(generarCuestionariosService);
        this.opcionIdCase = new RetornarSubOpidvalorUC(generarCuestionariosService);
        this.subopcionByid = new RetornarSubOpidvalorUC(generarCuestionariosService);
        this.idOpcionValor = new ObtenerOpcionByidvalorUC(generarCuestionariosService);
        this.retornarSubOpcion = new RetornarSubOpidUC(generarCuestionariosService);
        this.retornarSubValor = new RetornarSubOpidvalorUC(generarCuestionariosService);
        this.preguntaAbierta = new PreguntarAbiertaUC(generarCuestionariosService);
        this.guardarOpcion = new GuardarRespuestaOpUC(generarCuestionariosService);
        this.guardarOpcionAbierta = new GuardarRespuestaOpAbiertaUC(generarCuestionariosService);
        this.guardarSubOpcion = new GuardarRespuestaSubOpUC(generarCuestionariosService);
    }

    public int validarnumeros(int numeromax, String opcionelegida) {
        if (opcionelegida == null || opcionelegida.isEmpty()) {
            return 0;
        }
    
        try {
            int opcion = Integer.parseInt(opcionelegida);
            if (opcion <= 0 || opcion > numeromax) {
                JOptionPane.showMessageDialog(null, "Opción fuera de rango. Por favor, selecciona una opción válida.");
                Start(); 
                return -1;
            }
            if (opcion == numeromax) {
                return 0; 
            }
            return opcion; 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Entrada no válida. Por favor, introduce un número.");
            Start(); 
            return -1;
        }
    }
    // me retorna -1 o 0 si se presenta comflicto con la entrada y sale de ejecucion

    public int imprimircuestionarios(){
        StringBuilder st = new StringBuilder();
        List<GenerarCuestionarios> cuetionarios = mostrar.execute();
        for (GenerarCuestionarios cuestionario : cuetionarios) {
            st.append(cuestionario.getIndice()).append(" - ").append(cuestionario.getNombre()).append("\n");
        }
        st.append(cuetionarios.size()+1).append(" - ").append("salir");
        String data = JOptionPane.showInputDialog(null,st);
        int numero = validarnumeros(cuetionarios.size()+1, data);
        
        return numero; 
    }
    // me retorna el id del cuestionario

    public int imprimircapitulos(int numencuesta){
        StringBuilder st = new StringBuilder();
        List<GenerarCuestionarios> capitulos = Capmostrar.execute(numencuesta);
        for (GenerarCuestionarios cap : capitulos) {
            st.append(cap.getIndice()).append(" - ").append(cap.getNombre()).append("\n");   
        }
        st.append(capitulos.size()+1).append(" - ").append("salir");
        String data = JOptionPane.showInputDialog(null,st);
        int numero = validarnumeros(capitulos.size()+1, data);
        return numero;

    }
    // me retorna el numero de capitulo

    public int imprimirpreguntas(int numcapitulo, int idencuesta){
        StringBuilder st = new StringBuilder();
        Optional<List<GenerarCuestionarios>> capitulos = Pregmostrar.execute(numcapitulo,idencuesta);
        if (capitulos.isPresent()) {
            List<GenerarCuestionarios> capit = capitulos.get();
            for (GenerarCuestionarios cap : capit) {
                st.append(cap.getIndice()).append(" - ").append(cap.getNombre()).append("\n");   
            }
            st.append(capit.size()+1).append(" - ").append("salir");
            String data = JOptionPane.showInputDialog(null,st);
            int numero = validarnumeros(capit.size()+1, data);
            return numero;
            
        }
        return 0;
    }
    //me retorna el numero de la pregunta

            //num valorOpcion
    public Optional<Integer>  imprimiropciones(int numpregunta,int numCap, int idEncuesta){
        StringBuilder st = new StringBuilder();
        Optional<List<GenerarCuestionarios>> opciones = Opcmostrar.execute(numpregunta, numCap, idEncuesta);
        if (opciones.isPresent()) {
            List<GenerarCuestionarios> opcion = opciones.get();
            for (GenerarCuestionarios opc : opcion) {
                st.append(opc.getIndice()).append(" - ").append(opc.getNombre()).append("\n"); 
                if (opc.getNombre() == null) {

                    return Optional.of(1);
                }
                
            }
            st.append(opcion.size()+1).append(" - ").append("salir");
            String data = JOptionPane.showInputDialog(null,st);
            int numero = validarnumeros(opcion.size()+1, data);
            return Optional.of(numero);
            
        }
        return Optional.empty();
    }
    //retorna valor de la opcion

    public void imprimirpreguntaid(int id){
        StringBuilder st = new StringBuilder();
        Optional<List<GenerarCuestionarios>> capitulos = PregIDmostrar.execute(id);
        if (capitulos.isPresent()) {
            List<GenerarCuestionarios> capit = capitulos.get();
            for (GenerarCuestionarios cap : capit) {
                st.append(cap.getIndice()).append(" - ").append(cap.getNombre()).append("\n");   
            }
            JOptionPane.showMessageDialog(null,st);
            
        }
    }
    public Optional<Integer> mostraropcionesbyid(int idpregunta){
        StringBuilder st = new StringBuilder();
        Optional<List<GenerarCuestionarios>> opciones = idcase.execute(idpregunta);
        if (opciones.isPresent()) {
            List<GenerarCuestionarios> opcion = opciones.get();
            for (GenerarCuestionarios opc : opcion) {
                String nombre = opc.getNombre();
                if (nombre == null) {
                    nombre = "pregunta opcion abierta";
                }
                st.append(opc.getIndice()).append(" - ").append(nombre).append("\n"); 
            }
            st.append(opcion.size()+1).append(" - ").append("salir");
            String data = JOptionPane.showInputDialog(null,st);
            int numero = validarnumeros(opcion.size()+1, data);
            return Optional.of(numero);
            
        }
        return Optional.empty();
    }
    //valor opcion

    public Optional<Integer> mostrasubopcionesByid(int idopcion){
        StringBuilder st = new StringBuilder();
         Optional<List<GenerarCuestionarios>> opciones = subopcionByid.execute(idopcion);
        if (opciones.isPresent()) {
            List<GenerarCuestionarios> opcion = opciones.get();
            for (GenerarCuestionarios opc : opcion) {
                st.append(opc.getIndice()).append(" - ").append(opc.getNombre()).append("\n"); 
            }
            st.append(opcion.size()+1).append(" - ").append("salir");
            String data = JOptionPane.showInputDialog(null,st);
            int numero = validarnumeros(opcion.size()+1, data);
            return Optional.of(numero);
            
        }
        return Optional.empty();
    }
    public Optional<Integer> mostrarSubOpciones(int idEncuesta,int numCapitulo, int numPreg, int valorOpc){
        StringBuilder st = new StringBuilder();
         Optional<List<GenerarCuestionarios>> opciones = Submostrar.execute(idEncuesta, numCapitulo, numPreg, valorOpc);
        if (opciones.isPresent()) {
            List<GenerarCuestionarios> opcion = opciones.get();
            for (GenerarCuestionarios opc : opcion) {
                st.append(opc.getIndice()).append(" - ").append(opc.getNombre()).append("\n"); 
            }
            st.append(opcion.size()+1).append(" - ").append("salir");
            String data = JOptionPane.showInputDialog(null,st);
            int numero = validarnumeros(opcion.size()+1, data);
            return Optional.of(numero);
            
        }
        return Optional.empty();
    }

    public void ImprimirPreguntasHijas(int id_encuesta,int numero_capitulo, int numero_pregunta, int valor_opcion){
        Optional<List<GenerarCuestionarios>> idopciones = IdOpcionGet.execute(id_encuesta, numero_capitulo, numero_pregunta, valor_opcion);
        if (idopciones.isPresent()) {//obtener el id de la opcion
            List<GenerarCuestionarios> findOpciones = idopciones.get();
            for (GenerarCuestionarios idopc : findOpciones) {
                int ids = idopc.getId(); 
             //error aqui
                Optional<List<GenerarCuestionarios>> preguntas = PreguntaHijaGet.execute(ids);
                if (preguntas.isPresent()) { //retorna las preguntas
                    List<GenerarCuestionarios>  hacerPreguntas = preguntas.get();
                    for (GenerarCuestionarios preg : hacerPreguntas) {
                        int idpregunta = preg.getId();
                        imprimirpreguntaid(idpregunta);
                        //numero pregunta 
                        Optional<Integer> opcionNum = mostraropcionesbyid(idpregunta);
                        // numero de opcion elegida
                        if (opcionNum.isPresent()) {
                            int valor = opcionNum.get();
                            Optional<Integer>  opcion = idOpcionValor.execute(idpregunta, valor);
                            if (opcion.isPresent()) {
                                int idopcion = opcion.get(); // id opcion
                                Optional<Integer> subopcion = mostrasubopcionesByid(idopcion);
                                if (subopcion.isPresent()) {
                                    int idSub = subopcion.get();
                                    int idSubopcion = retornarSubValor.execute(idopcion, idSub);
                                    guardarSubOpcion.execute(idSubopcion);
                                    //logica para guardar subopcion "esto retorna el numero"
                                    /*** o no?
                                     * *veremos
                                     * 
                                     *
                                     * */

                                    
                                } else {
                                    //idopcion logica guardar
                                    Optional<String> Stringvalidar = preguntaAbierta.execute(idopcion);
                                    if (!Stringvalidar.isPresent()) {
                                        // guardar opcion de tipo id 
                                        String respuestaABIERTA = JOptionPane.showInputDialog(null,"escriba su respuesta");
                                        guardarOpcionAbierta.execute(idopcion, respuestaABIERTA);

                                    }
                                    //LE PASO ID "OPCION " SI OPCION ES NULL O VACIA RETORNA TRUE Y HABRE UN INPUT
                                    guardarOpcion.execute(idopcion);

                                }
                            
                            }
                            
                        }
                        // int idopcion = opcionIdCase.
                        
                    }
                    
                }
            }
            
        } else{
            // logicaa de buscar subopciones 
            // logica de guardar opcion 
            //creo que no nesecita logica
            return;
        }

    }


    public void Start(){
        int idencuesta = imprimircuestionarios();
        if (idencuesta == 0) {
            System.out.println("Saliendo del programa...");
            return; // Salida del método Start
        }else{
            int numerocap = imprimircapitulos(idencuesta);
            if (numerocap == 0 ) {
                return; 
            } if (numerocap == -1) {
                Start();
            } 
            int numeroPreg = imprimirpreguntas(numerocap, idencuesta);
            System.out.println(numeroPreg);
            if (numeroPreg == 0 ) {
                return; 
            } if (numeroPreg == -1) {
                Start();
            } else {

            }
            Optional<Integer> numeroopc = imprimiropciones(numerocap, numeroPreg, idencuesta);
            if (numeroopc.isPresent()) {
                int valoropcion = numeroopc.get(); //me da el numero de opcion
                //si valor opcion es 
                Optional<Integer> valorSubOpcion = mostrarSubOpciones(idencuesta, numerocap, numeroPreg, valoropcion);//me RETORNA EL VALOR DE LA SubOPCION
                
                if (valorSubOpcion.isPresent()) {
                    int SubOpcion = valorSubOpcion.get();   
                    int idSub = retornarSubOpcion.execute(idencuesta, numerocap, numeroPreg, valoropcion, SubOpcion);//EL ID DE LA SUBOPCION
                    guardarSubOpcion.execute(idSub);

                    //guardar subopcion


                } else {
                    Optional<List<GenerarCuestionarios>> idOpc = IdOpcionGet.execute(idencuesta, numerocap, numeroPreg, valoropcion); //retorna el id de la opcion
                    if (idOpc.isPresent()) {
                        List<GenerarCuestionarios> listaids = idOpc.get();
                        for (GenerarCuestionarios opc : listaids) {
                            int opcion = opc.getId();

                            Optional<String> Stringvalidar = preguntaAbierta.execute(opcion);
                            if (!Stringvalidar.isPresent()) {
                                // guardar opcion de tipo id 
                                String respuestaABIERTA = JOptionPane.showInputDialog(null,"escriba su respuesta");
                                guardarOpcionAbierta.execute(opcion, respuestaABIERTA);

                            }
                            guardarOpcion.execute(opcion);
                            //logicca de guardar 
                            //LE PASO ID "OPCION " SI OPCION ES NULL O VACIA RETORNA TRUE Y HABRE UN INPUT
                        }
                        
                    }
                    //guardar opcion
                    
                }
                ImprimirPreguntasHijas(idencuesta, numerocap, numeroPreg,valoropcion);
                
            }
         }
    }

}
