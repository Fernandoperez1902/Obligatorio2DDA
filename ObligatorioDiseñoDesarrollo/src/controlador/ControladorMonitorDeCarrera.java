
package controlador;

import java.util.ArrayList;
import java.util.Date;
import modelo.Apuesta;
import modelo.Carrera;
import modelo.Hipodromo;
import modelo.Jornada;
import utilidades.ManejoDeFechas;


public class ControladorMonitorDeCarrera {
    
    private IVistaMonitorDeCarrera vista;
    private Hipodromo modelo;
    private Carrera carreraSeleccionada;
    
    public ControladorMonitorDeCarrera(IVistaMonitorDeCarrera unaVista, Hipodromo hipodromo){
        this.vista = unaVista;
        this.modelo = hipodromo;
        vista.cargarCarreras(modelo.buscarJornada(ManejoDeFechas.tomarFechaSistemaSinHora()).getCarreras());
    }
    
    public void cargarCarreras(Date fecha){
        ArrayList<Carrera>carreras = null;
        if (fecha == null){
            fecha = ManejoDeFechas.tomarFechaSistemaSinHora();
        }
        Jornada jornada = modelo.buscarJornada(fecha);
        if(jornada !=null){
            carreras = jornada.getCarreras();
        }
        vista.cargarCarreras(carreras);
    }

    public void seleccionarCarrera(int index) {
        carreraSeleccionada = modelo.buscarJornada(ManejoDeFechas.tomarFechaSistemaSinHora()).getCarreras().get(index);
        vista.mostrarDetalle(carreraSeleccionada);
        vista.mostrarParticipantes(carreraSeleccionada.getParticipantes());
        ArrayList<Apuesta>apuestas = null;
        if (carreraSeleccionada.isFinalizada()) {
            apuestas = carreraSeleccionada.getApuestasGanadoras();
        }
        vista.mostrarDetalleApuestasGanadoras(apuestas);
    }   
}
