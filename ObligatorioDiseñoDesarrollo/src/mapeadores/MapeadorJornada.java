
package mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Carrera;
import modelo.Jornada;
import persistencia.Mapeador;

public class MapeadorJornada implements Mapeador{

    private Jornada jornada;
    
    @Override
    public int getOid() {
        return jornada.getOid();
    }

    @Override
    public void setOid(int oid) {
        jornada.setOid(oid);
    }

    public MapeadorJornada(){
        
    }
    
    public MapeadorJornada(Jornada jornada){
        this.jornada = jornada;
    }
    
    @Override
    public ArrayList<String> getSqlInsertar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getSqlActualizar() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add(
                "delete from carreras where oidJornada = " + jornada.getOid()
        );
        generarCarreras(sqls);
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlBorrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlSeleccionar() {
        return "SELECT * FROM jornada j,carrera c WHERE j.oid=c.oidjornada"; 
    }

    @Override
    public void crearNuevo() {
        jornada = new Jornada();
    }

    @Override
    public Object getObjeto() {
        return jornada;
    }

    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
        jornada.setFecha(rs.getDate("fechaCarrera"));
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        jornada.getCarreras().add(new Carrera(
                rs.getString("nombre"),
                rs.getDate("fechaCarrera"),
                rs.getInt("numero"))
        );
    }

    private void generarCarreras(ArrayList<String> sqls) {
        ArrayList<Carrera> carreras = jornada.getCarreras();
        for (Carrera c : carreras) {
            java.sql.Timestamp fecha = new java.sql.Timestamp(c.getFecha().getTime());
            sqls.add(
                    "insert into jornada values (" + c.getNumeroCarrera() + "," + c.getOid() + "," + jornada.getOid() +
                            "'" + fecha + "'," + "," + c.getEstado() + c.getNombre() + ")"
            );
        }
    }
    
}
