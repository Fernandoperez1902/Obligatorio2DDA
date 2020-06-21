package controlador;

import java.util.Date;
import modelo.ApuestasException;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;
import modelo.Jornada;

public class ControladorCrearCarrera {

    private Fachada modeloFachada;
    private Hipodromo seleccionado;
    private IVistaCrearCarrera vista;

    public ControladorCrearCarrera(Hipodromo seleccionado,
            IVistaCrearCarrera vista) {

        this.modeloFachada = Fachada.getInstancia();
        this.seleccionado = seleccionado;
        this.vista = vista;
    }

    public void CrearCarrera(Date fecha, String nombre) {
        boolean esNuevaJornada = false;
            Jornada jornada = modeloFachada.buscarJornada(seleccionado, fecha);
            Carrera carrera;
            if (jornada != null) {
                carrera = new Carrera(nombre, fecha, jornada.getUltimoIdCarrera() + 1);
            } else {
                jornada = new Jornada(fecha);
                carrera = new Carrera(nombre, fecha, jornada.getUltimoIdCarrera() + 1);
                esNuevaJornada = true;
            }
            try {
                jornada.validarDatosCarrera(carrera);
                vista.mostrarProximaVista(jornada, seleccionado, carrera, esNuevaJornada);

            } catch (ApuestasException e) {
                vista.mostrarError(e.getMessage());
            }
    }
}
