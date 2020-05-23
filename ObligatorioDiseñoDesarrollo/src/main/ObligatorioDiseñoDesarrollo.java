/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import interfaz.VentanaInicio;

/**
 *
 * @author Fernando
 */
public class ObligatorioDiseñoDesarrollo {


    public static void main(String[] args) {
        
        DatosPrueba.cargar();
        
        VentanaInicio inicio = new VentanaInicio();
        inicio.setVisible(true);

    }
    
}
