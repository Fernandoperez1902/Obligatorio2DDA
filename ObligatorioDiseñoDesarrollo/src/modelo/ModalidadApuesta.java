package modelo;

import java.util.ArrayList;

public abstract class ModalidadApuesta {
    
    protected float multiplicador;

    //CALCULA EL MONTO A COBRAR POR EL JUGADOR EN CADA APUESTA GANADORA SEGÚN LA MODALIDAD
    public abstract float calcularMontoGananciaSegunModalidad(float montoApostado, double dividendo, float montoTotalApostado);

    
    //CALCULA EL MONTO EFECTIVAMENTE PAGADO POR EL JUGADOR EN CADA APUESTA SEGÚN LA MODALIDAD
    public float calcularMontoPagadoSegunModalidad(float montoApostado) {
        return montoApostado * multiplicador;
    }
    
    //DEVUELVE STRING PARA CARGAR EL COMBO
    public abstract String tipoModalidad();

}
