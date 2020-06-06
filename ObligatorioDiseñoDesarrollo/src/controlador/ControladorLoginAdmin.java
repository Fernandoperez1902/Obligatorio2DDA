package controlador;

import interfaz.BienvenidaAdministrador;
import interfaz.MenuAdministrador;
import javax.swing.JOptionPane;
import logica.Administrador;
import logica.ApuestasException;
import logica.Fachada;

public class ControladorLoginAdmin {

    Fachada unModeloFachada = Fachada.getInstancia();
    IVistaLoginAdmin vista;

    public ControladorLoginAdmin(IVistaLoginAdmin vista) {
        this.vista = vista;

    }

    public Administrador login(String nombre, String pass) {
        
        return unModeloFachada.loginAdministrador(nombre, pass);
        
    }

}
