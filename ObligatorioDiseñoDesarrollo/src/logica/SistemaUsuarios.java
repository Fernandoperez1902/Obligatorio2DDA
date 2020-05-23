/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author Mauro
 */
public class SistemaUsuarios {
 
    private ArrayList<Usuario>jugadores = new ArrayList<Usuario>();
    private ArrayList<Usuario>administradores = new ArrayList<Usuario>();
    
    
    private Usuario login(ArrayList<Usuario> usuarios, String nombre, String password) {
        Usuario ret = null;
        boolean encontrado = false;
        for(int i = 0; i<usuarios.size()&&!encontrado;i++){
            Usuario u = usuarios.get(i);
            if(u.verificarDatos(nombre,password)){
                ret = u;
                encontrado = true;
            }
        }
        return ret;
    }
    
    public Administrador loginAdministrador(String nombre, String password){
        Administrador ret = null;
        Usuario u = login(administradores,nombre,password);
        if (u!=null){
            ret = (Administrador)u;
        }
        return ret;
    }
    
    public Jugador loginJugador(String nombre, String password){
        Jugador ret = null;
        Usuario u = login(jugadores,nombre,password);
         if (u!=null){
            ret = (Jugador)u;
        }
        return ret;
    }
    
    public void agregarJugador(Jugador j){
        jugadores.add(j);
    }
}
