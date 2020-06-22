package mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Apuesta;
import modelo.Fachada;
import modelo.Jugador;
import modelo.Participante;
import persistencia.Mapeador;

public class MapeadorJugador implements Mapeador {

    private Jugador jugador;

    public MapeadorJugador() {

    }

    public MapeadorJugador(Jugador obj) {
        this.jugador = obj;
    }

    @Override
    public int getOid() {
        return jugador.getOid();
    }

    @Override
    public void setOid(int oid) {
        jugador.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsertar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getSqlActualizar() {
        ArrayList<String> sqls = new ArrayList<String>();
        sqls.add("UPDATE jugador SET oidApuesta=" + jugador.getUltimaApuesta().getOid()
                + " WHERE oidJugador=" + jugador.getOid());
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlBorrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlSeleccionar() {
        return "SELECT * FROM usuario u, jugador j WHERE u.oid = j.oidJugador";
    }

    @Override
    public void crearNuevo() {
        jugador = new Jugador();
    }

    @Override
    public Object getObjeto() {
        return jugador;
    }

    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
        jugador.setNombreUsuario(rs.getString("nombreUsuario"));
        jugador.setPassword(rs.getString("password"));
        jugador.setNombreCompleto(rs.getString("nombreCompleto"));
        jugador.setSaldo(rs.getFloat("saldo"));
        Apuesta a = Fachada.getInstancia().buscarApuesta(rs.getInt("oidApuesta"));
        if (a != null) {
            jugador.setUltimaApuesta(a);

        }
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {

    }

}
