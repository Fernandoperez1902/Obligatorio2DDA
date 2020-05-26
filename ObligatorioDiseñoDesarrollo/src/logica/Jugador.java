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
    // </editor-fold>
    
    //Verifica la suficiencia de saldo.
    public boolean saldoSuficiente(float montoApuesta){
        return saldo>=montoApuesta;
    }
    
    
    
}
