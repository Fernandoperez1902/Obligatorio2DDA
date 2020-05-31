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
public class Carrera {

    private int numeroCarrera;
    private String nombre;
    private Date fecha;
    private ArrayList<Participante> participantes = new ArrayList<Participante>();
    private ArrayList<Apuesta> apuestas = new ArrayList<Apuesta>();
    private Estado estado;
    
    //SE DEFINE CLASE ESTADO COMO UN ENUM
    public enum Estado {definida,abierta,cerrada, finalizada};
    
    public Carrera(String n, Date f, ArrayList<Participante> p) {
        nombre = n;
        fecha = f;
        participantes = p;
        apuestas = null;
        estado = Estado.definida;
    }

    // <editor-fold defaultstate="collapsed" desc="Aquí están los Getters y Setters">
    public int getNumeroCarrera() {
        return numeroCarrera;
    }

    public void setNumeroCarrera(int numeroCarrera) {
        this.numeroCarrera = numeroCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }

    public void setApuestas(ArrayList<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    // </editor-fold>
    
    
    //Checkea si la carrera tiene apuestas efectuadas.
    public boolean tieneApuestas() {
        boolean ret = false;
        if (apuestas != null) {
            ret = true;
        }
        return ret;
    }

    //Valida que se trate de una fecha posterior a la actual
    public boolean validarFecha(Date f) {
        boolean ret = false;
        if (f.compareTo(new Date()) >= 0) {
            ret = true;
        }
        return ret;
    }

    @Override
    public String toString() {
        return numeroCarrera + " - " + nombre +  " - " + estado.toString();
    }
    
    public boolean isAbierta(){
        return this.estado.equals(Estado.abierta);
    }
       
}
