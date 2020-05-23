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
public class Fachada {
    
    
    private static Fachada instancia;
    private SistemaUsuarios su = new SistemaUsuarios();
    private SistemaHipodromos sh = new SistemaHipodromos();
    
    public static Fachada getInstancia(){
        if (instancia ==null){
            instancia = new Fachada();
        }
        return instancia;
    }
    
    private Fachada(){}
    
    public void agregarJugador(Jugador j){
        su.agregarJugador(j);
    }
    
    public void agregarHipodromo(Hipodromo h){
        sh.agregarHipodromo(h);
    }
    
     public ArrayList<Hipodromo> getHipodromos(){
         return sh.getHipodromos();
     }
}
