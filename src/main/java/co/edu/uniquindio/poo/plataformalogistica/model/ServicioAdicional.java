package co.edu.uniquindio.poo.plataformalogistica.model;

import java.util.Objects;

/**
 * Clase que representa un servicio adicional que se puede agregar a un envío
 * como seguro, entrega prioritaria, firma requerida, etc.
 */
public class ServicioAdicional {
    private String idServicio;
    private TipoServicioAdicional tipo;
    private String nombre;
    private String descripcion;
    private double costoAdicional;
    private boolean activo;

    public ServicioAdicional() {
        this.activo = true;
    }

    public ServicioAdicional(String idServicio, TipoServicioAdicional tipo, String nombre, 
                           String descripcion, double costoAdicional) {
        this();
        this.idServicio = idServicio;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoAdicional = costoAdicional;
    }

    // Getters y Setters
    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
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
        return Objects.equals(idServicio, that.idServicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServicio);
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

/**
 * Enumeración que representa los diferentes tipos de servicios adicionales
 */
enum TipoServicioAdicional {
    SEGURO("Seguro", "Protección del paquete contra daños o pérdida", true),
    FRAGIL("Frágil", "Manejo especial para objetos delicados", false),
    FIRMA_REQUERIDA("Firma Requerida", "Requiere firma del destinatario", false),
    PRIORIDAD("Prioridad", "Entrega prioritaria", false),
    ENTREGA_NOCTURNA("Entrega Nocturna", "Entrega en horario nocturno", false),
    EMPAQUE_ESPECIAL("Empaque Especial", "Empaque adicional de protección", false);

    private final String nombre;
    private final String descripcion;
    private final boolean esPorcentaje;

    TipoServicioAdicional(String nombre, String descripcion, boolean esPorcentaje) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.esPorcentaje = esPorcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean esPorcentaje() {
        return esPorcentaje;
    }

    @Override
    public String toString() {
        return nombre;
    }
}