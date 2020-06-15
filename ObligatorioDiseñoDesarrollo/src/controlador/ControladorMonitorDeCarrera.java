
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
    
    ControladorMonitorDeCarrera(IVistaMonitorDeCarrera unaVista, Hipodromo hipodromo, Administrador unAdmin){
        this.vista = unaVista;
        this.modelo = hipodromo;
        
    }
    public void cargarCarreras(Hipodromo hipodromo, Date fecha){
        ArrayList<Carrera>carreras = hipodromo.buscarJornada(fecha).getCarreras();
        vista.cargarCarreras(carreras);
    }
    
  
    
    
}
