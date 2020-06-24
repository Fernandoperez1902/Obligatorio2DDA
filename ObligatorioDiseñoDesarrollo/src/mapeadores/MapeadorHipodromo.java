package mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ApuestasException;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;
import modelo.Jornada;
import persistencia.Mapeador;
import persistencia.Persistencia;

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
//        String filtro = "oidHipodromo = " + rs.getString("oid");
//        MapeadorJornada mpj = new MapeadorJornada();
//        hipodromo.setJornadas(Persistencia.getInstancia().buscar(mpj, filtro));
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
//        Jornada j= new Jornada ();
//        j.setFecha(rs.getDate("fechaJornada"));
//        Carrera c = new Carrera();
//        c.setNombre(rs.getString("nombreCarrera"));
//        c.setNumeroCarrera(rs.getInt("numeroCarrera"));
//        Carrera.Estado estado;
//        switch (rs.getString("estado")) {
//            case "abierta":
//                estado = Carrera.Estado.abierta;
//                break;
//            case "cerrada":
//                estado = Carrera.Estado.cerrada;
//                break;
//            case "finalizada":
//                estado = Carrera.Estado.finalizada;
//                break;
//            default:
//                estado = Carrera.Estado.definida;
//        }
//        c.setEstado(estado);
//        j.getCarreras().add(c);
//        hipodromo.getJornadas().add(j);
//        hipodromo.setJornadas(hipodromo.getJornadas());
         
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
