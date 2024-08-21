package com.cuestionarios.funciones;

import java.util.Optional;
import javax.swing.JOptionPane;

public class Validaciones {

    public static Optional<Integer> mostrarOpciones(String opciones,int min, int max) {
        

        while (true) {
     
            
            // Mostrar el menú con 6 opciones
            String seleccion = JOptionPane.showInputDialog(null, opciones, "Menú Principal", JOptionPane.QUESTION_MESSAGE);
            
            // Si el usuario presiona "Cancelar" o cierra la ventana
            if (seleccion == null) {
                int opcionSalir = JOptionPane.showConfirmDialog(null, "¿Deseas salir del programa?", "Salir", JOptionPane.YES_NO_OPTION);
                if (opcionSalir == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...Adios");
                    break;
                } else {
                    continue;
                }
            }
        
        // Verificar si la entrada es un número válido
        try {
            int opcion = Integer.parseInt(seleccion);
            if (opcion >= min && opcion <= max) {
                return Optional.of(opcion);
                
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un número que este entre el rango");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número válido");
        }
        
    }
    return Optional.empty();
    }

    public static int elegiropcion(String seleccion) {
        
        int opcion = 0;
        while (true) {
            // Si el usuario presiona "Cancelar" o cierra la ventana
            if (seleccion == null) {
                int opcionSalir = JOptionPane.showConfirmDialog(null, "¿Deseas salir del programa?", "Salir", JOptionPane.YES_NO_OPTION);
                if (opcionSalir == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Saliendo del programa");
                    break;
                } else {
                    continue;
                }
            }
        
        // Verificar si la entrada es un número válido
        try {
            opcion = Integer.parseInt(seleccion);
            return opcion;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número válido");
        }  
    }
    return opcion;
    }

}
