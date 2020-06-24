package controlador;

import java.util.ArrayList;
import java.util.Date;
import modelo.Apuesta;
import modelo.Carrera;
import modelo.Hipodromo;
import modelo.Jornada;
import observer.Observable;
import observer.Observador;
import utilidades.ManejoDeFechas;

public class ControladorMonitorDeCarrera implements Observador {

    private IVistaMonitorDeCarrera vista;
    private Hipodromo modelo;
    private Carrera carreraSeleccionada;

    public ControladorMonitorDeCarrera(IVistaMonitorDeCarrera unaVista, Hipodromo hipodromo) {
        this.vista = unaVista;
        this.modelo = hipodromo;
        vista.cargarCarreras(modelo.buscarJornada(ManejoDeFechas.tomarFechaSistemaSinHora()).getCarreras());
        modelo.buscarCarreraActual().agregar(this);
    }

    public void cargarCarreras(Date fecha) {
        ArrayList<Carrera> carreras = null;
        if (fecha == null) {
            fecha = ManejoDeFechas.tomarFechaSistemaSinHora();
        }
        Jornada jornada = modelo.buscarJornada(fecha);
        if (jornada != null) {
            carreras = jornada.getCarreras();
        }
        vista.cargarCarreras(carreras);
    }

    public void seleccionarCarrera(int index) {
        carreraSeleccionada = modelo.buscarJornada(ManejoDeFechas.tomarFechaSistemaSinHora()).getCarreras().get(index);
        vista.mostrarDetalle(carreraSeleccionada);
        vista.mostrarParticipantes(carreraSeleccionada.getParticipantes());
        ArrayList<Apuesta> apuestas = apuestasGanadoras();
        vista.mostrarDetalleApuestasGanadoras(apuestas);
    }

    
    public ArrayList<Apuesta> apuestasGanadoras() {
        ArrayList<Apuesta> ret = null;
        if (carreraSeleccionada.isFinalizada()) {
            ret = carreraSeleccionada.getApuestasGanadoras();
        }
        return ret;
    }

    
    @Override
    public void actualizar(Observable origen, Object evento) {
        if (evento.equals(Carrera.Eventos.abrir) || evento.equals(Carrera.Eventos.cerrar) || evento.equals(Carrera.Eventos.finalizar)) {
            //vista.cargarCarreras(carreras);
            vista.mostrarDetalle(carreraSeleccionada);
            vista.mostrarParticipantes(carreraSeleccionada.getParticipantes());
            vista.mostrarDetalleApuestasGanadoras(apuestasGanadoras());
        }
    }

}
