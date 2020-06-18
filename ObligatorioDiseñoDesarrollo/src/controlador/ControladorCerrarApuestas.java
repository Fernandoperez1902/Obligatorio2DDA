
package controlador;

import modelo.Carrera;
import modelo.Hipodromo;
import modelo.Jornada;

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
    
    public void cerrarApuesta(){
        carreraAbierta.cerrar();
        Jornada jornada = seleccionado.buscarJornada(carreraAbierta.getFecha());
        jornada.actualizarUltimaCerrada();
        vista.cerrar();
    }
    
}
