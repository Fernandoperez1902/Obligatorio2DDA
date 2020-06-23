package controlador;

import modelo.ApuestasException;
import modelo.Fachada;
import modelo.Jugador;

public class ControladorConsultarSaldo {

    private Fachada modelo;
    private IVistaConsultarSaldo vista;

    public ControladorConsultarSaldo(IVistaConsultarSaldo vista) {
        this.vista = vista;
        modelo = Fachada.getInstancia();
    }

    public void consultarSaldo(String usuario, String password) throws ApuestasException {
        try {
            Jugador j = modelo.loginJugador(usuario, password);
            vista.mostrarVistaSaldo(j);
        } catch (ApuestasException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }
}
