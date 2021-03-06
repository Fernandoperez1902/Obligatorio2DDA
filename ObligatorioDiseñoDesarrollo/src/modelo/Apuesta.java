 package modelo;

public class Apuesta {

    private Jugador jugador;
    private Participante participante;
    private Carrera carrera;
    private float montoApostado;
    private float montoPagado;
    private float montoGanado;
    private int oid;

    public Apuesta(Jugador jugador, Participante participante, float montoApostado, Carrera carrera) {
        this.jugador = jugador;
        this.participante = participante;
        this.carrera = carrera;
        this.montoApostado = montoApostado;
        this.montoPagado = participante.montoPagadoSegunModalidad(montoApostado);
        this.montoGanado = 0;
    }
    
    public Apuesta(){
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Aquí están los Getters y Setters">

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }
    
    public float getMontoApostado() {
        return montoApostado;
    }

    public void setMontoApostado(float montoApostado) {
        this.montoApostado = montoApostado;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public float getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(float montoPagado) {
        this.montoPagado = montoPagado;
    }

    public float getMontoGanado() {
        return montoGanado;
    }

    public void setMontoGanado(float montoGanado) {
        this.montoGanado = montoGanado;
    }
    
    
    // </editor-fold> 

    //Paga las ganancias correspondientes al Jugador
    public void pagarApuestaJugador(float montoGanado) {
        setMontoGanado(montoGanado);
       jugador.actualizarSaldo(montoGanado+montoPagado); //Se acredita lo ganado y devuelve lo apostado  
    }

}
