
package modelo;

import java.util.ArrayList;
import java.util.Date;
import observer.Observable;

public class Carrera extends Observable {

    private int numeroCarrera;
    private String nombre;
    private Date fecha;
    private ArrayList<Participante> participantes = new ArrayList<Participante>();
    private Estado estado;

    public enum ErrorValidacion {

        participantesInsuficientes, carreraOk
    };

    //SE DEFINE CLASE ESTADO COMO UN ENUM
    public enum Estado {

        definida, abierta, cerrada, finalizada
    };

    public enum Eventos {
        abrir, cerrar, finalizar
    };

    public Carrera(String nom, Date fec, int num) {
        nombre = nom;
        fecha = fec;
        numeroCarrera = num;
        estado = Estado.definida;
    }

    public Carrera(String n, Date f, int numero, ArrayList<Participante> p) {
        nombre = n;
        fecha = f;
        participantes = p;
        numeroCarrera = numero;
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
        for(Participante p : participantes){
            if (p.tieneApuestas()){
                ret = true;
            }
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
        return numeroCarrera + " - " + nombre + " - " + estado.toString();
    }

    public boolean isAbierta() {
        return this.estado.equals(Estado.abierta);
    }

    public boolean isFinalizada() {
        return this.estado.equals(Estado.finalizada);
    }

    public boolean participaCaballo(Caballo cab) {

        boolean participa = false;
        int i = 0;
        while (i < participantes.size() && !participa) {
            if (participantes.get(i).caballoParticipa(cab)) {
                participa = true;
            }
            i++;
        }
        return participa;
    }

    public Enum validarCarrera() {
        if (participantes.size() < 2) {
            return ErrorValidacion.participantesInsuficientes;
        } else {
            return ErrorValidacion.carreraOk;
        }
    }

    public void abrir() {
        estado = Estado.abierta;
        this.avisar(Eventos.abrir);
    }

    public void cerrar() {
        estado = Estado.cerrada;
        this.avisar(Eventos.cerrar);
    }

    public void finalizar(){
        estado = Estado.finalizada;
        this.avisar(Eventos.finalizar);
    }

    public void agregarParticipante(Participante p) {
        participantes.add(p);
    }

    public int cantidadParticipantes() {
        return getParticipantes().size();
    }

    public float montoTotalPagado() {
        float ret = 0;
        if(this.estado.equals(Estado.finalizada)){
            for (Participante p : participantes) {
                ret += p.montoTotalPagado();
            }
        }
        return ret;
    }

    public float montoTotalApostado(){
        float monto = 0;
        for (Participante p : participantes){
            monto += p.montoTotalApostado();
        }
        return monto;
    }

    public ArrayList<Apuesta> getApuestasGanadoras(){
        ArrayList<Apuesta>apuestas = null;
        for (Participante p : participantes){
            if(p.isGanador()){
                apuestas = p.getApuestas();
            }
        }
        return apuestas;
    }
}
