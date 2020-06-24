package modelo;

import java.util.ArrayList;

public class Participante {

    private Caballo caballo;
    private Double dividendo;
    private int numero;
    private boolean ganador;
    private Carrera carrera;
    private ArrayList<Apuesta> apuestas;
    private ModalidadApuesta tipoApuesta;
    private int oid;

    public enum Eventos {
        cambiaModalidadApuesta
    };

    public Participante() {

    }

    public Participante(Caballo c, int n, double d, boolean g, Carrera car) {
        caballo = c;
        numero = n;
        dividendo = d;
        ganador = false;
        carrera = car;
        tipoApuesta = new Simple();
        apuestas = new ArrayList();
    }

    // <editor-fold defaultstate="collapsed" desc="Aquí están los Getters y Setters">
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

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
        if (ganador) {
            pagarApuestas();
        }
    }

    public ModalidadApuesta getTipoApuesta() {
        return tipoApuesta;
    }

    
    
    public void setTipoApuesta(ModalidadApuesta tipoApuesta) {
        this.tipoApuesta = tipoApuesta;
        carrera.avisar(Eventos.cambiaModalidadApuesta);
        //aquí debería avisar el cambio de modalidad de apuesta asignado al participante.
    }

    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }

    public void setApuestas(ArrayList<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }

    // </editor-fold>
    @Override
    public String toString() {
        String ganador = "";
        if (this.ganador) {
            ganador = " - GANADOR";
        }
        return numero + " - " + caballo.getNombre() + " - " + dividendo + ganador;
    }
    
    //verifica la participación de un caballo
    public boolean caballoParticipa(Caballo cab) {
        return caballo.equals(cab);
    }

    //Valida número de Caballo
    public boolean numeroValido() {
        return (numero <= 99999 && numero >= 1);
    }
    //Valida dividendo de paga de un caballo
    public boolean dividendoValido() {
        return (dividendo > (double) 1);
    }

    //Devuelve nombre del caballo asignado a este participante
    public String getNombreCaballo() {
        return caballo.getNombre();
    }

    //Calcula lo descontado a un Jugador con una apuesta efectuada
    public float montoPagadoSegunModalidad(float montoF) {
        return this.tipoApuesta.calcularMontoPagadoSegunModalidad(montoF);
    }

    //Calcula la recompensa de una apuesta ganadora.
    public float montoGanadoSegunModalidad(float montoF) {
        return this.tipoApuesta.calcularMontoGananciaSegunModalidad(montoF, dividendo, montoTotalPagado());
    }

    //Monto total pagado por los jugadores en esta carrera para este participante
    public float montoTotalPagado() {
        float monto = 0;
        for (Apuesta a : apuestas) {
            monto += a.getMontoPagado();
        }
        return monto;
    }

    //Monto total apostado sin evaluar la modalidad de apuesta del participante
    public float montoTotalApostado() {
        float monto = 0;
        for (Apuesta a : apuestas) {
            monto += a.getMontoApostado();
        }
        return monto;
    }
    
    //Monto total ganado por los jugadores en esta carrera
    public float montoTotalGanado() {
        float monto = 0;
        for (Apuesta a : apuestas) {
            monto += a.getMontoGanado();
        }
        return monto;
    }

    //Verifica si el participante tiene apuestas efectuadas
    public boolean tieneApuestas() {
        return !apuestas.isEmpty();
    }

    //Agrega apuestas al participante
    public void agregarApuesta(Apuesta a) {
        Fachada.getInstancia().guardarApuesta(a);
        apuestas.add(a);
    }

    //Método para pagar apuestas ganadoras
    public void pagarApuestas() {
        for (Apuesta a : apuestas) {
            float loGanado = montoGanadoSegunModalidad(a.getMontoApostado());
            a.pagarApuestaJugador(loGanado);
        }
    }
    
    public String getModalidad() {
        return tipoApuesta.tipoModalidad();
    }

}
