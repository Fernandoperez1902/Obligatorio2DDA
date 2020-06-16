
package controlador;

import java.util.ArrayList;
import modelo.Carrera;
import modelo.Participante;

public interface IVistaCerrarApuestas {
    
    public void mostrarCarrera(Carrera carrera);
    
    public void mostrarParticipantesCarrera(ArrayList<Participante> participantes);
    
    public String formatearParticipante(Participante participante);
}
