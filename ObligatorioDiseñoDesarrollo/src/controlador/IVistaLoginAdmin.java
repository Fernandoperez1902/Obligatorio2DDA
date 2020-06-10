
package controlador;

import modelo.Administrador;

public interface IVistaLoginAdmin {
    
    public void mostrarError(String login_incorrecto);
    
    public void mostrarProximaVista(Administrador admin);
    
    public void mostrarBienvenida(Administrador admin);

    public void cerrar();

}
