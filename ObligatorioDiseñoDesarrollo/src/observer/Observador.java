/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

/**
 *
 * @author Fernando
 */
public interface Observador {

    public void actualizar(Observable origen, Object evento);
}
