
package controlador;

import java.util.ArrayList;
import modelo.ModalidadApuesta;
import modelo.Participante;

public interface IVistaModificarModalidadParticipante {
    
    public void mostrarDatosParticipante(Participante participante);
    
    public void mostrarModalidades(ArrayList<ModalidadApuesta> modalidades);
    
    public String formatearModalidad(ModalidadApuesta modalidad);
    
    public void cerrar();
}
