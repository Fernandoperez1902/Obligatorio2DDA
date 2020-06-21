
package modelo;

import java.util.ArrayList;
import mapeadores.MapeadorCaballo;
import mapeadores.MapeadorJugador;
import persistencia.Persistencia;

public class SistemaCaballos {
    private ArrayList<Caballo>caballos = new ArrayList<Caballo>();

    public ArrayList<Caballo> getCaballos() {
        return caballos;
    }
    
    void cargarCaballos() {
        MapeadorCaballo map = new MapeadorCaballo();
        ArrayList<Caballo> lista = Persistencia.getInstancia().obtenerTodos(map);
        for (Caballo c : lista) {
            this.agregarCaballo(c);
        }
    }

    public void agregarCaballo(Caballo c) {
        caballos.add(c);
    }
    
    
}
