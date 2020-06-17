/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import interfaz.VentanaInicio;
import java.text.DateFormat;
import java.util.Date;
import persistencia.BaseDatos;

/**
 *
 * @author Fernando
 */
public class ObligatorioDiseñoDesarrollo {


    public static void main(String[] args) {
        //conectar();
        DatosPrueba.cargar();
        new VentanaInicio().setVisible(true);
    }
    
    private static void conectar(){
        String url = "jdbc:mysql://localhost/obligatoriodda";
        BaseDatos bd = BaseDatos.getInstancia();
        bd.conectar("com.mysql.jdbc.Driver",url, "root", "root");
    }
    
}
