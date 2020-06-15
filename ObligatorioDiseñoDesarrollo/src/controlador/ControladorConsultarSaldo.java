
package controlador;

import modelo.Fachada;
import modelo.Jugador;
import vista.IUJugador;

public class ControladorConsultarSaldo {

    private Fachada modelo;
    private IVistaConsultarSaldo vista;

    public ControladorConsultarSaldo(IUJugador vista) {
        this.vista = vista;
        modelo = Fachada.getInstancia();
    }
    
    public void consultarSaldo(String usuario, String password){
        Jugador j = modelo.loginJugador(usuario, password);
        vista.mostrarVistaSaldo(j);
    }
    
    
}
