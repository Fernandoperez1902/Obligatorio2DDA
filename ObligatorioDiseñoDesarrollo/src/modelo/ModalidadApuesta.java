
package modelo;

import java.util.ArrayList;

public abstract class ModalidadApuesta {
    
    protected float multiplicador; 
    
    public abstract float calcularGanancia(float montoApostado, double dividendo);
    
    public float calcularPerdida(float montoApostado){
        return montoApostado*multiplicador*-1; 
    }
    
}
