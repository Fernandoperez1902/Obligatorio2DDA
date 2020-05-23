/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Mauro
 */
public class Fachada {
    
    private static Fachada instancia;
    
    private SistemaUsuario sU = new SistemaUsuario();
    
    public static Fachada getInstancia(){
        if (instancia ==null){
            instancia = new Fachada();
        }
        return instancia;
    }
    
    private Fachada(){}

    
    public Administrador loginAdministrador(String nombre, String password) {
        return sU.loginAdministrador(nombre, password);
    }

    public Jugador loginJugador(String nombre, String password) {
        return sU.loginJugador(nombre, password);
    }
    
    
    
    
    
}
