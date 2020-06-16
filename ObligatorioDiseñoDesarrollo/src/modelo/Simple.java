
package modelo;

public class Simple extends ModalidadApuesta{

    public Simple(){
        super.multiplicador=1;
    }

    
    @Override
    public float calcularGanancia(float loApostado, double dividendo) {
        return loApostado*(float)dividendo;
    }

    
}
