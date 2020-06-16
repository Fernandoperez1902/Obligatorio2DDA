
package controlador;

import modelo.Carrera;
import modelo.Hipodromo;

public class ControladorCerrarApuestas {
    
    private Hipodromo seleccionado;
    private Carrera carreraAbierta;
    private IVistaCerrarApuestas vista;
    
    public ControladorCerrarApuestas(Hipodromo seleccionado, IVistaCerrarApuestas vista){
        
        this.seleccionado = seleccionado;
        this.carreraAbierta = seleccionado.buscarCarreraAbierta();
        this.vista = vista; 
        this.vista.mostrarCarrera(carreraAbierta);
        
        
    }
   
}
