
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
        this.participantes = new ArrayList(); 
        cargarCarrera();
    }
    
    public void cargarCarrera(){       
        ultimaCerrada = seleccionado.buscarUltimaCarreraCerrada();
        if (ultimaCerrada != null){
            participantes = ultimaCerrada.getParticipantes();
            vista.mostrarCarrera(ultimaCerrada);
        } else {
            vista.mostrarError("No hay con carreras con apuestas cerradas para asignar ganador");
            vista.cerrar();
        }
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
