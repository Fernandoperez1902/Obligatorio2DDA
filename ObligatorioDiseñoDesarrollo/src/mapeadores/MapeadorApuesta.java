package mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Apuesta;
import modelo.Fachada;
import modelo.Jugador;
import modelo.Participante;
import persistencia.Mapeador;

public class MapeadorApuesta implements Mapeador {

    private Apuesta apuesta;

    public MapeadorApuesta() {

    }

    public MapeadorApuesta(Apuesta obj) {
        this.apuesta = obj;
    }

    @Override
    public int getOid() {
        return apuesta.getOid();
    }

    @Override
    public void setOid(int oid) {
        apuesta.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsertar() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add(
                "insert into apuesta values(" + apuesta.getOid() + "," + apuesta.getJugador().getOid() + ","
                + apuesta.getParticipante().getOid() + "," + apuesta.getCarrera().getOid() + ","
                + apuesta.getMontoApostado() + "," + apuesta.getMontoPagado() + ","
                + apuesta.getMontoGanado() + ")"
        );
        cargarApuestaJugador(sqls);
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlActualizar() {
        throw new UnsupportedOperationException("");
    }

    @Override
    public ArrayList<String> getSqlBorrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlSeleccionar() {
        return "SELECT * FROM apuesta a, participante p WHERE a.oidParticipante = a.oid";
    }

    @Override
    public void crearNuevo() {
        apuesta = new Apuesta();
    }

    @Override
    public Object getObjeto() {
        return apuesta;
    }

    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
        Jugador jugador = Fachada.getInstancia().buscarJugador(rs.getInt("oidJugador"));
        //Participante participante = Fachada.getInstancia().buscarParticipante(rs.getInt("oidParticipante"));
        //Carrera carrera = Fachada.getInstancia().buscarCarrera(rs.getInt("oidCarrera"));
        apuesta.setJugador(jugador);
        //apuesta.setParticipante(participante);
        //apuesta.setCarrera(carrera);
        apuesta.setMontoApostado(rs.getFloat("montoApostado"));
        apuesta.setMontoPagado(rs.getFloat("montoPagado"));
        apuesta.setMontoGanado(rs.getFloat("montoGanado"));
        apuesta.setOid(rs.getInt("oid"));
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {

    }

    private void cargarApuestaJugador(ArrayList<String> sqls) {
        sqls.add("UPDATE jugador SET oidApuesta=" + apuesta.getOid() +
                " WHERE oidJugador=" + apuesta.getJugador().getOid());
    }

}
