package co.edu.uniquindio.poo.plataformalogistica.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Envio {
    protected EnviarEnvio metodoEnvio;// (bridge)
    protected Usuario usuario;
    protected Repartidor repartidor;
    protected LocalDate fechaCreacion;
    protected LocalDate fechaEntrega;
    protected Direccion origen;
    protected Direccion destino;
    protected double distanciaKm;
    protected double pesoKg;
    protected double volumenM3;
    protected boolean prioridad;
    protected double precio;
    protected String ID;
    protected EstadoEnvio estadoEnvio;
    protected Paquete paquete;
    protected final List<ServicioAdicional> serviciosAdicionales;


    public Envio(EnviarEnvio metodoEnvio, Usuario usuario, Repartidor repartidor,
                 LocalDate fechaCreacion, LocalDate fechaEntrega,
                 Direccion origen, Direccion destino,
                 double distanciaKm, double pesoKg, double volumenM3,
                 boolean prioridad, double precio, String ID,
                 EstadoEnvio estadoEnvio, Paquete paquete,
                 List<ServicioAdicional> serviciosAdicionales) {

        this.metodoEnvio = metodoEnvio;
        this.usuario = usuario;
        this.repartidor = repartidor;
        this.fechaCreacion = fechaCreacion;
        this.fechaEntrega = fechaEntrega;
        this.destino = destino;
        this.origen = origen;
        this.distanciaKm = distanciaKm;
        this.pesoKg = pesoKg;
        this.volumenM3 = volumenM3;
        this.prioridad = prioridad;
        this.precio = precio;
        this.ID =ID;
        this.estadoEnvio = estadoEnvio;
        this.paquete = paquete;
        this.serviciosAdicionales = new ArrayList<>();
        if (serviciosAdicionales != null) {
            this.serviciosAdicionales.addAll(serviciosAdicionales);
        }
    }

    // Acción principal que se conecta al implementador (bridge)
    public void procesarEnvio() {
        System.out.println("Procesando envío con ID: " + ID);
        metodoEnvio.enviar();
    }

    public EnviarEnvio getMetodoEnvio() {
        return metodoEnvio;
    }

    public void setMetodoEnvio(EnviarEnvio metodoEnvio) {
        this.metodoEnvio = metodoEnvio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public EstadoEnvio getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(EstadoEnvio estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Direccion getDestino() { return destino; }

    public void setDestino(Direccion destino) { this.destino = destino; }

    public Direccion getOrigen() { return origen; }

    public void setOrigen(Direccion origen) { this.origen = origen; }

    public double getDistanciaKm() { return distanciaKm; }

    public void setDistanciaKm(double distanciaKm) { this.distanciaKm = distanciaKm; }

    public double getPesoKg() { return pesoKg; }

    public void setPesoKg(double pesoKg) { this.pesoKg = pesoKg; }

    public double getVolumenM3() { return volumenM3; }

    public void setVolumenM3(double volumenM3) { this.volumenM3 = volumenM3; }

    public boolean isPrioridad() { return prioridad; }

    public void setPrioridad(boolean prioridad) { this.prioridad = prioridad; }

    public List<ServicioAdicional> getServiciosAdicionales() {
        return new ArrayList<>(serviciosAdicionales);
    }

    public void agregarServicioAdicional(ServicioAdicional servicio) {
        if (servicio == null) return;
        if (!serviciosAdicionales.contains(servicio)) {
            serviciosAdicionales.add(servicio);
        }
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public abstract void mostrarDetalles();

    @Override
    public String toString() {
        return "Envio{" +
                "metodoEnvio=" + metodoEnvio +
                ", usuario=" + usuario +
                ", repartidor=" + repartidor +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaEntrega=" + fechaEntrega +
                ", destino='" + (destino != null ? destino.toString() : "") + '\'' +
                ", precio=" + precio +
                ", ID='" + ID + '\'' +
                ", estadoEnvio='" + estadoEnvio + '\'' +
                ", paquete=" + paquete +
                '}';
    }

    public LocalDate getFechaEntregaReal() {
        return fechaEntrega; // Se asume que esta fecha es la real
    }

    public double getTiempoEntregaHoras() {

        if (fechaCreacion == null || fechaEntrega == null) {
            return 0;
        }

        long dias = java.time.temporal.ChronoUnit.DAYS.between(fechaCreacion, fechaEntrega);

        return dias * 24.0;
    }


}

