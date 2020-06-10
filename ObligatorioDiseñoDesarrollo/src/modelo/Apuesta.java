<<<<<<< HEAD
=======
<<<<<<< HEAD:ObligatorioDiseñoDesarrollo/src/modelo/ModalidadApuesta.java
>>>>>>> Submaster
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

<<<<<<< HEAD
=======
import java.util.ArrayList;

>>>>>>> Submaster
/**
 *
 * @author Mauro
 */
<<<<<<< HEAD
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
=======
public abstract interface ModalidadApuesta {
    public void calcular();
}
=======
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
    
    
    
    
}
>>>>>>> Submaster:ObligatorioDiseñoDesarrollo/src/modelo/Apuesta.java
>>>>>>> Submaster
