
package controlador;

import java.util.ArrayList;
import modelo.Fachada;
import modelo.ModalidadApuesta;
import modelo.Participante;

public class ControladorModificarModalidadParticipante {
 
    private Participante seleccionado;
    private Fachada modeloFachada;
    private IVistaModificarModalidadParticipante vista;
    private ArrayList<ModalidadApuesta> modalidades;
    
    public ControladorModificarModalidadParticipante(Participante seleccionado,
            IVistaModificarModalidadParticipante vista){
        
        this.seleccionado = seleccionado;
        this.modeloFachada = Fachada.getInstancia();
        this.vista = vista;
        this.modalidades = modeloFachada.getModalidades();
        vista.mostrarDatosParticipante(seleccionado);
        vista.mostrarModalidades(modalidades);
    }
    
    public void modificarParticipante(int index){
        seleccionado.setTipoApuesta(modalidades.get(index));
        vista.cerrar();
    }
}
