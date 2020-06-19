package modelo;

import java.util.ArrayList;
import mapeadores.MapeadorAdministrador;
import mapeadores.MapeadorJugador;
import persistencia.Persistencia;

public class SistemaUsuarios {

    private ArrayList<Usuario> jugadores = new ArrayList<Usuario>();
    private ArrayList<Usuario> administradores = new ArrayList<Usuario>();

    private Usuario login(ArrayList<Usuario> usuarios, String nombre, String password) {
        Usuario ret = null;
        boolean encontrado = false;
        for (int i = 0; i < usuarios.size() && !encontrado; i++) {
            Usuario u = usuarios.get(i);
            if (u.verificarDatos(nombre, password)) {
                ret = u;
                encontrado = true;
            }
        }
        return ret;
    }

    public Administrador loginAdministrador(String nombre, String password) {
        Administrador ret = null;
        Usuario u = login(administradores, nombre, password);
        if (u != null) {
            ret = (Administrador) u;
        }
        return ret;
    }

    public Jugador loginJugador(String nombre, String password) throws ApuestasException {
        Jugador ret = null;
        if (nombre.isEmpty() || password.isEmpty()) {
            throw new ApuestasException("Debe ingresar Usuario y Contraseña");
        }
        Usuario u = login(jugadores, nombre, password);
        if (u != null) {
            ret = (Jugador) u;
        } else {
            throw new ApuestasException("Acceso denegado, verifique los datos ingresados");
        }
        return ret;
    }

    public void agregarAdministrador(Administrador adm) {
        administradores.add(adm);
    }

    public void agregarJugador(Jugador j) {
        jugadores.add(j);
    }

    public void cargarUsuarios() {
        this.cargarJugadores();
        this.cargarAdministradores();
    }

    private void cargarJugadores() {
        MapeadorJugador map = new MapeadorJugador();
        ArrayList<Jugador> lista = Persistencia.getInstancia().obtenerTodos(map);
        for (Jugador j : lista) {
            this.agregarJugador(j);
        }
    }

    private void cargarAdministradores() {
        MapeadorAdministrador map = new MapeadorAdministrador();
        ArrayList<Administrador> lista = Persistencia.getInstancia().obtenerTodos(map);
        for (Administrador a : lista) {
            this.agregarAdministrador(a);
        }
    }
}
