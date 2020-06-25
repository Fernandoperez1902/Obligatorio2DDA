
package modelo;

public class Caballo {
    
    private int oid;
    private String nombre;
    private String nombreResponsable;

    public Caballo(String n, String r){
        this.nombre= n;
        this.nombreResponsable = r;
    }
    
    public Caballo(){
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Aquí están los Getters y Setters"> 

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    } 
    
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
        return this.nombre==nombre;
    }
}
