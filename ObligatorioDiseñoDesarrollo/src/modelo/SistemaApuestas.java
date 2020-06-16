
package modelo;

import java.util.ArrayList;

public class SistemaApuestas {
    private ArrayList<Apuesta>apuestas = new ArrayList<Apuesta>();

    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }

    public boolean agregarApuesta(Apuesta a) {
        return apuestas.add(a);
    }

    
}
