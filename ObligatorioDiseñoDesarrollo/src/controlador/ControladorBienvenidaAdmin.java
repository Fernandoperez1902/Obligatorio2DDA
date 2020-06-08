
package controlador;

import logica.Administrador;

public class ControladorBienvenidaAdmin {
    
    Administrador modelo;
    IVistaBienvenidaAdmin vista;
    
    public ControladorBienvenidaAdmin(Administrador modelo, IVistaBienvenidaAdmin vista){
        
        this.modelo = modelo;
        this.vista = vista;      
    }
    
    public void mostrarMensaje(){
        
        vista.mostrarDatos();
    }
    
    
}
