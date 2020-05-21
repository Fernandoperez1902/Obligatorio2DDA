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
public class Participante {
    private Caballo caballo;
    private Double dividendo;
    private int numero;
    private boolean ganador;

    public Participante (Caballo c, double d, int n){
        caballo=c;
        dividendo = d;
        numero = n;
        ganador = false;
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Aquí están los Getters y Setters">
    public Caballo getCaballo() {
        return caballo;
    }

    public void setCaballo(Caballo caballo) {
        this.caballo = caballo;
    }

    public Double getDividendo() {
        return dividendo;
    }

    public void setDividendo(Double dividendo) {
        this.dividendo = dividendo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isGanador() {
        return ganador;
    }

    public void setGanador(boolean ganador) {
        this.ganador = ganador;
    }
    // </editor-fold>
    
}
