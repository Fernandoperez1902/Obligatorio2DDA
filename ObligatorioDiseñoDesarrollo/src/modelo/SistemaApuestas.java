
package modelo;

import java.util.ArrayList;

public class SistemaApuestas {
    
    private ArrayList<Apuesta>apuestas = new ArrayList<Apuesta>();
    private ArrayList<ModalidadApuesta> modalidades = new ArrayList();
    
    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }
    
    public ArrayList<ModalidadApuesta> getModalidadades(){
        return modalidades;
    }

    public boolean agregarApuesta(Apuesta a) {
        return apuestas.add(a);
    }
    
    public void agregarModalidad(ModalidadApuesta modalidad){
        modalidades.add(modalidad);
    }
    
    
}
