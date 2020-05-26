/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author Mauro
 */
public class SistemaCaballos {
    
    private ArrayList<Caballo>caballos = new ArrayList<Caballo>();

    public ArrayList<Caballo> getCaballos() {
        return caballos;
    }
    
    public void AgregarCaballo(Caballo c){
        
        caballos.add(c);
    }
    
}
