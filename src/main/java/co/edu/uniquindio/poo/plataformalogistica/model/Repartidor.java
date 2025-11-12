package co.edu.uniquindio.poo.plataformalogistica.model;

public class Repartidor {

    private String ID;
    private String nombre;
    private String documento;
    private String telefono;
    private boolean disponibilidad;
    private String zonaCobertura;

    /**
     * Constructor de la clase Repartidor
     *
     * @param ID
     * @param nombre
     * @param documento
     * @param telefono
     * @param disponibilidad
     * @param zonaCobertura
     */
    public Repartidor(String ID, String nombre, String documento, String telefono, boolean disponibilidad, String zonaCobertura) {
        this.ID = ID;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.disponibilidad = disponibilidad;
        this.zonaCobertura = zonaCobertura;
    }

    //GETTER Y SETTER DE REPARTIDOR


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getZonaCobertura() {
        return zonaCobertura;
    }

    public void setZonaCobertura(String zonaCobertura) {
        this.zonaCobertura = zonaCobertura;
    }
}
