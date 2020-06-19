package modelo;

public class Simple extends ModalidadApuesta {

    public Simple() {
        super.multiplicador = 1;
    }

    @Override
    public float calcularMontoGananciaSegunModalidad(float loApostado, double dividendo, float montoTotalApostado) {
        return loApostado * (float) dividendo;
    }
}
