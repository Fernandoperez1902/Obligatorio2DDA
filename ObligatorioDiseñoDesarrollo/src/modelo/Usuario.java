/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando
 */
public class Usuario {
    
    private String nombreUsuario;
    private String password;
    private String nombreCompleto;

    public Usuario(String u, String p, String n){
        nombreUsuario=u;
        password = p;
        nombreCompleto = n;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getPassword() {
        return password;
    }
    
    boolean verificarDatos(String n, String p) {
        return nombreUsuario.equals(n) && password.equals(p);
    }
    
}
