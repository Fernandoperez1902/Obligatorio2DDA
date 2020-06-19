
package modelo;

import java.util.ArrayList;
import java.util.Date;
import observer.Observable;

public class Fachada {

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

    public Jugador loginJugador(String nombre, String password) {
        return su.loginJugador(nombre, password);
    }

    public void agregarAdministrador(Administrador adm) {
        su.agregarAdministrador(adm);
    }

    public void agregarJugador(Jugador j) {
        su.agregarJugador(j);
    }

    public void agregarHipodromo(Hipodromo h) {
        sh.agregarHipodromo(h);
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

    //Hablar con Fernando..
    public boolean agregarApuesta(String nombre, String pass, String monto, Participante p, Carrera c) throws ApuestasException {
        boolean ret = false;
        if (monto.isEmpty()) {
            throw new ApuestasException("Debe ingresar el monto de su apuesta");
        }
        float montoF = Float.parseFloat(monto);
        Jugador j = loginJugador(nombre, pass);
        if (j != null && j.saldoSuficiente(p.montoPagadoSegunModalidad(montoF))) {
            Apuesta a = new Apuesta(j, p, montoF, c);
            if (sa.agregarApuesta(a)) {
                p.agregarApuesta(a);
                j.actualizarSaldo(a.getMontoPagado());
                ret = true;
            }
        }
        return ret;
    }

    public ArrayList<Caballo> caballosDisponiblesEnFecha(Date fecha) {
        return sh.caballosDisponiblesEnFecha(fecha);
    }

    public Jornada buscarJornada(Hipodromo h, Date f) {
        return sh.buscarJornada(h, f);
    }

    public void cargarUsuarios() {
        su.cargarUsuarios();
    }
}
