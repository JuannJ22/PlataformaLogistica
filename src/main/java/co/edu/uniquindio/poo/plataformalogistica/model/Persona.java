package co.edu.uniquindio.poo.plataformalogistica.model;

public class Persona {

    protected String nombre;
    protected String ID;

    public Persona(String nombre, String ID) {
        this.nombre = nombre;
        this.ID = ID;
    }
    public String getNombre() {
        return nombre;

    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getID() {
        return ID;

    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String toString() {
        return nombre + " " + ID;
    }
}
