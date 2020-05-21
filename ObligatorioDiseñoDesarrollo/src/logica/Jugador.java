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
    
    
}
