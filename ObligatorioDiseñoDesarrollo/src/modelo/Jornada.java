package modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import observer.Observable;

public class Jornada extends Observable {

    private Date fecha;
    private int ultimoIdCarrera;
    private int ultima;
    private int oid;
    private ArrayList<Carrera> carreras = new ArrayList();
    private Hipodromo hipodromo;

    public Jornada(Date f, Hipodromo h) {
        this.fecha = f;
        this.ultimoIdCarrera = 0;
        this.hipodromo = h;
    }

    public Jornada() {

    }

    // <editor-fold defaultstate="collapsed" desc="Aquí están los Getters y Setters">
    public Hipodromo getHipodromo() {
        return hipodromo;
    }

    public void setHipodromo(Hipodromo hipodromo) {
        this.hipodromo = hipodromo;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

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
        return ultima;
    }

    public void setUltimaCerrada(int ultimaCerrada) {
        this.ultima = ultimaCerrada;
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

    public void agregarCarrera(Carrera carrera) throws ApuestasException {
        carrera.validarParticipantes();
        carreras.add(carrera);
        Fachada.getInstancia().guardarCarrera(this);
        avisar(Eventos.nuevaCarrera);
        ultimoIdCarrera++;
    }

    public Carrera traerProximaCarrera() {
        Carrera ret = null;
        Carrera actual = carreras.get(carreraActualPosicion());
        if (actual.isDefinida()) {
            ret = actual;
        }
        if (actual.isFinalizada() && carreraActualPosicion() < carreras.size()-1) {
            ret = carreras.get(carreraActualPosicion() + 1);
        }
        return ret;
    }

    public Carrera buscarCarreraAbierta() {
        Carrera ret = null;
        Carrera actual = carreras.get(carreraActualPosicion());
        if (actual.isAbierta()) {
            ret = actual;
        }
        return ret;
    }

    Carrera buscarUltimaCarreraCerrada() {
        Carrera ret = null;
        Carrera actual = carreras.get(carreraActualPosicion());
        if (actual.isCerrada()) {
            ret = actual;
        }
        return ret;
    }

    public boolean existeNombreCarrera(String nombre) {
        boolean existe = false;
        int i = 0;
        while (i < carreras.size() && !existe) {
            existe = carreras.get(i).getNombre().equals(nombre);
            i++;
        }
        return existe;
    }

    public void validarDatosCarrera(Carrera unaCarrera) throws ApuestasException {
        if (!unaCarrera.fechaValida()) {
            throw new ApuestasException("Fecha inválida");
        }
        if (existeNombreCarrera(unaCarrera.getNombre())) {
            throw new ApuestasException("Nombre inválido");
        }
    }

    public Carrera carreraActual() {
        Carrera ret = null;
        boolean encontre = false;
        for (int x = getCarreras().size() - 1; x >= 0 && !encontre; x--) {
            ret = carreras.get(x);
            encontre = (ret.isFinalizada() || ret.isAbierta() || ret.isCerrada());
        }
        return ret;
    }

    public int carreraActualPosicion() {
        Carrera c = null;
        int ret = 0;
        boolean encontre = false;
        for (int x = getCarreras().size() - 1; x >= 0 && !encontre; x--) {
            c = carreras.get(x);
            ret = x;
            encontre = (c.isFinalizada() || c.isAbierta() || c.isCerrada());
        }
        return ret;
    }
}
