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

    }

    public void seleccionarHipodromo(int index) {
        seleccionado = hipodromos.get(index);
    }

    public void crearCarrera() {
        vista.llamarCrearCarrera(seleccionado);
    }

    public void abrirCarrera() {
        vista.llamarAbrirCarrera(seleccionado);
    }
    
    public void monitorDeCarrera(){
        vista.llamarMonitorearCarrera(seleccionado);
    }
}
