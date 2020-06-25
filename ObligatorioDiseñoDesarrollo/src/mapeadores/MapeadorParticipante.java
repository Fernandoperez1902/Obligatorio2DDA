package mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Apuesta;
import modelo.Caballo;
import modelo.Carrera;
import modelo.Cuadruple;
import modelo.Fachada;
import modelo.ModalidadApuesta;
import modelo.Participante;
import modelo.Simple;
import modelo.Triple;
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
        ArrayList<String> sqls = new ArrayList();
        sqls.add(
                "insert into participante values(" + participante.getOid() + ","+ participante.getOid() +"," +participante.getCaballo().getOid() +","
                 + participante.getNumero() +"," + participante.getDividendo() + ",'" + participante.isGanador() +"')"
        );
        return sqls;
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
        ModalidadApuesta modalidad;
        switch (rs.getString("modalidad")) {
            case "triple":modalidad=new Triple();
            break;
            case "cuadruple" : modalidad = new Cuadruple();
            break;
            default:
                modalidad = new Simple();
        }
        //participante.setTipoApuesta(modalidad);
        participante.setApuestas(new ArrayList<Apuesta>());
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        
    }

}
