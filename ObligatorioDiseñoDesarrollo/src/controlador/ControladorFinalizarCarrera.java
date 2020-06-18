
package controlador;

import java.util.ArrayList;
import modelo.Carrera;
import modelo.Hipodromo;
import modelo.Participante;

public class ControladorFinalizarCarrera {
    
    private Hipodromo seleccionado;
    private IVistaFinalizarCarrera vista;
    private Carrera ultimaCerrada;
    private ArrayList<Participante> participantes;
    private Participante ganadorSeleccionado;
    
    public ControladorFinalizarCarrera(Hipodromo seleccionado, IVistaFinalizarCarrera vista){
        this.seleccionado = seleccionado;
        this.vista = vista;
        this.ultimaCerrada = seleccionado.buscarUltimaCarreraCerrada();
        this.participantes = ultimaCerrada.getParticipantes(); 
        vista.mostrarCarrera(ultimaCerrada);
    }
    
    public void seleccionarGanador(int index){
        ganadorSeleccionado = participantes.get(index);
        vista.mostrarGanador(ganadorSeleccionado);
    }
    
    public void FinalizarCarrera(){
        ganadorSeleccionado.setGanador(true);
        ultimaCerrada.finalizar();
        vista.cerrar();
    }
}
