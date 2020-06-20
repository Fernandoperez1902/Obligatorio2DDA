
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
        this.vista = vista; 
        cargarCarrera();    
    }
    
    public void cargarCarrera(){       
        carreraAbierta = seleccionado.buscarCarreraAbierta();
        if (carreraAbierta != null){
            vista.mostrarCarrera(carreraAbierta);
        } else {
            vista.mostrarError("No hay carreras para cerrar");
            vista.cerrar();
        }
    }
    
    public void cerrarApuesta(){
        carreraAbierta.cerrar();
        Jornada jornada = seleccionado.buscarJornada(carreraAbierta.getFecha());
        jornada.actualizarUltimaCerrada();
        vista.cerrar();
    }
    
}
