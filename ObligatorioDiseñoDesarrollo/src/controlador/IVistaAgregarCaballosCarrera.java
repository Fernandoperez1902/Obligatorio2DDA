
package controlador;

import java.util.ArrayList;
import modelo.Caballo;
import modelo.Carrera;
import modelo.Participante;

public interface IVistaAgregarCaballosCarrera {
 
    public String formatearCaballo(Caballo caballo);
    
    public String formatearParticipante(Participante participante);
    
    public void mostrarDatos(Carrera carrera);
    
    public void mostrarCaballosDisponibles(ArrayList<Caballo> caballos);
    
    public void mostrarParticipantes(ArrayList<Participante> participantes);
    
    public void mostrarError(String mensaje);
    
    public void cerrar();
    
}
