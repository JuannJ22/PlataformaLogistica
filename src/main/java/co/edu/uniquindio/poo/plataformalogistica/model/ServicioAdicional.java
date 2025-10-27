package co.edu.uniquindio.poo.plataformalogistica.model;

import java.util.Objects;

/**
 * Clase que representa un servicio adicional que se puede agregar a un envío
 * como seguro, entrega prioritaria, firma requerida, etc.
 */
public class ServicioAdicional {
    private String ID;
    private TipoServicioAdicional tipo;
    private String nombre;
    private String descripcion;
    private double costoAdicional;
    private boolean activo;

    public ServicioAdicional() {
        this.activo = true;
    }

    public ServicioAdicional(String ID, TipoServicioAdicional tipo, String nombre,
                           String descripcion, double costoAdicional) {
        this();
        this.ID = ID;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoAdicional = costoAdicional;
    }

    // Getters y Setters
    public String getID() {
        return ID;
    }

    public void setID(String idServicio) {
        this.ID = ID;
    }

    public TipoServicioAdicional getTipo() {
        return tipo;
    }

    public void setTipo(TipoServicioAdicional tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCostoAdicional() {
        return costoAdicional;
    }

    public void setCostoAdicional(double costoAdicional) {
        this.costoAdicional = costoAdicional;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // Métodos de negocio
    public double calcularCostoConPorcentaje(double costoBase) {
        if (tipo.esPorcentaje()) {
            return costoBase * (costoAdicional / 100.0);
        }
        return costoAdicional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicioAdicional that = (ServicioAdicional) o;
        return Objects.equals(ID, that.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "ServicioAdicional{" +
                "nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                ", costoAdicional=" + costoAdicional +
                '}';
    }
}

