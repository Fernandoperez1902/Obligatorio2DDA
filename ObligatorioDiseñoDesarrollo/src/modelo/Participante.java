
package modelo;

import java.util.ArrayList;

public class Participante {
    private Caballo caballo;
    private Double dividendo;
    private int numero;
    private boolean ganador;
    private ArrayList<Apuesta> apuestas;
    private ModalidadApuesta tipoApuesta;


    public enum Eventos {cambiaModalidadApuesta};
    
    
    public Participante (Caballo c, int n, double d ){
        caballo=c;
        numero = n;
        dividendo = d;
        ganador = false;
        tipoApuesta = new Simple();
        apuestas = new ArrayList();
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

    public ModalidadApuesta getTipoApuesta() {
        return tipoApuesta;
    }

    public void setTipoApuesta(ModalidadApuesta tipoApuesta) {
        this.tipoApuesta = tipoApuesta;
        //aquí debería avisar el cambio de modalidad de apuesta asignado al participante.
    }
    
    // </editor-fold>

    @Override
    public String toString() {
        String ganador= "";
        if(this.ganador) ganador =" - GANADOR";
        return numero + " - "+caballo.getNombre() + " - " + dividendo + ganador;
    }
    
    public boolean caballoParticipa(Caballo cab){
        return caballo.equals(cab);
    }
    
    public String getNombreCaballo(){
        return caballo.getNombre();
    }
    
    public float montoApostadoSegunModalidad(float montoF) {
        return this.tipoApuesta.calcularMontoApostadoSegunModalidad(montoF);
    }

    public float montoGanadoSegunModalidad(float montoF) {
        return this.tipoApuesta.calcularGanancia(montoF, dividendo);
    }
    
    public float montoTotalPagado(){
        float monto = 0;
        for (Apuesta a : apuestas){
            monto += a.getMontoApostado();
        }
        return monto;
    }
    
    public float montoTotalApostado(){
        float monto = 0;
        for (Apuesta a : apuestas){
            monto += a.getMontoApostado();
        }
        return monto;
    }
    
}
