
package modelo;

public class Usuario {
    
    private String nombreUsuario;
    private String password;
    private String nombreCompleto;
    private int oid;

    public Usuario(String u, String p, String n){
        nombreUsuario=u;
        password = p;
        nombreCompleto = n;
    }
    
    public Usuario(){
        
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
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
