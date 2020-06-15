package controlador;

import java.util.ArrayList;
import java.util.Date;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;
import modelo.Jornada;
import modelo.Participante;
import observer.Observable;
import observer.Observador;

public class ControladorRealizarApuestas implements Observador {

    private Fachada modelo;
    private IVistaRealizarApuestas vista;
    private ArrayList<Hipodromo> hipodromos;
    private Hipodromo hipodromoSeleccionado = null;
    private Carrera carreraSeleccionada = null;
    private Participante participanteSeleccionado = null;

    public ControladorRealizarApuestas(IVistaRealizarApuestas vista) {
        this.modelo = Fachada.getInstancia();
        this.vista = vista;
        //modelo.agregar(this);
        cargarHipodromos();
        this.vista.habilitarBotonApuesta(false);
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        cargarHipodromos();
        cargarCarreras(hipodromoSeleccionado);
        cargarParticipantes(carreraSeleccionada);
    }

    public void cargarHipodromos() {
        hipodromoSeleccionado = null;
        hipodromos = modelo.getHipodromos();
        vista.cargarHipodromos(hipodromos);
    }

    public void cargarCarreras(Hipodromo h) {
        this.hipodromoSeleccionado = h;
        Jornada deHoy = h.buscarJornada(new Date());
        if (deHoy != null) {

            vista.cargarCarreras(deHoy.getCarreras());
        }
    }

    public void cargarParticipantes(Carrera c) {
        vista.cargarParticipantes(c.getParticipantes());
    }

    public void agregarApuesta(String nombre, String pass, String monto) {
        modelo.agregarApuesta(nombre, pass, monto, participanteSeleccionado, carreraSeleccionada);
    }

    public void seleccionarHipodromo(int index) {
        hipodromoSeleccionado = hipodromos.get(index);
        cargarCarreras(hipodromoSeleccionado);
    }

    public void seleccionarCarrera(int index) {
        carreraSeleccionada = hipodromoSeleccionado.buscarJornada(new Date()).getCarreras().get(index);
        if (!carreraSeleccionada.isAbierta()) {
            vista.habilitarBotonApuesta(false);
        }
        cargarParticipantes(carreraSeleccionada);
    }

    public void seleccionarCaballo(int index) {
        participanteSeleccionado = carreraSeleccionada.getParticipantes().get(index);
        if (participanteSeleccionado != null && carreraSeleccionada.isAbierta()) {
            vista.habilitarBotonApuesta(true);
        }
    }

}
