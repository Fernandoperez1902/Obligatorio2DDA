package modelo;

public class Cuadruple extends ModalidadApuesta {

    public Cuadruple() {
        super.multiplicador = 2;
    }

    @Override
    public float calcularMontoGananciaSegunModalidad(float loApostado, double dividendo, float montoTotalApostado) {
        float ret;
        if (dividendo >= 2) {
            ret =  (float)(loApostado * dividendo * 2);   
        }else{
            ret =  (float)(loApostado * dividendo * 3);  
        }
        return ret;
    }

    @Override
    public String tipoModalidad() {
        return "Cuadruple";
    }

}
