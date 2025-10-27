package co.edu.uniquindio.poo.plataformalogistica.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Entidad Repartidor que representa a las personas encargadas de transportar los paquetes.
 */
public class Repartidor extends Persona {
    private String ID;
    private String nombre;
    private String documento;
    private String telefono;
    private EstadoRepartidor disponibilidad;
    private String zonaCobertura;
    private List<Envio> enviosAsignados;
    private String vehiculo;
    private String placaVehiculo;

    public Repartidor(String nombre, String ID) {
        super(nombre, ID);
        this.enviosAsignados = new ArrayList<>();
        this.disponibilidad = EstadoRepartidor.INACTIVO;
    }

    public Repartidor(String ID, String nombre, String documento, String telefono, String zonaCobertura) {
        super(nombre, ID);
        this.documento = documento;
        this.telefono = telefono;
        this.zonaCobertura = zonaCobertura;
    }

    // Getters y Setters
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
        return Objects.equals(ID, that.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "Repartidor{" +
                "idRepartidor='" + ID + '\'' +
                ", nombre='" + nombre + '\'' +
                ", disponibilidad=" + disponibilidad +
                ", zonaCobertura='" + zonaCobertura + '\'' +
                ", enviosAsignados=" + enviosAsignados.size() +
                '}';
    }
}


