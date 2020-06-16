
package controlador;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import modelo.Administrador;
import modelo.Apuesta;
import modelo.Carrera;
import modelo.Hipodromo;
import modelo.Jornada;


public class ControladorMonitorDeCarrera {
    
    private IVistaMonitorDeCarrera vista;
    private Hipodromo modelo;
    private Carrera carreraSeleccionada;
    
    public ControladorMonitorDeCarrera(IVistaMonitorDeCarrera unaVista, Hipodromo hipodromo){
        this.vista = unaVista;
        this.modelo = hipodromo;
        
    }
    
    public void cargarCarreras(Date fecha){
        ArrayList<Carrera>carreras = null;
        if (fecha == null){
            fecha = new Date();
        }
        Jornada jornada = modelo.buscarJornada(fecha);
        if(jornada !=null){
            carreras = jornada.getCarreras();
        }
        vista.cargarCarreras(carreras);
    }

    public void seleccionarCarrera(int index) {
        carreraSeleccionada = modelo.buscarJornada(new Date()).getCarreras().get(index);
        vista.mostrarDetalle(carreraSeleccionada);
        vista.mostrarParticipantes(carreraSeleccionada.getParticipantes());
        ArrayList<Apuesta>apuestas = null;
        if (carreraSeleccionada.isFinalizada()) {
            apuestas = carreraSeleccionada.getApuestas();
        }
        vista.mostrarDetalleApuestasGanadoras(apuestas);
    }
    
  
    
    
}
