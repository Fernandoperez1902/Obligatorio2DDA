package modelo;

import java.util.ArrayList;
import java.util.Date;
import mapeadores.MapeadorCaballo;
import mapeadores.MapeadorHipodromo;
import persistencia.Persistencia;

public class SistemaHipodromos {

    private ArrayList<Hipodromo> hipodromos = new ArrayList<Hipodromo>();

    public ArrayList<Hipodromo> getHipodromos() {
        return hipodromos;
    }

    public void agregar(Hipodromo h) {
        if (validarHipodromo(h.getNombre())) {
            hipodromos.add(h);
        }
    }

    //Valida la condición de unicidad en el nombre
    public boolean validarHipodromo(String nombre) {
        boolean ret = true;
        for (Hipodromo h : hipodromos) {
            if (h.validarHipodromo(nombre)) {
                ret = false;
            }
        }
        return ret;
    }

    public ArrayList<Caballo> caballosDisponiblesEnFecha(Date fecha) {
        ArrayList<Caballo> caballos = Fachada.getInstancia().getCaballos();
        ArrayList<Caballo> disponibles = new ArrayList();
        for (Caballo c : caballos) {
            boolean participa = false;
            int j = 0;
            while (j < hipodromos.size() && !participa) {
                if (hipodromos.get(j).participaCaballo(fecha, c)) {
                    participa = true;
                }
                j++;
            }
            if (!participa) {
                disponibles.add(c);
            }
        }
        return disponibles;
    }

    public Jornada buscarJornada(Hipodromo h, Date f) {
        Jornada jornada = null;
        jornada = h.buscarJornada(f);
        return jornada;
    }

    public void cargarHipodromos() {
        MapeadorHipodromo map = new MapeadorHipodromo();
        ArrayList<Hipodromo> lista = Persistencia.getInstancia().obtenerTodos(map);
        for (Hipodromo h : lista) {
            this.agregarHipodromo(h);
        }
    }

    public void guardarHipodromo(Hipodromo hipodromo){
        MapeadorHipodromo mH = new MapeadorHipodromo(hipodromo);
        Persistencia.getInstancia().guardar(mH);
    }
    
    private void agregarHipodromo(Hipodromo h) {
        hipodromos.add(h);
    }
    
    

}
