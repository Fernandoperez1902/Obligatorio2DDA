
package mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Administrador;
import persistencia.Mapeador;


public class MapeadorAdministrador implements Mapeador {
    
    private Administrador administrador;
    
    public MapeadorAdministrador(){
        
    }
    
    public MapeadorAdministrador(Administrador obj){
        this.administrador = obj;
    }
   
    @Override
    public int getOid() {
        return administrador.getOid();
    }

    @Override
    public void setOid(int oid) {
        administrador.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsertar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getSqlActualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getSqlBorrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlSeleccionar() {
        return "SELECT u.oid, u.nombreUsuario, u.password, u.nombreCompleto FROM usuario u, administrador a WHERE u.oid = a.oidAdministrador";
    }

    @Override
    public void crearNuevo() {
        administrador = new Administrador();
    }

    @Override
    public Object getObjeto() {
        return administrador;
    }

    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
        administrador.setNombreUsuario(rs.getString("nombreUsuario"));
        administrador.setPassword(rs.getString("password"));
        administrador.setNombreCompleto(rs.getString("nombreCompleto"));
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        
    }
    
}
