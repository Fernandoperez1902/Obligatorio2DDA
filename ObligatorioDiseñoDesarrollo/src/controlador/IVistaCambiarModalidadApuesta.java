
package controlador;

import java.util.ArrayList;
import modelo.Carrera;
import modelo.ModalidadApuesta;
import modelo.Participante;

public interface IVistaCambiarModalidadApuesta {
    
    public void mostrarCarrera(Carrera carrera);
    
    public void mostrarParticipantesSinApuestas(ArrayList<Participante> participantes);
    
    public void mostrarError(String mensaje);
    
    public void mostrarProximaVista(Participante seleccionado);
    
    public String formatearParticipante(Participante participante);
    
    public void cerrar();
}
