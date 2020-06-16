
package modelo;

public class Caballo {
    private String nombre;
    private String nombreResponsable;

    public Caballo(String n, String r){
        this.nombre= n;
        this.nombreResponsable = r;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Aquí están los Getters y Setters"> 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }
    // </editor-fold>

    
    @Override
    public String toString() {
        return nombre + " - Responsable: " + nombreResponsable;
    }
    
    //Valida la condición de unicidad en el nombre
    public boolean validarCaballo(String nombre){
        //habría que incorporar Exceptions
        return this.nombre==nombre;
    }
}
