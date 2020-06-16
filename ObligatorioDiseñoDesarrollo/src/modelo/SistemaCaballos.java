
package modelo;

import java.util.ArrayList;

public class SistemaCaballos {
    private ArrayList<Caballo>caballos = new ArrayList<Caballo>();

    public ArrayList<Caballo> getCaballos() {
        return caballos;
    }
    
    public void AgregarCaballo(Caballo c){

        caballos.add(c);
    }
    
    
}
