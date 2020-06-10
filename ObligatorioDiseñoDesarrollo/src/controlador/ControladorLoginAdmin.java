package controlador;

import modelo.Administrador;
import modelo.Fachada;

public class ControladorLoginAdmin {

    Fachada unModeloFachada;
    IVistaLoginAdmin vista;

    public ControladorLoginAdmin(IVistaLoginAdmin vista) {
        this.unModeloFachada = Fachada.getInstancia();
        this.vista = vista;

    }

    public void login(String nombre, String pass) {

        Administrador adm = unModeloFachada.loginAdministrador(nombre, pass);

        if (adm == null) {
            vista.mostrarError("Login incorrecto");
        } else {
            vista.mostrarProximaVista(adm);
            vista.cerrar();
            vista.mostrarBienvenida(adm);
        }

    }

}
