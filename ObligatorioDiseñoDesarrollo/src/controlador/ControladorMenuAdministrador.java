package controlador;

import java.util.ArrayList;
import modelo.Administrador;
import modelo.Fachada;
import modelo.Hipodromo;

public class ControladorMenuAdministrador {

    private Administrador modeloAdministrador;
    private Fachada modeloFachada;
    private IVistaMenuAdministrador vista;
    private ArrayList<Hipodromo> hipodromos;
    private Hipodromo seleccionado;

    public ControladorMenuAdministrador(Administrador modeloAdministrador, IVistaMenuAdministrador vista) {
        this.modeloAdministrador = modeloAdministrador;
        this.modeloFachada = Fachada.getInstancia();
        this.hipodromos = modeloFachada.getHipodromos();
        this.vista = vista;
        this.vista.mostrarHipodromos(hipodromos);
        vista.habilitarBotones(false);
    }

    public void seleccionarHipodromo(int index) {
        seleccionado = hipodromos.get(index);
        vista.habilitarBotones(true);
    }

    public void crearCarrera() {
        vista.llamarCrearCarrera(seleccionado);
    }

    public void abrirCarrera() {
        if (!seleccionado.getJornadas().isEmpty() && seleccionado.buscarProximaCarreraDelDia() !=null) {
            vista.llamarAbrirCarrera(seleccionado);
        } else {
            vista.mostrarError("No existen carreras para abrir");
        }
    }

    public void cerrarApuestas() {
        if (!seleccionado.getJornadas().isEmpty()&& seleccionado.buscarCarreraActual().isAbierta()) {
            vista.llamarCerrarApuestas(seleccionado);
        } else {
            vista.mostrarError("No existen carreras para cerrar");
        }
    }

    public void finalizarCarrera() {
        if (!seleccionado.getJornadas().isEmpty()&& seleccionado.buscarCarreraActual().isCerrada()) {
            vista.llamarFinalizarCarrera(seleccionado);
        } else {
            vista.mostrarError("No existen carreras para finalizar");
        }
    }

    public void monitorDeCarrera() {
        if (!seleccionado.getJornadas().isEmpty()) {
            vista.llamarMonitorearCarrera(seleccionado);
        } else {
            vista.mostrarError("No existen carreras para monitorear");
        }
    }

    public void cambiarModalidad() {
        if (!seleccionado.getJornadas().isEmpty()  && seleccionado.buscarCarreraActual().isAbierta()) {
            vista.llamarCambiarModadlidad(seleccionado);
        } else {
            vista.mostrarError("No existen carreras abiertas disponibles para cambio de modalidad");
        }

    }

}
