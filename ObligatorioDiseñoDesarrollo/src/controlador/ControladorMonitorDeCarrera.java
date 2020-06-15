
package controlador;

import modelo.Administrador;
import modelo.Hipodromo;


public class ControladorMonitorDeCarrera {
    
    private IVistaMonitorDeCarrera vista;
    private Hipodromo modelo;
    
    ControladorMonitorDeCarrera(IVistaMonitorDeCarrera unaVista, Administrador unAdmin){
        this.vista = unaVista;
        
    }
    
}
