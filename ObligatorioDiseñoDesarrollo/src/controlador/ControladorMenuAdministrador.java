
package controlador;

import logica.Administrador;

public class ControladorMenuAdministrador {
  
    private Administrador modelo;
    private IVistaMenuAdministrador vista;
    
    public ControladorMenuAdministrador(Administrador modelo, IVistaMenuAdministrador vista){
        this.modelo = modelo;
        this.vista = vista;
    }
    
}
