
package modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import observer.Observable;


public class Jornada extends Observable{

    private Date fecha;
    private int ultimoIdCarrera;
    private int ultimaCerrada;
    private ArrayList<Carrera> carreras = new ArrayList<Carrera>();

    public Jornada(Date f) {
        this.fecha = f;
        this.ultimoIdCarrera = 0;
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

    public enum Eventos{
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

    public void agregarCarrera(Carrera carrera) {

        carreras.add(carrera);
        avisar(Eventos.nuevaCarrera);
        ultimoIdCarrera++;
    }

    public Carrera traerProximaCarrera() {
        return carreras.get(ultimaCerrada++);
    }

    public Carrera buscarCarreraAbierta(){
        Carrera carrera = null;
        if (carreras.get(ultimaCerrada++).isAbierta()){
            carrera = carreras.get(ultimaCerrada++);
        }
        return carrera;
    }
}
