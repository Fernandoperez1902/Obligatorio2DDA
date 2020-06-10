
package modelo;


import java.util.ArrayList;


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