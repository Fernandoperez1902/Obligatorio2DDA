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
        try {
            Jugador j = modelo.loginJugador(nombre, pass);
            if (j != null) {
                float montoFloat = convertirMonto(monto);
                if(j.saldoSuficiente(montoFloat)){
                Apuesta apuesta = new Apuesta(j, participanteSeleccionado, montoFloat, carreraSeleccionada);
                    modelo.agregarApuesta(apuesta);
                    j.setUltimaApuesta(apuesta);
                    participanteSeleccionado.agregarApuesta(apuesta);
                }
            }
        } catch (ApuestasException ex) {
            vista.mostrarError(ex.getMessage());
        }
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

    private float convertirMonto(String monto) throws ApuestasException {
        float ret;
        if(monto.isEmpty()){
            throw new ApuestasException("Debe ingresar un monto");
        }else{
           try {
               ret = Float.parseFloat(monto);
           }catch(Exception ae){
               throw new ApuestasException("Monto inválido");
           }
        }
        return ret;
    }

}
