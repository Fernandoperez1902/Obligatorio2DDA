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
public class Jornada {
    private Date fecha;
    private int ultimoIdCarrera;
    private int ultimaCerrada;
    private ArrayList<Carrera>carreras = new ArrayList<Carrera>();

    
    public Jornada(Date f){
        this.fecha= f;
        this.ultimaCerrada = 0;
        this.ultimaCerrada = 0;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Aquí están los Getters y Setters">
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getUltimoIdCarrera() {
        return ultimoIdCarrera;
    }

    public void setUltimoIdCarrera(int ultimoIdCarrera) {
        this.ultimoIdCarrera = ultimoIdCarrera;
    }

    public int getUltimaCerrada() {
        return ultimaCerrada;
    }

    public void setUltimaCerrada(int ultimaCerrada) {
        this.ultimaCerrada = ultimaCerrada;
    }

    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }
    // </editor-fold>       
    
}
