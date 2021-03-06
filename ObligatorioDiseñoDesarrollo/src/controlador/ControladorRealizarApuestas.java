package controlador;

import java.util.ArrayList;
import java.util.Date;
import modelo.Apuesta;
import modelo.ApuestasException;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;
import modelo.Jornada;
import modelo.Jugador;
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
        modelo.agregar(this);
        cargarHipodromos();
        this.vista.habilitarBotonApuesta(false);
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        cargarCarreraActual(hipodromoSeleccionado);
        cargarParticipantes(carreraSeleccionada);
        vista.actualizarLista();
    }

    public void cargarHipodromos() {
        hipodromoSeleccionado = null;
        hipodromos = modelo.getHipodromos();
        vista.cargarHipodromos(hipodromos);
    }

    public void cargarCarreraActual(Hipodromo h) {
        this.hipodromoSeleccionado = h;
        Jornada deHoy = h.buscarJornada(new Date());
        if (deHoy != null) {
            carreraSeleccionada = deHoy.carreraActual();
            if (!carreraSeleccionada.isAbierta()) {
                vista.habilitarBotonApuesta(false);
            }
        } else {
            carreraSeleccionada = null;
            participanteSeleccionado = null;
        }
        vista.cargarCarrera(carreraSeleccionada);
        cargarParticipantes(carreraSeleccionada);
    }

    public void cargarParticipantes(Carrera c) {
        if(c!=null){
            vista.cargarParticipantes(c.getParticipantes());
        }else{
            vista.cargarParticipantes(new ArrayList<Participante>());
        }
    }

    public void agregarApuesta(String nombre, String pass, String monto) {
        try {
            Jugador j = modelo.loginJugador(nombre, pass);
            if (j != null) {
                float montoFloat = convertirMonto(monto);
                Apuesta apuesta = new Apuesta(j, participanteSeleccionado, montoFloat, carreraSeleccionada);
                if (j.saldoSuficiente(apuesta.getMontoPagado())) {
                    modelo.agregarApuesta(apuesta);
                    j.setUltimaApuesta(apuesta);
                    participanteSeleccionado.agregarApuesta(apuesta);
                }
            }
        } catch (ApuestasException ex) {
            vista.mostrarError(ex.getMessage());
        }
        vista.mostrarMensajeExito();
        limpiarFormulario();
    }

    public void seleccionarHipodromo(int index) {
        hipodromoSeleccionado = hipodromos.get(index);
        cargarCarreraActual(hipodromoSeleccionado);
    }

    public void seleccionarCaballo(int index) {
        participanteSeleccionado = carreraSeleccionada.getParticipantes().get(index);
        if (participanteSeleccionado != null && carreraSeleccionada.isAbierta()) {
            vista.habilitarBotonApuesta(true);
        }
    }

    private float convertirMonto(String monto) throws ApuestasException {
        float montoF;
        if (!monto.isEmpty()) {
            try {
                montoF = Float.parseFloat(monto);
            } catch (NumberFormatException ae) {
                throw new ApuestasException("Monto inválido");
            }
        } else {
            throw new ApuestasException("Debe ingresar un monto");
        }
        return montoF;
    }

    private void limpiarFormulario() {
        hipodromoSeleccionado = null;
        carreraSeleccionada = null;
        participanteSeleccionado = null;
        vista.habilitarBotonApuesta(false);
        vista.limpiarFormulario();
    }
}
