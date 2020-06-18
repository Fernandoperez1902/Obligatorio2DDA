package modelo;

import java.util.ArrayList;

public abstract class ModalidadApuesta {

    protected float multiplicador;

    public abstract float calcularMontoGananciaSegunModalidad(float montoApostado, double dividendo);

    public float calcularMontoPagadoSegunModalidad(float montoApostado) {
        return montoApostado * multiplicador * -1;
    }
}
