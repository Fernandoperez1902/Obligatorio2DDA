package modelo;

import java.util.ArrayList;
import java.util.Date;
import mapeadores.MapeadorCaballo;
import mapeadores.MapeadorCarrera;
import mapeadores.MapeadorHipodromo;
import mapeadores.MapeadorJornada;
import mapeadores.MapeadorParticipante;
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

    //CARGA DE HIPODROMOS DESDE LA BASE DE DATOS
    public void cargarHipodromos() {
        MapeadorHipodromo mapH = new MapeadorHipodromo();
        ArrayList<Hipodromo> lista = Persistencia.getInstancia().obtenerTodos(mapH);
        for (Hipodromo h : lista) {
        //CARGA DE DATOS AL INTERIOR DEL HIPÓDROMO ---------------------------------------------------
//
//            ArrayList<Jornada>jornadas = cargarJornadas("oidHipodromo = "+ h.getOid(), h);
//            for(Jornada j : jornadas){
//                ArrayList<Carrera>carreras = cargarCarreras("oidJornada = " + j.getOid(), j);
//                for (Carrera c : carreras){
//                    c.setParticipantes(cargarParticipantes("oidCarrera = " + c.getOid(), c));
//                }
//                j.setCarreras(carreras);
//            }
//            h.setJornadas(jornadas);
//      -----------------------------------------------------------------------------------------------
            hipodromos.add(h);
        }
        ArrayList<Hipodromo> hs =getHipodromos();
    }
    
    //CARGA DE JORNADA DESDE LA BASE DE DATOS
    public ArrayList<Jornada> cargarJornadas(String filtro, Hipodromo hipodromo) {
        MapeadorJornada map = new MapeadorJornada();
        ArrayList<Jornada> jornadas = Persistencia.getInstancia().buscar(map, filtro);
        for(Jornada j : jornadas){
            j.setHipodromo(hipodromo);
        }
        return jornadas;
    }

    //CARGA DE CARRERA DESDE LA BASE DE DATOS
    public ArrayList<Carrera> cargarCarreras(String filtro, Jornada jornada) {
        MapeadorCarrera map = new MapeadorCarrera();
        ArrayList<Carrera> carreras = Persistencia.getInstancia().buscar(map, filtro);
        for (Carrera c : carreras){
            c.setJornada(jornada);
        }
        return carreras;
    }
    
    //CARGA DE PARTICIPANTE DESDE LA BASE DE DATOS
    public ArrayList<Participante> cargarParticipantes(String filtro, Carrera carrera) {
        MapeadorParticipante map = new MapeadorParticipante();
        ArrayList<Participante> participantes = Persistencia.getInstancia().buscar(map, filtro);
        for(Participante p : participantes){
            p.setCarrera(carrera);
        }
        return participantes;
    }
 
    //----------------------------------------------------------------------------------------------
    //GUARDA HIPODROMO EN LA BASE DE DATOS
    public void guardarHipodromo(Hipodromo hipodromo) {
        MapeadorHipodromo mH = new MapeadorHipodromo(hipodromo);
        Persistencia.getInstancia().guardar(mH);
    }

    //GUARDA CARRERA EN LA BASE DE DATOS
    void guardarCarrera(Jornada jornada) {
        MapeadorJornada mJ = new MapeadorJornada(jornada);
        Persistencia.getInstancia().guardar(mJ);
    }

    //GUARDA PARTICIPANTE EN LA BASE DE DATOS
    void guardarParticipante(Carrera carrera) {
        MapeadorCarrera mJ = new MapeadorCarrera(carrera);
        Persistencia.getInstancia().guardar(mJ);
    }

}
