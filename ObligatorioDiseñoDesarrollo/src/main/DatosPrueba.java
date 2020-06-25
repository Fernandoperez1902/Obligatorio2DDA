
package main;

import java.util.ArrayList;
import java.util.Date;
import modelo.Administrador;
import modelo.ApuestasException;
import modelo.Caballo;
import modelo.Carrera;
import modelo.Cuadruple;
import modelo.Fachada;
import modelo.Hipodromo;
import modelo.Jornada;
import modelo.Jugador;
import modelo.Participante;
import modelo.Simple;
import modelo.Triple;
import utilidades.ManejoDeFechas;


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
