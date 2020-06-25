package controlador;

import java.util.ArrayList;
import modelo.Carrera;
import modelo.Hipodromo;
import modelo.Participante;
import observer.Observable;
import observer.Observador;

public class ControladorCambiarModalidadApuesta implements Observador {

    private Hipodromo hipodromoSeleccionado;
    private IVistaCambiarModalidadApuesta vista;
    private Participante participanteSeleccionado;
    private ArrayList<Participante> participantesSinApuesta;
    private Carrera abierta;

    public ControladorCambiarModalidadApuesta(Hipodromo hipodromoSeleccionado,
            IVistaCambiarModalidadApuesta vista) {
        this.hipodromoSeleccionado = hipodromoSeleccionado;
        this.vista = vista;
        cargarCarrera();
    }

    public void cargarCarrera() {
        abierta = hipodromoSeleccionado.buscarCarreraAbierta();
        if (abierta != null) {
            vista.mostrarCarrera(abierta);
            abierta.agregar(this);
            participantesSinApuesta = abierta.participantesSinApuestas();
            vista.mostrarParticipantesSinApuestas(participantesSinApuesta);
        } else {

        }
    }

    public void seleccionarParticipante(int index) {
        participanteSeleccionado = participantesSinApuesta.get(index);
    }

    public void modificarParticipante() {
        vista.mostrarProximaVista(participanteSeleccionado);
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (evento.equals(Participante.Eventos.cambiaModalidadApuesta)) {
            vista.mostrarParticipantesSinApuestas(participantesSinApuesta);
        }
    }
}
