
package modelo;

import java.io.IOException;

public class Jugador extends Usuario {

    private float saldo;
    private Apuesta ultimaApuesta;

    public Jugador(String u, String p, String n, int s) {
        super(u, p, n);
        saldo = s;
        ultimaApuesta = null;
    }

    public Jugador() {

    }

    // <editor-fold defaultstate="collapsed" desc="Aquí están los Getters y Setters">
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Apuesta getUltimaApuesta() {
        return ultimaApuesta;
    }

    public void setUltimaApuesta(Apuesta ultimaApuesta) {
        this.ultimaApuesta = ultimaApuesta;
        restarSaldo(ultimaApuesta.getMontoPagado());
    }

    // </editor-fold>
    
    
    //Verifica la suficiencia de saldo.
    public boolean saldoSuficiente(float montoApuesta) throws ApuestasException {
        boolean ret = true;
        if(montoApuesta<1){
            throw new ApuestasException("Monto inválido ");            
        }
        try {
            montoApuesta = Float.valueOf(montoApuesta);
        } catch (Exception ex) {
            throw new ApuestasException("El monto ingresado no es válido");
        }
        if (saldo < montoApuesta) {
            ret = false;
            throw new ApuestasException("Saldo insuficiente");
        }
        

        return ret;
    }

    
    //Actualiza el saldo en función de lo perdido o ganado en una apuesta.
    //(recibe tanto valores positivos como negativos)
    public void actualizarSaldo(float monto) {
        setSaldo(saldo + monto);
    }

    //Resta del saldo lo correspondiente a su apuesta
    private void restarSaldo(float monto) {
        actualizarSaldo(monto*-1);
    }
    
    //Suma a su saldo lo correspondiente a una apuesta ganadora
    private void sumarSaldo(float monto) {
        actualizarSaldo(monto);
    }
}
