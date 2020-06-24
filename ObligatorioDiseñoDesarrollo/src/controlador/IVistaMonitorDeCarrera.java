
package controlador;

import java.util.ArrayList;
import modelo.Apuesta;
import modelo.Carrera;
import modelo.Participante;


public interface IVistaMonitorDeCarrera {
    
    public void cargarCarreras(ArrayList<Carrera> carreras);
   
    public void mostrarDetalle(Carrera carreraSeleccionada);

    public void mostrarParticipantes(ArrayList<Participante> participantes);

    public String formatearParticipante(Participante participante);
    
    public String formatearApuesta(Apuesta apuesta);
    
    public void mostrarDetalleApuestasGanadoras(ArrayList<Apuesta> apuestas);

    public void limpiarListas();
    
}
