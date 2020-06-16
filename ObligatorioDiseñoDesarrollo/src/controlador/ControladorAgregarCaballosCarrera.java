
package controlador;

import java.util.ArrayList;
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
    private ArrayList<Participante> participantes = new ArrayList();
    private IVistaAgregarCaballosCarrera vista;
    private Caballo caballoSeleccionado;
    
    public ControladorAgregarCaballosCarrera(Jornada modeloJornada, Carrera modeloCarrera,
            Hipodromo seleccionado, boolean esNuevaJornada, IVistaAgregarCaballosCarrera vista){
        
        this.modeloFachada = Fachada.getInstancia();
        this.modeloJornada = modeloJornada;
        this.modeloCarrera = modeloCarrera;
        this.seleccionado = seleccionado;
        this.esNuevaJornada = esNuevaJornada;
        this.vista = vista;
        this.disponibles = this.modeloFachada.caballosDisponiblesEnFecha(this.modeloCarrera.getFecha());
        this.vista.mostrarCaballosDisponibles(this.disponibles);
        this.vista.mostrarParticipantes(participantes);
        
    }
    
    public void agregarParticipante(int numero, double dividendo){
        Participante participante = new Participante(caballoSeleccionado, numero, dividendo);
        participantes.add(participante);
        vista.mostrarParticipantes(participantes);
        //disponibles.remove(caballoSeleccionado);
        //vista.mostrarCaballosDisponibles(disponibles);
    }
    
    public void seleccionarCaballo(int index){
        caballoSeleccionado = disponibles.get(index);
    }
    
    public void altaCarrera(){
        modeloCarrera.setParticipantes(participantes);
        if (esNuevaJornada) {
            //TODO que se haga una validación del lado de la lógica para saber
            //si la jornada existe o no
            seleccionado.agregarJornada(modeloJornada);
        }
        if (modeloCarrera.validarCarrera() == Carrera.ErrorValidacion.carreraOk) {
            modeloJornada.agregarCarrera(modeloCarrera);
            vista.cerrar();
        }
        
    }
    
}
