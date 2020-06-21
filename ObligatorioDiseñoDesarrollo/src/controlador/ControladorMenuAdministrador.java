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
        vista.llamarAbrirCarrera(seleccionado);
    }

    public void cerrarApuestas(){
        vista.llamarCerrarApuestas(seleccionado);
    }
    
    public void finalizarCarrera(){
        vista.llamarFinalizarCarrera(seleccionado);
    }
    
    public void monitorDeCarrera(){
        vista.llamarMonitorearCarrera(seleccionado);
    }
    
    public void cambiarModalidad() {
        vista.llamarCambiarModadlidad(seleccionado);
    }
    
    
    
}
