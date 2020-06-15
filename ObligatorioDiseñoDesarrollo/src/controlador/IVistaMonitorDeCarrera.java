
package controlador;

import java.util.ArrayList;
import modelo.Apuesta;
import modelo.Carrera;
import modelo.Participante;


public interface IVistaMonitorDeCarrera {
    
    public void cargarCarreras(ArrayList<Carrera> carreras);

    public void cargarParticipantes(ArrayList<Participante> participantes);
    
    public void cargarApostadores(ArrayList<Apuesta> apuestas);
    
}
