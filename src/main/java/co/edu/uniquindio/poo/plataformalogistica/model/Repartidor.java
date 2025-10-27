package co.edu.uniquindio.poo.plataformalogistica.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Entidad Repartidor que representa a las personas encargadas de transportar los paquetes.
 */
public class Repartidor {
    private String idRepartidor;
    private String nombre;
    private String documento;
    private String telefono;
    private EstadoRepartidor disponibilidad;
    private String zonaCobertura;
    private List<Envio> enviosAsignados;
    private String vehiculo;
    private String placaVehiculo;

    public Repartidor() {
        this.enviosAsignados = new ArrayList<>();
        this.disponibilidad = EstadoRepartidor.INACTIVO;
    }

    public Repartidor(String idRepartidor, String nombre, String documento, String telefono, String zonaCobertura) {
        this();
        this.idRepartidor = idRepartidor;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.zonaCobertura = zonaCobertura;
    }

    // Getters y Setters
    public String getIdRepartidor() {
        return idRepartidor;
    }

    public void setIdRepartidor(String idRepartidor) {
        this.idRepartidor = idRepartidor;
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

    public EstadoRepartidor getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(EstadoRepartidor disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getZonaCobertura() {
        return zonaCobertura;
    }

    public void setZonaCobertura(String zonaCobertura) {
        this.zonaCobertura = zonaCobertura;
    }

    public List<Envio> getEnviosAsignados() {
        return enviosAsignados;
    }

    public void setEnviosAsignados(List<Envio> enviosAsignados) {
        this.enviosAsignados = enviosAsignados;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    // Métodos de negocio
    public boolean estaDisponible() {
        return disponibilidad == EstadoRepartidor.ACTIVO;
    }

    public void asignarEnvio(Envio envio) {
        if (envio != null && estaDisponible() && !enviosAsignados.contains(envio)) {
            enviosAsignados.add(envio);
            envio.setRepartidor(this);
            envio.setEstado(EstadoEnvio.ASIGNADO);
            
            // Si tiene envíos asignados, cambiar estado a EN_RUTA
            if (!enviosAsignados.isEmpty()) {
                this.disponibilidad = EstadoRepartidor.EN_RUTA;
            }
        }
    }

    public void completarEnvio(Envio envio) {
        if (envio != null && enviosAsignados.contains(envio)) {
            envio.setEstado(EstadoEnvio.ENTREGADO);
            enviosAsignados.remove(envio);
            
            // Si no tiene más envíos, volver a estar activo
            if (enviosAsignados.isEmpty()) {
                this.disponibilidad = EstadoRepartidor.ACTIVO;
            }
        }
    }

    public int getCantidadEnviosAsignados() {
        return enviosAsignados.size();
    }

    public List<Envio> getEnviosPendientes() {
        return enviosAsignados.stream()
                .filter(envio -> envio.getEstado() != EstadoEnvio.ENTREGADO)
                .toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repartidor that = (Repartidor) o;
        return Objects.equals(idRepartidor, that.idRepartidor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRepartidor);
    }

    @Override
    public String toString() {
        return "Repartidor{" +
                "idRepartidor='" + idRepartidor + '\'' +
                ", nombre='" + nombre + '\'' +
                ", disponibilidad=" + disponibilidad +
                ", zonaCobertura='" + zonaCobertura + '\'' +
                ", enviosAsignados=" + enviosAsignados.size() +
                '}';
    }
}

/**
 * Enumeración que representa los diferentes estados de disponibilidad de un repartidor.
 */
enum EstadoRepartidor {
    ACTIVO("Activo", "Disponible para recibir nuevos envíos"),
    INACTIVO("Inactivo", "No disponible para recibir envíos"),
    EN_RUTA("En Ruta", "Realizando entregas actualmente");

    private final String nombre;
    private final String descripcion;

    EstadoRepartidor(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return nombre;
    }
}