package com.cuestionarios.categorias.infrastructure.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.cuestionarios.categorias.application.CreateCategoriasUC;
import com.cuestionarios.categorias.application.DeleteCategoriasUC;
import com.cuestionarios.categorias.application.FindAllCategoriasUC;
import com.cuestionarios.categorias.application.FindByidCategoriasUC;
import com.cuestionarios.categorias.application.UpdateCategoriasUC;
import com.cuestionarios.categorias.domain.entity.Categorias;
import com.cuestionarios.categorias.domain.service.CategoriasService;
import com.cuestionarios.categorias.infrastructure.repository.CategoriasRepository;
import com.cuestionarios.funciones.Validaciones;

public class ConsoleAdapterCategorias {

    private CategoriasService categoriasService;
    private CreateCategoriasUC createCat;
    private DeleteCategoriasUC delCat;
    private FindAllCategoriasUC allCat;
    private FindByidCategoriasUC idCat;
    private UpdateCategoriasUC updCat;

    
    public ConsoleAdapterCategorias() {
        this.categoriasService = new CategoriasRepository();
        this.createCat = new CreateCategoriasUC(categoriasService);
        this.delCat = new DeleteCategoriasUC(categoriasService);
        this.allCat = new FindAllCategoriasUC(categoriasService);
        this.idCat = new FindByidCategoriasUC(categoriasService);
        this.updCat = new UpdateCategoriasUC(categoriasService);
    }

    public void Start(){
    String menu = """
                        1. Agregar Categorias Catalogo
                        2. Eliminar Categorias Catalogo
                        3. Listar todos las Categorias Catalogos
                        4. Buscar Categorias Catalogo por id
                        5. Actualizar Categorias Catalogo
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
                String nombre = JOptionPane.showInputDialog(null, "Escriba el nombre de la Categoria: ");

                Categorias CategoriasCatalogo = new Categorias(nombre);
                createCat.execute(CategoriasCatalogo);
                Start();


                break;
            case 2:
                try {
                    String iddel = JOptionPane.showInputDialog(null, "Escriba el id de la Categoria para eliminar: ");
                    int iddelete = Integer.parseInt(iddel);
                    delCat.execute(iddelete);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "Problemas en el ingreso de datos,Vuelve a intentarlo");
                    Start();
                }
                
                break;
            case 3:

                StringBuilder mensaje = new StringBuilder("Lista de CategoriasCatalogos:\n");
                List<Categorias> CategoriasCatalogos = allCat.execute();
                for (Categorias categoriasCatalogo : CategoriasCatalogos) {

                    int id = categoriasCatalogo.getId();
                    Timestamp creadoEn = categoriasCatalogo.getCreadoEn();
                    Timestamp actualizadoEn = categoriasCatalogo.getActualizadoEn();
                    String nombreall =  categoriasCatalogo.getNombre();


                    mensaje.append("ID: ").append(id).append("\n")
                    .append("Creado en: ").append(creadoEn).append("\n")
                    .append("Actualizado en: ").append(actualizadoEn).append("\n")
                    .append("Nombre: ").append(nombreall).append("\n\n");
     
                }
                JTextArea textArea = new JTextArea(mensaje.toString());
                textArea.setEditable(false); 
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));

                JOptionPane.showMessageDialog(null, scrollPane, "CategoriasCatalogos", JOptionPane.INFORMATION_MESSAGE);
                
                Start();
                break;
            case 4:
                try {
                    String iduser = JOptionPane.showInputDialog(null, "Escriba el id de la Categoria para buscar: ");
                    int iduserbu = Integer.parseInt(iduser);
                    Optional<Categorias> dato = idCat.execute(iduserbu);
                    StringBuilder mensajeid = new StringBuilder("CategoriasCatalogos:\n");
                    if (dato.isPresent()) {
                        Categorias datopre = dato.get();
                        int id = datopre.getId();
                        Timestamp creadoEn = datopre.getCreadoEn();
                        Timestamp actualizadoEn = datopre.getActualizadoEn();
                        String nombreid =  datopre.getNombre();
    
                        mensajeid.append("ID: ").append(id).append("\n")
                        .append("Creado en: ").append(creadoEn).append("\n")
                        .append("Actualizado en: ").append(actualizadoEn).append("\n")
                        .append("Nombre: ").append(nombreid).append("\n\n");
         
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
                String idbyuser = JOptionPane.showInputDialog(null, "Escriba el id de la Categoria para buscar: ");
                int iduserupd = Integer.parseInt(idbyuser);
                Optional<Categorias> dato = idCat.execute(iduserupd);
                Categorias CategoriasCatalogoUpd= dato.get();
                CategoriasCatalogoUpd.setNombre(JOptionPane.showInputDialog(null," Ingrese el nuevo nombre: "));
                updCat.execute(CategoriasCatalogoUpd);     
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
