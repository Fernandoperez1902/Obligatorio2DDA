
package controlador;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import modelo.Administrador;
import modelo.Carrera;
import modelo.Hipodromo;


public class ControladorMonitorDeCarrera {
    
    private IVistaMonitorDeCarrera vista;
    private Hipodromo modelo;
    private Carrera carreraSeleccionada;
    
    public ControladorMonitorDeCarrera(IVistaMonitorDeCarrera unaVista, Hipodromo hipodromo, Administrador unAdmin){
        this.vista = unaVista;
        this.modelo = hipodromo;
        
    }
    public void cargarCarreras(Hipodromo hipodromo, Date fecha){
        ArrayList<Carrera>carreras = hipodromo.buscarJornada(fecha).getCarreras();
        vista.cargarCarreras(carreras);
    }

    public void seleccionarCarrera(int index) {
        carreraSeleccionada = modelo.buscarJornada(new Date()).getCarreras().get(index);
        vista.mostrarDetalle(carreraSeleccionada);
        vista.mostrarParticipantes(carreraSeleccionada.getParticipantes());
        if (!carreraSeleccionada.isFinalizada()) {
            vista.mostrarDetalleApuestasGanadoras(carreraSeleccionada.getApuestas());
        }
    }
    
  
    
    
}
