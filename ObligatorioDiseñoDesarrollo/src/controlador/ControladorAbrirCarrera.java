
package controlador;

import java.util.Date;
import modelo.Carrera;
import modelo.Hipodromo;
import modelo.Jornada;

public class ControladorAbrirCarrera {
    
    private Hipodromo seleccionado;
    private Carrera modeloCarrera;
    private IVistaAbrirCarrera vista;
    
    public ControladorAbrirCarrera(Hipodromo seleccionado, IVistaAbrirCarrera vista){
        
        this.seleccionado = seleccionado;
        this.vista = vista;
        this.modeloCarrera = seleccionado.buscarProximaCarreraDelDia();
        this.vista.mostrarCarrera(modeloCarrera);
        
    }
    
    public void abrirCarrera(){
        this.modeloCarrera.abrir();
    }
    
   
}
