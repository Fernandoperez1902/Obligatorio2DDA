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
    private ArrayList<Carrera> carreras;

    public ControladorMonitorDeCarrera(IVistaMonitorDeCarrera unaVista, Hipodromo hipodromo) {
        this.vista = unaVista;
        this.modelo = hipodromo;
        carreras = modelo.buscarJornada(ManejoDeFechas.tomarFechaSistemaSinHora()).getCarreras();
        vista.cargarCarreras(carreras);
        modelo.buscarCarreraActual().agregar(this);
    }

    public void cargarCarreras(Date fecha) {
        ArrayList<Carrera> lista = null;
        if (fecha == null) {
            fecha = ManejoDeFechas.tomarFechaSistemaSinHora();
        }
        Jornada jornada = modelo.buscarJornada(fecha);
        if (jornada != null) {
            carreras = jornada.getCarreras();
            lista = carreras;
        }
        vista.cargarCarreras(lista);  
        vista.limpiarListas();
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

    public void limpiarListas(){
        vista.limpiarListas();
    }
    
    @Override
    public void actualizar(Observable origen, Object evento) {
        if (evento.equals(Carrera.Eventos.abrir) || evento.equals(Carrera.Eventos.cerrar) || evento.equals(Carrera.Eventos.finalizar)) {
            vista.cargarCarreras(carreras);
            vista.mostrarDetalle(carreraSeleccionada);
            vista.mostrarParticipantes(carreraSeleccionada.getParticipantes());
            vista.mostrarDetalleApuestasGanadoras(apuestasGanadoras());
        }
    }

}
