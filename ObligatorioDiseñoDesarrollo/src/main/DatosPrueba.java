
package main;

import modelo.Cuadruple;
import modelo.Fachada;
import modelo.Simple;
import modelo.Triple;


public class DatosPrueba {

    public static void cargar() {
        cargarAca();
        cargarBaseDatos();
    }

    public static void cargarBaseDatos() {
        Fachada logica = Fachada.getInstancia();
        logica.cargarUsuarios();
        logica.cargarCaballos();
        logica.cargarHipodromos();

    }

    private static void cargarAca() {
        Fachada logica = Fachada.getInstancia();

        //MODALIDADES
        Simple simple = new Simple();
        Triple triple = new Triple();
        Cuadruple cuadruple = new Cuadruple();

        logica.agregarModalidad(simple);
        logica.agregarModalidad(triple);
        logica.agregarModalidad(cuadruple);

    }
}
