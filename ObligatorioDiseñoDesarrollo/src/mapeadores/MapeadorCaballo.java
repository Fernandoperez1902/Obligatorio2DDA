
package mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Caballo;
import persistencia.Mapeador;


public class MapeadorCaballo implements Mapeador {
    
    private Caballo caballo;
    
    public MapeadorCaballo(){
        
    }
    
    public MapeadorCaballo(Caballo obj){
        this.caballo = obj;
    }
   
    @Override
    public int getOid() {
        return caballo.getOid();
    }

    @Override
    public void setOid(int oid) {
        caballo.setOid(oid);
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
        return "SELECT c.oid, c.nombreCaballo, c.nombreResponsable FROM caballo c";
    }

    @Override
    public void crearNuevo() {
        caballo = new Caballo();
    }

    @Override
    public Object getObjeto() {
        return caballo;
    }

    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
        caballo.setNombre(rs.getString("nombreCaballo"));
        caballo.setNombreResponsable(rs.getString("nombreResponsable"));
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        
    }
    
}
