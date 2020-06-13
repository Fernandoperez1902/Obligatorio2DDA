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
public class Cuadruple extends ModalidadApuesta{

    public Cuadruple() {
         super.multiplicador=2;
    }
    
    @Override
    public float calcularGanancia(float loApostado, double dividendo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
