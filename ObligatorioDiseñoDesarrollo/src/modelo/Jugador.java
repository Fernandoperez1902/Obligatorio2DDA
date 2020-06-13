/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;

/**
 *
 * @author Mauro
 */
public class Jugador extends Usuario {

    private float saldo;
    private Apuesta ultimaApuesta;

    public Jugador(String u, String p, String n, int s) {
        super(u, p, n);
        saldo = s;

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
    }

    // </editor-fold>
    
    
    //Verifica la suficiencia de saldo.
    public boolean saldoSuficiente(String montoApuesta) throws ApuestasException {
        boolean ret = true;
        if (montoApuesta.isEmpty()) {
            throw new ApuestasException("Debe ingresar el monto de su apuesta");
        }
        float monto;
        try {
            monto = Float.valueOf(montoApuesta);
        } catch (Exception ex) {
            throw new ApuestasException("El monto ingresado no es válido");
        }
        if (saldo < monto) {
            ret = false;
            throw new ApuestasException("Saldo insuficiente");
        }

        return ret;
    }

    //Actualiza el saldo en función de lo perdido o ganado en una apuesta.
    //(recibe tanto valores positivos como negativos)
    public float actualizarSaldo(float monto) {
        return saldo = saldo + monto;
    }
}
