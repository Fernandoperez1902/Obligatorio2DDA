
package controlador;

import java.util.ArrayList;
import modelo.Caballo;
import modelo.Participante;

public interface IVistaAgregarCaballosCarrera {
 
    public String formatearCaballo(Caballo caballo);
    
    public String formatearParticipante(Participante participante);
    
    public void mostrarCaballosDisponibles(ArrayList<Caballo> caballos);
    
    public void mostrarParticipantes(ArrayList<Participante> participantes);
    
}
