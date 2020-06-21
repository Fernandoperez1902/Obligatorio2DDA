/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Jugador;

public interface IVistaConsultarSaldo {

    public void consultarSaldo(String usuario, String password);

    public void mostrarVistaSaldo(Jugador jugador);

    public void mostrarError(String message);
}
