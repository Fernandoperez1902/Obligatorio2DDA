/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import interfaz.VentanaInicio;
import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author Fernando
 */
public class ObligatorioDiseñoDesarrollo {


    public static void main(String[] args) {
        
        System.out.println(new Date());
        
        VentanaInicio inicio = new VentanaInicio();
        inicio.setVisible(true);
        DatosPrueba.cargar();
        
    }
    
}
