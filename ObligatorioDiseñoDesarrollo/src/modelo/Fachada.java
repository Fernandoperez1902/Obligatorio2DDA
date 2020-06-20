
package modelo;

import java.util.ArrayList;
import java.util.Date;
import observer.Observable;

public class Fachada extends Observable{

    private static Fachada instancia;
    
    private SistemaUsuarios su = new SistemaUsuarios();
    private SistemaHipodromos sh = new SistemaHipodromos();
    private SistemaApuestas sa = new SistemaApuestas();
    private SistemaCaballos sc = new SistemaCaballos();

    public static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    private Fachada() {
    }

    public Administrador loginAdministrador(String nombre, String password) {
        return su.loginAdministrador(nombre, password);
    }

    public Jugador loginJugador(String nombre, String password) throws ApuestasException{
        return su.loginJugador(nombre, password);
    }

    public void agregarAdministrador(Administrador adm) {
        su.agregarAdministrador(adm);
    }

    public void agregarJugador(Jugador j) {
        su.agregarJugador(j);
    }

    public void agregarHipodromo(Hipodromo h) {
        sh.agregar(h);
    }

    public void AgregarCaballo(Caballo c) {
        sc.AgregarCaballo(c);
    }

    public ArrayList<Hipodromo> getHipodromos() {
        return sh.getHipodromos();
    }

    public ArrayList<Caballo> getCaballos() {
        return sc.getCaballos();
    }

    public boolean agregarApuesta(Apuesta a) throws ApuestasException {
        return sa.agregarApuesta(a);
    }

    public void agregarModalidad(ModalidadApuesta modalidad){
        sa.agregarModalidad(modalidad);
    }
    
    public ArrayList<ModalidadApuesta> getModalidades(){
        return sa.getModalidadades();
    }
    
    public ArrayList<Caballo> caballosDisponiblesEnFecha(Date fecha) {
        return sh.caballosDisponiblesEnFecha(fecha);
    }

    public Jornada buscarJornada(Hipodromo h, Date f) {
        return sh.buscarJornada(h, f);
    }

    
    //MÉTODOS PARA LA CARGA DE INFORMACIÓN DESDE LA BASE DE DATOS
    public void cargarUsuarios() {
        su.cargarUsuarios();
    }
    public void cargarCaballos() {
        sc.cargarCaballos();
    }
    public void cargarHipodromos() {
        sh.cargarHipodromos();
    }
}
