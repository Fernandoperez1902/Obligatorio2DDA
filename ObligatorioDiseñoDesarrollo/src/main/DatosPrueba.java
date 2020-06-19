/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Date;
import modelo.Administrador;
import modelo.Caballo;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;
import modelo.Jornada;
import modelo.Jugador;
import modelo.Participante;
import modelo.SistemaCaballos;
import modelo.SistemaHipodromos;
import persistencia.BaseDatos;
import persistencia.Persistencia;

/**
 *
 * @author Mauro
 */
public class DatosPrueba {
    
    public static void cargar(){
        
        Fachada logica = Fachada.getInstancia();
        
        //logica.cargarUsuarios();

        
        //CABALLOS
        Caballo c1 = new Caballo("Caballo1","Responsable1");
        Caballo c2 = new Caballo("Caballo2","Responsable2");
        Caballo c3 = new Caballo("Caballo3","Responsable3");
        Caballo c4 = new Caballo("Caballo4","Responsable4");
        Caballo c5 = new Caballo("Caballo5","Responsable5");
        Caballo c6 = new Caballo("Caballo6","Responsable6");
        Caballo c7 = new Caballo("Caballo7","Responsable7");
        Caballo c8 = new Caballo("Caballo8","Responsable8");
        
        logica.AgregarCaballo(c1);
        logica.AgregarCaballo(c2);
        logica.AgregarCaballo(c3);
        logica.AgregarCaballo(c4);
        logica.AgregarCaballo(c5);
        logica.AgregarCaballo(c6);
        
        
        //PARTICIPANTE
        Participante p1 = new Participante(c1,2,2.5);
        Participante p2 = new Participante(c2,4,1.5);
        Participante p3 = new Participante(c3,76,1.3);
        Participante p4 = new Participante(c4,67,1.85);
        
        ArrayList<Participante> participantes = new ArrayList<Participante>();
        ArrayList<Participante> participantes2 = new ArrayList<Participante>();
        participantes.add(p1);
        participantes.add(p2);
        participantes2.add(p3);
        participantes2.add(p4);
        p4.setGanador(true);
        
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
        
        Jugador j1 = new Jugador("j1", "j1", "Jugador1", 100);
        Jugador j2 = new Jugador("j2", "j2", "Jugador2", 500);
        Jugador j3 = new Jugador("j3", "j3", "Jugador3", 1000);
        Jugador j4 = new Jugador("j4", "j4", "Jugador4", 250);
        Jugador j5 = new Jugador("j5", "j5", "Jugador5", 750);
        
        
        logica.agregarJugador(j1);
        logica.agregarJugador(j2);
        logica.agregarJugador(j3);
        logica.agregarJugador(j4);
        logica.agregarJugador(j5);
        
        
        //CARRERAS
        Carrera ca1 = new Carrera("Nombre1",new Date(), 1, participantes);
        ca1.abrir();
        Carrera ca2 = new Carrera("Nombre2",new Date(), 2, participantes2);
        
        
        //JORNADAS 
//        Problem: The project uses the file/folder called "jcalendar-1.4.jar", but this file/folder was not found.rnadas(jornadas);
        
        
        logica.agregarHipodromo(h1);
        logica.agregarHipodromo(h2);
        logica.agregarHipodromo(h3);
        logica.agregarHipodromo(h4);

    }
}
