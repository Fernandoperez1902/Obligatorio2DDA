package modelo;

import java.util.ArrayList;
import java.util.Date;
import observer.Observable;
import utilidades.ManejoDeFechas;

public class Hipodromo extends Observable{

    private int oid;
    private String nombre;
    private String direccion;
    private ArrayList<Jornada> jornadas = new ArrayList<Jornada>();

    public Hipodromo(String n, String d) {
        nombre = n;
        direccion = d;
    }

    public Hipodromo() {
    }

    // <editor-fold defaultstate="collapsed" desc="Aquí están los Getters y Setters">
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Jornada> getJornadas() {
        return jornadas;
    }

    public void setJornadas(ArrayList<Jornada> jornadas) {
        this.jornadas = jornadas;
    }
    // </editor-fold>

    @Override
    public String toString() {
        return nombre.toUpperCase() + " - " + direccion;
    }

    //Valida la condición de unicidad en el nombre
    public boolean validarHipodromo(String nombre) {
        return this.nombre == nombre;
    }


    //Devuelve la jornada de la fecha
    public Jornada buscarJornada(Date fecha) {
        Jornada jornada = null;
        int i = 0;
        while (i < jornadas.size() && jornada == null) {
            if (jornadas.get(i).esJornadaDelDia(fecha)) {
                jornada = jornadas.get(i);
            }
            i++;
        }
        return jornada;
    }

    public boolean existeJornada(Date fecha) {
        boolean existe = false;
        if (buscarJornada(fecha) != null) {
            existe = true;
        }
        return existe;

    }

    public boolean participaCaballo(Date fecha, Caballo cab) {
        boolean participa = false;
        int i = 0;
        while (i < jornadas.size() && !participa) {
            if (jornadas.get(i).esJornadaDelDia(fecha)) {
                if (jornadas.get(i).participaEnCarrera(cab)) {
                    participa = true;
                }
            }
            i++;
        }
        return participa;
    }

    public Carrera buscarProximaCarreraDelDia() {
        Carrera ret = null;
        Jornada jornada = buscarJornada(ManejoDeFechas.tomarFechaSistemaSinHora());
        if(jornada != null){
            ret = jornada.traerProximaCarrera();
        }
        return ret;
    }

    public Carrera buscarCarreraAbierta() {
        Carrera ret = null;
        Jornada jornada = buscarJornada(ManejoDeFechas.tomarFechaSistemaSinHora());
        if(jornada != null){
            ret = jornada.buscarCarreraAbierta();
        }
        return ret;
    }

    public Carrera buscarUltimaCarreraCerrada() {
        Carrera ret = null;
        Jornada jornada = buscarJornada(ManejoDeFechas.tomarFechaSistemaSinHora());
        if(jornada != null){
            ret = jornada.buscarUltimaCarreraCerrada();
        }
        return ret;
    }

    public void agregarJornada(Jornada jornada) {
        jornadas.add(jornada);
        Fachada.getInstancia().guardarHipodromo(this);
    }

    public Carrera buscarCarreraActual() {
        Jornada jornada = buscarJornada(new Date());
        return jornada.carreraActual();
    }
}
