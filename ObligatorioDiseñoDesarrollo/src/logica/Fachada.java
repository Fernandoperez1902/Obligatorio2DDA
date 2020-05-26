/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Mauro
 */
public class Fachada {

    private static Fachada instancia;

    private SistemaUsuarios su = new SistemaUsuarios();
    private SistemaHipodromos sh = new SistemaHipodromos();
    private SistemaCaballos sc = new SistemaCaballos();

    public static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    public ArrayList<Caballo> caballosDisponiblesEnFecha(Date fecha) {
        return sh.caballosDisponiblesEnFecha(fecha);
    }

    private Fachada() {
    }

    public Jornada buscarJornada(Hipodromo h, Date f) {
        return sh.buscarJornada(h, f);
    }

    public Administrador loginAdministrador(String nombre, String password) {
        return su.loginAdministrador(nombre, password);
    }

    public Jugador loginJugador(String nombre, String password) {
        return su.loginJugador(nombre, password);
    }

    public void agregarAdministrador(Administrador adm) {
        su.agregarAdministrador(adm);
    }

    public void agregarJugador(Jugador j) {
        su.agregarJugador(j);
    }

    public void AgregarCaballo(Caballo c) {
        sc.AgregarCaballo(c);
    }

    public void agregarHipodromo(Hipodromo h) {
        sh.agregarHipodromo(h);
    }

    public ArrayList<Hipodromo> getHipodromos() {
        return sh.getHipodromos();
    }
    
    public ArrayList<Caballo> getCaballos(){
        return sc.getCaballos();
    }
}
