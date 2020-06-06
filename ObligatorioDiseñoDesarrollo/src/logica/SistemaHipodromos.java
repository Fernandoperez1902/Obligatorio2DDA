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
public class SistemaHipodromos {

    private ArrayList<Hipodromo> hipodromos = new ArrayList<Hipodromo>();

    public ArrayList<Hipodromo> getHipodromos() {
        return hipodromos;
    }

    public void agregarHipodromo(Hipodromo h) {
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

}
