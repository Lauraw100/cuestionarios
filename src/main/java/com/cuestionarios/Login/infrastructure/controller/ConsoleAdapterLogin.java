package com.cuestionarios.Login.infrastructure.controller;

import java.util.Optional;

import javax.swing.JOptionPane;

import com.cuestionarios.Login.application.IngresarUsuarioUC;
import com.cuestionarios.Login.application.ObtenerRollUC;
import com.cuestionarios.Login.application.ValidarLoginUC;
import com.cuestionarios.Login.domain.entity.Login;
import com.cuestionarios.Login.domain.service.LoginService;
import com.cuestionarios.Login.infrastructure.repository.LoginRepository;

public class ConsoleAdapterLogin {

    private LoginService loginService;
    private IngresarUsuarioUC ingresar;
    private ValidarLoginUC validar;
    private ObtenerRollUC obtenerRol;

    public ConsoleAdapterLogin() {
        this.loginService = new LoginRepository();
        this.ingresar = new IngresarUsuarioUC(loginService);
        this.validar = new ValidarLoginUC(loginService);
        this.obtenerRol = new ObtenerRollUC(loginService);
    }

    public void Start(){
        String user = JOptionPane.showInputDialog(null, "Ingrese el usuario:");
        String password = JOptionPane.showInputDialog(null, "Ingrese la contraseña:");
        Optional<Integer> iduser = validar.execute(user, password);
        if (iduser.isPresent()) {
            int idusuario = iduser.get();
            Optional<Integer> idrol = obtenerRol.execute(idusuario);
            if (idrol.isPresent()) {
                int rol = idrol.get();
                if (rol == 1 ) {
                    //see the crud - funtion
                    
                } else {
                    // survey funtion
                }
            }

        } else {
            int response = JOptionPane.showConfirmDialog(null, "¿Desea agregar este nuevo usuario?", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
            if (response == JOptionPane.OK_OPTION) {
                Login login = new Login(password, user);
                ingresar.execute(login);
            } else if (response == JOptionPane.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "Cerrando ---");
            }
            
        }
    }
}
