
package controlador;

import modelo.Jugador;

public interface IVistaConsultarSaldo {

    public void consultarSaldo(String usuario, String password);

    public void mostrarVistaSaldo(Jugador jugador);

    public void mostrarError(String message);
    
    public void limpiarFormulario();
}
