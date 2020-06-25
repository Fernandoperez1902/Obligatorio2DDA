
package controlador;

import modelo.Jugador;

public class ControladorMostrarSaldo {
    
    private IVistaMostrarSaldo vista;
    private Jugador jugador;

    public ControladorMostrarSaldo(IVistaMostrarSaldo vista, Jugador jugador) {
        this.vista = vista;
        this.jugador = jugador;
        this.vista.mostrarDatos(jugador);
    }
}
