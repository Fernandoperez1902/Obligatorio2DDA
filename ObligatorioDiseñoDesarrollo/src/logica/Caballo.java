/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Mauro
 */
public class Caballo {
    private String nombre;
    private String nombreResponsable;

    public Caballo(String n, String r){
        this.nombre= n;
        this.nombreResponsable = r;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Aquí están los Getters y Setters"> 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }
    // </editor-fold>


}
