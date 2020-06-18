package modelo;

public class Simple extends ModalidadApuesta {

    public Simple() {
        super.multiplicador = 1;
    }

    @Override
    public float calcularMontoGananciaSegunModalidad(float loApostado, double dividendo) {
        return loApostado * (float) dividendo;
    }
}
