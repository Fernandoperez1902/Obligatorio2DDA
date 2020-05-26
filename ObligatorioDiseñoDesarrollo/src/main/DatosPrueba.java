/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import logica.Administrador;
import logica.Caballo;
import logica.Fachada;
import logica.Hipodromo;
import logica.Jugador;
import logica.SistemaCaballos;
import logica.SistemaHipodromos;

/**
 *
 * @author Mauro
 */
public class DatosPrueba {
    
    public static void cargar(){
        
        Fachada logica = Fachada.getInstancia();
        
        //CABALLOS
        Caballo c1 = new Caballo("Caballo1","Responsable1");
        Caballo c2 = new Caballo("Caballo2","Responsable2");
        Caballo c3 = new Caballo("Caballo3","Responsable3");
        Caballo c4 = new Caballo("Caballo4","Responsable4");
        Caballo c5 = new Caballo("Caballo5","Responsable5");
        Caballo c6 = new Caballo("Caballo6","Responsable6");
        
        logica.AgregarCaballo(c1);
        logica.AgregarCaballo(c2);
        logica.AgregarCaballo(c3);
        
        //HIPODROMOS
        
        Hipodromo h1 = new Hipodromo("Hipódromo1","Dirección1");
        Hipodromo h2 = new Hipodromo("Hipódromo2","Dirección2");
        Hipodromo h3 = new Hipodromo("Hipódromo3","Dirección3");
        Hipodromo h4 = new Hipodromo("Hipódromo4","Dirección4");
        Hipodromo h5 = new Hipodromo("Hipódromo1","Dirección2");
        
        //ADMINISTRADORES
        
        Administrador a1 = new Administrador("A1","A1", "Administrador1");
        Administrador a2 = new Administrador("A2","A2", "Administrador2");
        Administrador a3 = new Administrador("A3","A3", "Administrador3");

        logica.agregarAdministrador(a1);
        
        //JUGADORES
        
        Jugador j1 = new Jugador("J1", "J1", "Jugador1", 100);
        Jugador j2 = new Jugador("J2", "J2", "Jugador2", 100);
        Jugador j3 = new Jugador("J3", "J3", "Jugador3", 100);
        Jugador j4 = new Jugador("J4", "J4", "Jugador4", 100);
        Jugador j5 = new Jugador("J5", "J5", "Jugador5", 100);
        
        logica.agregarJugador(j1);
        logica.agregarJugador(j2);
        logica.agregarJugador(j3);
        logica.agregarJugador(j4);
        logica.agregarJugador(j5);
        
        
        logica.agregarHipodromo(h1);
        logica.agregarHipodromo(h2);
        logica.agregarHipodromo(h3);
        logica.agregarHipodromo(h4);
    }
}
