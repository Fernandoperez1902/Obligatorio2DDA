package mapeadores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Caballo;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Participante;
import persistencia.Mapeador;
import persistencia.Persistencia;

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
        sqls.add(
                "insert into carrera values(" +carrera.getOid()+ "," + carrera.getNumeroCarrera() + ","+carrera.getOid()
                +",'" + carrera.getEstado().toString() + "','" + carrera.getNombre() + "')"
        );
        generarParticipantes(sqls);
        return sqls;
    }

    @Override
    public ArrayList<String> getSqlActualizar() {
        ArrayList<String> sqls = new ArrayList();
        sqls.add(
                "delete from participante where oidCarrera = " + carrera.getOid()
        );
        return sqls;
        
    }

    @Override
    public ArrayList<String> getSqlBorrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlSeleccionar() {
        return "SELECT * FROM carrera";
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
            case "finalizada":
                estado = Carrera.Estado.finalizada;
                break;
            default:
                estado = Carrera.Estado.definida;
        }
        carrera.setEstado(estado);
        String filtro = "oidCarrera = "+ carrera.getOid();
        MapeadorParticipante mpp = new MapeadorParticipante();
        carrera.setParticipantes(Persistencia.getInstancia().buscar(mpp,filtro));
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
//        carrera.getParticipantes().add(
//                new Participante(
//                        new Caballo(rs.getString("nombreCaballo"),rs.getString("nombreResponsable")),
//                        rs.getInt("numeroParticipante"), 
//                        rs.getDouble("dividendo"), 
//                        rs.getBoolean("ganador"))
//        );
    }

    
    
    public void generarParticipantes(ArrayList<String> sqls) {
        ArrayList<Participante> participantes = carrera.getParticipantes();
        for (Participante p : participantes) {
            sqls.add(
                    "insert into participante values(" + p.getOid()+","+ carrera.getOid() + ","+ p.getCaballo().getOid()
                    + "," + p.getNumero() + "," + p.getDividendo() + "," + p.isGanador() +")"
            );
        }
    }

}
