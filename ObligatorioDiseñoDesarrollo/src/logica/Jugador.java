/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Mauro
 */
public class Jugador extends Usuario {

    private float saldo;
    private Apuesta ultimaApuesta;
    
    
    public Jugador(String u, String p, String n, int s){
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
    public boolean saldoSuficiente(float montoApuesta){
        return saldo>=montoApuesta;
    }
    
    //Actualiza el saldo en función de lo perdido o ganado en una apuesta.
    //(recibe tanto valores positivos como negativos)
    public float actualizarSaldo(float monto){
        return saldo = saldo+monto;
    }
}
