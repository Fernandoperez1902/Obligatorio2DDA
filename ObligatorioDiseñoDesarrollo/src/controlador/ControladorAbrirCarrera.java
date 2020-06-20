
package controlador;

import modelo.Carrera;
import modelo.Hipodromo;

public class ControladorAbrirCarrera {
    
    private Hipodromo seleccionado;
    private Carrera modeloCarrera;
    private IVistaAbrirCarrera vista;
    
    public ControladorAbrirCarrera(Hipodromo seleccionado, IVistaAbrirCarrera vista){
        this.seleccionado = seleccionado;
        this.vista = vista;
        cargarCarrera();       
    }

    public void cargarCarrera(){      
        modeloCarrera = seleccionado.buscarProximaCarreraDelDia();
        if (modeloCarrera != null){
            vista.mostrarCarrera(modeloCarrera);
        } else {
            vista.mostrarError("No hay carreras para abrir");
            vista.cerrar();
        }
    }
   
    public void abrirCarrera(){
        modeloCarrera.abrir();
        vista.cerrar();
    }
    
}
