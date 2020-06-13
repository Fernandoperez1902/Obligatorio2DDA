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
public class Simple extends ModalidadApuesta{

    public Simple(){
        super.multiplicador=1;
    }

    
    @Override
    public float calcularGanancia(float loApostado, double dividendo) {
        return loApostado*(float)dividendo;
    }

    
}
