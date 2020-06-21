package mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Caballo;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Participante;
import persistencia.Mapeador;

public class MapeadorCarrera implements Mapeador {

    private Carrera carrera;

    @Override
    public int getOid() {
        return carrera.getOid();
    }

    @Override
    public void setOid(int oid) {
        carrera.setOid(oid);
    }

    public MapeadorCarrera() {

    }

    public MapeadorCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public ArrayList<String> getSqlInsertar() {
        ArrayList<String> sqls = new ArrayList();
        java.sql.Timestamp fecha = new java.sql.Timestamp(carrera.getFecha().getTime());
        sqls.add(
                "insert into carrera values(" + carrera.getNumeroCarrera() + "," + carrera.getOid()
                + "," + fecha + "," + carrera.getEstado() + "," + carrera.getNombre() + ")"
        );

        generarParticipantes(sqls);
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlActualizar() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add(
                "delete from carrera where oid = " + carrera.getOid()
        );
        java.sql.Timestamp fecha = new java.sql.Timestamp(carrera.getFecha().getTime());
        sqls.add(
                "insert into carrera values(" + carrera.getNumeroCarrera() + "," + carrera.getOid()
                + "," + fecha + "," + carrera.getEstado() + "," + carrera.getNombre() + ")"
        );
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlBorrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlSeleccionar() {
        return "SELECT * FROM carrera c,participante p, caballo ca, apuesta a"
                + "WHERE c.oid = p.oidCarrera AND p.oidCaballo = ca.oid AND"
                + "a.oidParticipante = p.oid";
    }

    @Override
    public void crearNuevo() {
        carrera = new Carrera();
    }

    @Override
    public Object getObjeto() {
        return carrera;
    }

    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
        carrera.setNumeroCarrera(rs.getInt("numeroCarrera"));
        carrera.setNombre(rs.getString("nombreCarrera"));
        Carrera.Estado estado;
        switch (rs.getString("estado")) {
            case "abierta":
                estado = Carrera.Estado.abierta;
                break;
            case "cerrada":
                estado = Carrera.Estado.cerrada;
                break;
            case "definida":
                estado = Carrera.Estado.definida;
                break;
            case "finalizada":
                estado = Carrera.Estado.finalizada;
                break;
            default:
                estado = Carrera.Estado.definida;
        }
        carrera.setEstado(estado);
        carrera.setFecha(rs.getTimestamp("fechaCarrera"));
        carrera.setOid(rs.getInt("oid"));
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        carrera.getParticipantes().add(new Participante(new Caballo(rs.getString("nombreCaballo"), rs.getString("nombreResponsable")),
                rs.getInt("numeroParticipante"), rs.getDouble("dividendo"), rs.getBoolean("ganador"))
        );
    }

    public void generarParticipantes(ArrayList<String> sqls) {
        ArrayList<Participante> participantes = carrera.getParticipantes();
        for (Participante p : participantes) {
            sqls.add(
                    "insert into participante values(" + carrera.getOid() + ",'"
                    + p.getNumero() + "'," + p.getDividendo() + "'," + p.isGanador() + ",'"
                    + p.getOid() + "','" + p.getCaballo().getOid() + "')"
            );
        }
    }

}
