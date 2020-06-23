package mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;
import modelo.Jornada;
import persistencia.Mapeador;
import persistencia.Persistencia;

public class MapeadorJornada implements Mapeador {

    private Jornada jornada;

    @Override
    public int getOid() {
        return jornada.getOid();
    }

    @Override
    public void setOid(int oid) {
        jornada.setOid(oid);
    }

    public MapeadorJornada() {

    }

    public MapeadorJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    @Override
    public ArrayList<String> getSqlInsertar() {
        ArrayList<String> sqls = new ArrayList();
        Timestamp fecha = new Timestamp(jornada.getFecha().getTime());
        sqls.add(
                "insert into jornada values(" + jornada.getOid() + ",'" + fecha + "'," + jornada.getHipodromo().getOid() + ")"
        );
        generarCarreras(sqls);
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlActualizar() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add(
                "delete from carrera where oidJornada = " + jornada.getOid()
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
        return "SELECT * FROM jornada ";
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
        jornada.setFecha(rs.getDate("fechaJornada"));
        //jornada.setHipodromo(Fachada.getInstancia().buscarHipodromo(rs.getInt("oidHipodromo")));
//        String filtro = "oidJornada = "+ jornada.getOid();
//        MapeadorCarrera mpc = new MapeadorCarrera();
//        jornada.setCarreras(Persistencia.getInstancia().buscar(mpc,filtro));
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
 

    }

    private void generarCarreras(ArrayList<String> sqls) {
        ArrayList<Carrera> carreras = jornada.getCarreras();
        for (Carrera c : carreras) {
            Fachada.getInstancia().guardarParticipante(c);
        }
    }
}
