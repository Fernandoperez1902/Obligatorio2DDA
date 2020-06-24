
package main;

import interfaz.VentanaInicio;
import persistencia.BaseDatos;

public class ObligatorioDiseñoDesarrollo {


    public static void main(String[] args) {
        conectar();
        DatosPrueba.cargar();
        new VentanaInicio().setVisible(true);
    }
    
    private static void conectar(){
        String url = "jdbc:mysql://localhost/obligatoriodda";
        BaseDatos bd = BaseDatos.getInstancia();
        bd.conectar("com.mysql.jdbc.Driver",url, "root", "root");
    }
}
