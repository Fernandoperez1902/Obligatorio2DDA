package modelo;

import java.util.ArrayList;
import mapeadores.MapeadorApuesta;
import mapeadores.MapeadorHipodromo;
import persistencia.Persistencia;

public class SistemaApuestas {

    private ArrayList<Apuesta> apuestas = new ArrayList<Apuesta>();
    private ArrayList<ModalidadApuesta> modalidades = new ArrayList();

    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }

    public ArrayList<ModalidadApuesta> getModalidadades() {
        return modalidades;
    }

    public boolean agregarApuesta(Apuesta a) {
        return apuestas.add(a);
    }

    public void agregarModalidad(ModalidadApuesta modalidad) {
        modalidades.add(modalidad);
    }

    public void cargarApuesta() {
        MapeadorApuesta mtc = new MapeadorApuesta();
        ArrayList<Apuesta> lista = Persistencia.getInstancia().obtenerTodos(mtc);
        for (Apuesta a : lista) {
            this.agregarApuesta(a);
        }
    }

    void guardarApuesta(Apuesta a) {
        MapeadorApuesta mA = new MapeadorApuesta(a);
        Persistencia.getInstancia().guardar(mA);
    }
}
