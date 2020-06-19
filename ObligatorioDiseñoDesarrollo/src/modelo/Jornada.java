package modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import observer.Observable;

public class Jornada extends Observable {

    private Date fecha;
    private int ultimoIdCarrera;
    private int ultimaCerrada;
    private ArrayList<Carrera> carreras = new ArrayList();

    public Jornada(Date f) {
        this.fecha = f;
        this.ultimoIdCarrera = 0;
        this.ultimaCerrada = -1;
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

    public enum Eventos {

        nuevaCarrera
    };

    public boolean esJornadaDelDia(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(this.fecha).equals(sdf.format(fecha));
    }

    public boolean participaEnCarrera(Caballo cab) {
        boolean participa = false;
        int i = 0;
        while (i < carreras.size() && !participa) {
            if (carreras.get(i).participaCaballo(cab)) {
                participa = true;
            }
            i++;
        }
        return participa;
    }

    public void agregarCarrera(Carrera carrera) throws ApuestasException{
        carrera.validarParticipantes();
        carreras.add(carrera);
        avisar(Eventos.nuevaCarrera);
        ultimoIdCarrera++;
    }

    public Carrera traerProximaCarrera() {
        return carreras.get(ultimaCerrada + 1);
    }

    public Carrera buscarCarreraAbierta() {
        Carrera carrera = null;
        if (carreras.get(ultimaCerrada + 1).isAbierta()) {
            carrera = carreras.get(ultimaCerrada + 1);
        }
        return carrera;
    }

    Carrera buscarUltimaCarreraCerrada() {
        Carrera ultCerrada = carreras.get(ultimaCerrada);
        if (!ultCerrada.isFinalizada()) {
            return carreras.get(ultimaCerrada);
        } else {
            return null;
        }
    }
    
    public boolean existeNombreCarrera(String nombre){
        boolean existe = false;
        int i = 0;
        while (i < carreras.size() && !existe){
            existe = carreras.get(i).getNombre().equals(nombre);           
            i++;
        }
        return existe;
    }
    
    public void validarDatosCarrera(Carrera unaCarrera) throws ApuestasException{
        if (!unaCarrera.fechaValida()){
            throw new ApuestasException("Fecha inválida");
        }
        if (existeNombreCarrera(unaCarrera.getNombre())){
            throw new ApuestasException("Nombre inválido");
        }
    }

    public void actualizarUltimaCerrada() {
        ultimaCerrada++;
    }
}
