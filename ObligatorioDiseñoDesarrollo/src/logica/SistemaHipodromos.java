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
public class SistemaHipodromos {
    private ArrayList<Hipodromo> hipodromos = new ArrayList<Hipodromo>();
    
    public ArrayList<Hipodromo> getHipodromos() {
        return hipodromos;
    }
    
    public void agregarHipodromo(Hipodromo h){
        hipodromos.add(h);
    }
    
    
}
