package modelo;

import java.util.ArrayList;
import java.util.Date;
import observer.Observable;

public class Fachada extends Observable {

    private static Fachada instancia;

    private SistemaUsuarios su = new SistemaUsuarios();
    private SistemaHipodromos sh = new SistemaHipodromos();
    private SistemaApuestas sa = new SistemaApuestas();
    private SistemaCaballos sc = new SistemaCaballos();

     public enum Eventos {seRealizoApuesta};
    
    
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

    public Jugador loginJugador(String nombre, String password) throws ApuestasException {
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

    public void agregarCaballo(Caballo c) {
        sc.agregarCaballo(c);
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

    public void agregarModalidad(ModalidadApuesta modalidad) {
        sa.agregarModalidad(modalidad);
    }

    public ArrayList<ModalidadApuesta> getModalidades() {
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

    //MÉTODOS PARA GUARDAR INFORMACIÓN EN LA BASE DE DATOS
    public void guardarHipodromo(Hipodromo hipodromo) {
        sh.guardarHipodromo(hipodromo);
    }

    //VER SI CORRESPONDE ACÁ U EN OTRO LADO..   
    public void guardarCarrera(Jornada jornada) {
        sh.guardarCarrera(jornada);
    }

    public void guardarParticipante(Carrera carrera) {
        sh.guardarParticipante(carrera);
    }

    public void guardarApuesta(Apuesta a) {
        sa.guardarApuesta(a);
    }
    
    public void guardarJugador(Jugador jugador) {
        su.guardarJugador(jugador);
    }
    
    public Caballo buscarCaballo(int oid) {
        return sc.buscarCaballo(oid); 
    }

    public Jugador buscarJugador(int oid) {
        return su.buscarJugador(oid);
    }
    
    public Apuesta buscarApuesta(int oid) {
        return sa.buscarApuesta(oid);
    }

    public Hipodromo buscarHipodromo(int oid) {
        return sh.buscarHipodromo(oid);
    }
    
    public Participante buscarParticipante(int oid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Jornada> cargarJornadas(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    

}
