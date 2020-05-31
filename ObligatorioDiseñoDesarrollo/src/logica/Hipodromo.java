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
public class Hipodromo {

    private String nombre;
    private String direccion;
    private ArrayList<Jornada> jornadas = new ArrayList<Jornada>();

    public Hipodromo(String n, String d) {
        nombre = n;
        direccion = d;
    }

    // <editor-fold defaultstate="collapsed" desc="Aquí están los Getters y Setters">
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
    public boolean validarHipodromo(String nombre) /*throws ApuestasException*/ {
        boolean ret = true;
        if (this.nombre == nombre) {
            //throw new ApuestasException("El nombre del Hipódromo ya existe");
        } else {
            ret = false;
        }
        return ret;
    }

    //Devuelve la jornada de la fecha
    public Jornada getJornadaDelDia(Date fecha) {
        Jornada jornada = null;
        for (Jornada j : jornadas) {
            if (j.esJornadaDelDia(fecha)) {
                jornada = j;
            }
        }
        return jornada;
    }
}
