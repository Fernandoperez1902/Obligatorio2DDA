package modelo;

import java.util.ArrayList;
import java.util.Date;
import observer.Observable;
import utilidades.ManejoDeFechas;

public class Carrera extends Observable {

    private int numeroCarrera;
    private String nombre;
    private Date fecha;
    private ArrayList<Participante> participantes = new ArrayList<Participante>();
    private Estado estado;
    private int oid;
    private Hipodromo hipodromo;

    public Hipodromo getHipodromo() {
        return hipodromo;
    }

    public void setHipodromo(Hipodromo hipodromo) {
        this.hipodromo = hipodromo;
    }

    //SE DEFINE ESTADO COMO UN ENUM
    public enum Estado {
        definida, abierta, cerrada, finalizada
    };

    public enum Eventos {
        abrir, cerrar, finalizar, crear
    };

    public Carrera() {

    }

    public Carrera(String nom, Date fec, int num, Hipodromo h) {
        nombre = nom;
        fecha = fec;
        numeroCarrera = num;
        hipodromo = h;
        estado = Estado.definida;
    }

    //METODO UTILIZADO ÚNICAMENTE POR LA CARGA DE DATOS
    public Carrera(String n, Date f, int numero, ArrayList<Participante> p) {
        nombre = n;
        fecha = f;
        participantes = p;
        numeroCarrera = numero;
        estado = Estado.definida;
    }

    // <editor-fold defaultstate="collapsed" desc="Aquí están los Getters y Setters">
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

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

    public ArrayList<Participante> participantesSinApuestas() {
        ArrayList<Participante> sinApuestas = new ArrayList();
        for (Participante p : participantes) {
            if (!p.tieneApuestas()) {
                sinApuestas.add(p);
            }
        }
        return sinApuestas;
    }

    //VERIFICA SI SE TRATA DE UNA CARRERA ABIERTA
    public boolean isAbierta() {
        return this.estado.equals(Estado.abierta);
    }

    //VERIFICA SI SE TRATA DE UNA CARRERA ABIERTA
    public boolean isCerrada() {
        return this.estado.equals(Estado.cerrada);
    }

    //VERIFICA SI SE TRATA DE UNA CARRERA FINALIZADA
    public boolean isFinalizada() {
        return this.estado.equals(Estado.finalizada);
    }

    //VERIFICA SI SE TRATA DE UNA CARRERA DEFINIDA
    public boolean isDefinida() {
        return this.estado.equals(Estado.definida);
    }

    //VERIFICA LA PARTICIPACIÓN DE UN CABALLO EN LA ACTUAL CARRERA
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

    public boolean fechaValida() {
        return !fecha.before(ManejoDeFechas.tomarFechaSistemaSinHora());
    }

    //MÉTODO PARA ABRIR UNA CARRERA
    public void abrir() {
        estado = Estado.abierta;
        hipodromo.avisar(Eventos.abrir);
    }

    //MÉTODO PARA CERRAR UNA CARRERA
    public void cerrar() {
        estado = Estado.cerrada;
        this.avisar(Eventos.cerrar);
        hipodromo.avisar(Eventos.cerrar);
    }

    //MÉTODO PARA FINALIZAR UNA CARRERA
    public void finalizar() {
        estado = Estado.finalizada;
        this.avisar(Eventos.finalizar);
        hipodromo.avisar(Eventos.finalizar);
    }

    //MÉTODO PARA AGREGAR UN NUEVO CABALLO PARTICIPANTE A LA CARRERA
    public void agregarParticipante(Participante p) {
        participantes.add(p);
//        Fachada.getInstancia().guardarParticipante(this);
    }

    //DEVUELVE LA CANTIDAD DE PARTICIPANTES DE LA CARRERA
    public int cantidadParticipantes() {
        return getParticipantes().size();
    }

    //CALCULA MONTO TOTAL APOSTADO INGRESADO POR LOS JUGADORES POR LA APUESTAS REALIZADAS
    public float montoTotalApostado() {
        float monto = 0;
        for (Participante p : participantes) {
            monto += p.montoTotalApostado();
        }
        return monto;
    }

    //CALCULA MONTO TOTAL EFECTIVAMENTE DESCONTADO A LOS JUGADORES POR LA APUESTAS REALIZADAS
    public float montoTotalPagado() {
        float ret = 0;
        for (Participante p : participantes) {
            ret += p.montoTotalPagado();
        }
        return ret;
    }

    //CALCULA MONTO TOTAL GANADO POR LOS JUGADORES EN SUS APUESTAS EN LA PRESENTE CARRERA
    public float montoTotalGanado() {
        float monto = 0;
        if (this.estado.equals(Estado.finalizada)) {
            for (Participante p : participantes) {
                monto += p.montoTotalGanado();
            }
        }
        return monto;
    }

    //MÉTODO QUE DEVUELVE LAS APUESTAS GANADORAS EN LA ACTUAL CARRERA
    public ArrayList<Apuesta> getApuestasGanadoras() {
        ArrayList<Apuesta> apuestas = null;
        for (Participante p : participantes) {
            if (p.isGanador()) {
                apuestas = p.getApuestas();
            }
        }
        return apuestas;
    }

    //VALIDA LA UNICIDAD DE NÚMERO DE PARTICIPANTE EN LA CARRERA
    public boolean existeMismoNumeroDeParticipante(int numero) {
        boolean existe = false;
        int i = 0;
        while (i < participantes.size() && !existe) {
            existe = participantes.get(i).getNumero() == numero;
            i++;
        }
        return existe;
    }

    //VALIDACIONES NECESARIAS DE PARTICIPANTES PARTICIPANTE DE UNA CARRERA
    public void validarParticipante(Participante participante) throws ApuestasException {
        if (!participante.numeroValido() || existeMismoNumeroDeParticipante(participante.getNumero())) {
            throw new ApuestasException("Numero de caballo inválido");
        }
        if (!participante.dividendoValido()) {
            throw new ApuestasException("El dividendo debe ser mayor que 1");
        }
    }

    //VALIDA LA CANTIDAD MÍNIMA DE DOS PARTICIPANTES EN UNA CARRERA
    public void validarParticipantes() throws ApuestasException {
        if (participantes.size() < 2) {
            throw new ApuestasException("Debe seleccionar al menos 2 caballos participantes");
        }
    }

}
