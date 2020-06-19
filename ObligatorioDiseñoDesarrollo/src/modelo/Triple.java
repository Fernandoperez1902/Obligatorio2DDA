package modelo;

public class Triple extends ModalidadApuesta {

    public Triple() {
        super.multiplicador = 1.5f;
    }

    @Override
    public float calcularMontoGananciaSegunModalidad(float loApostado, double dividendo, float montoTotalApostado) {
        float ret;
        if (montoTotalApostado < 100000) {
            ret = loApostado * (float) dividendo * 2;
        } else {
            ret = loApostado * (float) dividendo * 3;
        }
        return ret;
    }
}
