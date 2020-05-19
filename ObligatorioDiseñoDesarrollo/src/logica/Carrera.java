/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Mauro
 */
public class Carrera {
    private int numeroCarrera;
    private String nombre;
    private Date fecha;
    private ArrayList<Participante> participantes = new ArrayList<Participante>();
    private ArrayList<Apuesta> apuestas = new ArrayList<Apuesta>();

}
