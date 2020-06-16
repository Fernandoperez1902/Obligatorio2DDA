
package controlador;

import java.util.ArrayList;
import modelo.Hipodromo;

public interface IVistaMenuAdministrador {

    public String formatear(Hipodromo hip);

    public void mostrarHipodromos(ArrayList<Hipodromo> hipodromos);

    public void llamarCrearCarrera(Hipodromo hip);

    public void llamarAbrirCarrera(Hipodromo hip);

    public void llamarCerrarApuestas(Hipodromo hip);
      
    public void llamarMonitorearCarrera(Hipodromo hip);
}
