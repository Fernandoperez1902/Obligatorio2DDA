package controlador;

import modelo.Carrera;
import modelo.Hipodromo;
import modelo.Jornada;

public interface IVistaCrearCarrera {

    public void mostrarProximaVista(Jornada jornada, Hipodromo hipodromo,
            Carrera carrera, boolean esNuevaJornada);
    
}
