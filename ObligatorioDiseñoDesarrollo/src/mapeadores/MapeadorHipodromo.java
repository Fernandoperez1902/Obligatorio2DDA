
package mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Hipodromo;
import modelo.Jugador;
import persistencia.Mapeador;


public class MapeadorHipodromo implements Mapeador {
    
    private Hipodromo hipodromo;
    
    public MapeadorHipodromo(){
        
    }
    
    public MapeadorHipodromo(Hipodromo obj){
        this.hipodromo = obj;
    }
   
    @Override
    public int getOid() {
        return hipodromo.getOid();
    }

    @Override
    public void setOid(int oid) {
        hipodromo.setOid(oid);
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
        return "SELECT h.oid, h.nombre, h.direccion FROM hipodromo h";
    }

    @Override
    public void crearNuevo() {
        hipodromo = new Hipodromo();
    }

    @Override
    public Object getObjeto() {
        return hipodromo;
    }

    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
        hipodromo.setNombre(rs.getString("nombre"));
        hipodromo.setDireccion(rs.getString("direccion"));
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        
    }
    
}
