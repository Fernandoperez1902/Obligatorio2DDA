/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Mauro
 */
public class Apuesta {
    
    private float monto;
    private Jugador jugador;
    private Participante participante;
    
    public Apuesta(Jugador jugador, Participante participante, float monto){
        this.jugador= jugador;
        this.participante = participante;
        this.monto = monto;
    }
    
    
    
}
