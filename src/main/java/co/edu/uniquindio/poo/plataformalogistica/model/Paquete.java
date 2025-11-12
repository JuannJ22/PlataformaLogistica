package co.edu.uniquindio.poo.plataformalogistica.model;

public class Paquete {

    private String ID;
    private String nombre;
    private String dimension;
    private double peso;

    /**
     * Conatructor
     * @param ID
     * @param nombre
     * @param dimension
     * @param peso
     */

    public Paquete(String ID, String nombre, String dimension, double peso) {
        this.ID= ID;
        this.nombre = nombre;
        this.dimension = dimension;
        this.peso = peso;
    }

    //GETTER Y SETTER

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID=ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    //TO STRING

    public void mostrarInfo() {
        System.out.println("=== Paquete ===");
        System.out.println("ID: " + ID);
        System.out.println("Nombre: " + nombre);
        System.out.println("Dimensión: " + dimension);
        System.out.println("Peso: " + peso + " kg");
    }
}
