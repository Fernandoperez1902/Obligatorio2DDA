/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Carrera;
import modelo.Hipodromo;
import modelo.Participante;

/**
 *
 * @author Mauro
 */
public interface IVistaRealizarApuestas {

    public void cargarHipodromos(ArrayList<Hipodromo> hipodromos);

    public void cargarCarrera(Carrera carrera);

    public void cargarParticipantes(ArrayList<Participante> participantes);

    public void habilitarBotonApuesta(boolean habilitar);

    public void mostrarError(String message);

    public void limpiarFormulario();

    public void mostrarMensajeExito();

    public void actualizarLista();
}
