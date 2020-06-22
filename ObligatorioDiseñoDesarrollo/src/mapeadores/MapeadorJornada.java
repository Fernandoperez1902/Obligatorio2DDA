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
        return "SELECT *"
                + "FROM jornada j, carrera ca, participante p, caballo c "
                + "WHERE ca.oidJornada = j.oid AND"
                + "ca.oid = p.oidCarrera AND"
                + "p.oidCaballo = c.oid";
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
