package mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Caballo;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Participante;
import persistencia.Mapeador;

public class MapeadorParticipante implements Mapeador {

    private Participante participante;

    @Override
    public int getOid() {
        return participante.getOid();
    }

    @Override
    public void setOid(int oid) {
        participante.setOid(oid);
    }

    public MapeadorParticipante() {

    }

    public MapeadorParticipante(Participante participante) {
        this.participante = participante;
    }

    @Override
    public ArrayList<String> getSqlInsertar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates
    }

    @Override
    public ArrayList<String> getSqlActualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates
    }

    @Override
    public ArrayList<String> getSqlBorrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlSeleccionar() {
        return "SELECT * FROM participante";
    }

    @Override
    public void crearNuevo() {
        participante = new Participante();
    }

    @Override
    public Object getObjeto() {
        return participante;
    }

    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
        participante.setNumero(rs.getInt("numeroParticipante"));
        participante.setGanador(rs.getBoolean("ganador"));
        participante.setDividendo(rs.getDouble("dividendo"));
        Caballo c = Fachada.getInstancia().buscarCaballo(rs.getInt("oidCaballo"));
        participante.setCaballo(c);
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        
    }

}
