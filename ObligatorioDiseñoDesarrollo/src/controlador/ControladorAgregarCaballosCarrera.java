package controlador;

import java.util.ArrayList;
import modelo.ApuestasException;
import modelo.Caballo;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;
import modelo.Jornada;
import modelo.Participante;

public class ControladorAgregarCaballosCarrera {

    private Fachada modeloFachada;
    private Jornada modeloJornada;
    private Carrera modeloCarrera;
    private Hipodromo seleccionado;
    private boolean esNuevaJornada;
    private ArrayList<Caballo> disponibles;
    private ArrayList<Participante> participantes;
    private IVistaAgregarCaballosCarrera vista;
    private Caballo caballoSeleccionado;

    public ControladorAgregarCaballosCarrera(Jornada modeloJornada, Carrera modeloCarrera,
            Hipodromo seleccionado, boolean esNuevaJornada, IVistaAgregarCaballosCarrera vista) {

        this.modeloFachada = Fachada.getInstancia();
        this.modeloJornada = modeloJornada;
        this.modeloCarrera = modeloCarrera;
        this.seleccionado = seleccionado;
        this.esNuevaJornada = esNuevaJornada;
        this.participantes = modeloCarrera.getParticipantes();
        this.vista = vista;
        this.disponibles = this.modeloFachada.caballosDisponiblesEnFecha(this.modeloCarrera.getFecha());
        this.vista.mostrarDatos(modeloCarrera);
        this.vista.mostrarCaballosDisponibles(this.disponibles);
        this.vista.mostrarParticipantes(participantes);
    }

    public void agregarParticipante(int numero, double dividendo) {
        try {
            Participante participante = new Participante(caballoSeleccionado, numero, dividendo, false, modeloCarrera);
            modeloCarrera.validarParticipante(participante);
            modeloCarrera.agregarParticipante(participante);
            disponibles.remove(caballoSeleccionado);
            caballoSeleccionado = null;
            vista.mostrarParticipantes(participantes);
            vista.mostrarCaballosDisponibles(disponibles);
        } catch (ApuestasException e) {
            vista.mostrarError(e.getMessage());
        }

    }

    public void seleccionarCaballo(int index) {
        caballoSeleccionado = disponibles.get(index);
    }

    public void altaCarrera() {
        if (esNuevaJornada) {
            seleccionado.agregarJornada(modeloJornada);
        }
        try {
            modeloJornada.agregarCarrera(modeloCarrera);
            vista.cerrar();
        } catch (ApuestasException e){
            vista.mostrarError(e.getMessage());
        }

    }

}
