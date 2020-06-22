package mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import modelo.Hipodromo;
import modelo.Jornada;
import persistencia.Mapeador;

public class MapeadorHipodromo implements Mapeador {

    private Hipodromo hipodromo;

    public MapeadorHipodromo() {

    }

    public MapeadorHipodromo(Hipodromo obj) {
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
        ArrayList<String> sqls = new ArrayList();
        sqls.add(
                "insert into hipodromo values(" + hipodromo.getOid() + ",'" + hipodromo.getNombre() + "','" + hipodromo.getDireccion()+ "')"
        );
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlActualizar() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add(
                "delete from jornada where oid = " + hipodromo.getOid()
        );
        //generarJornadas(sqls);
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlBorrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlSeleccionar() {
        return "SELECT * FROM hipodromo";

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
        //hipodromo.setOid(rs.getInt("oid"));
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {

    }

    private void generarJornadas(ArrayList<String> sqls) {
        ArrayList<Jornada> jornadas = hipodromo.getJornadas();
        for (Jornada j : jornadas) {
            Timestamp fecha = new Timestamp(new Date().getTime());
            sqls.add(
                    "insert into jornada values (" + j.getOid() + "," + "'" + fecha + "'," + hipodromo.getOid() + ")"
            );
        }
    }

}
