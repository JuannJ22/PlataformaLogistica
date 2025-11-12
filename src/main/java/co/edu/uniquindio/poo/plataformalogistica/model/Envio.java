package co.edu.uniquindio.poo.plataformalogistica.model;

import java.time.LocalDate;

public abstract class Envio {
    protected EnviarEnvio metodoEnvio;// (bridge)
    protected Usuario usuario;
    protected Repartidor repartidor;
    protected LocalDate fechaCreacion;
    protected LocalDate fechaEntrega;
    protected String destino;
    protected double precio;
    protected String ID;
    protected EstadoEnvio estadoEnvio;
    protected Paquete paquete;


    public Envio(EnviarEnvio metodoEnvio, Usuario usuario, Repartidor repartidor,
                 LocalDate fechaCreacion, LocalDate fechaEntrega,
                 String destino, double precio, String ID,
                 EstadoEnvio estadoEnvio, Paquete paquete) {

        this.metodoEnvio = metodoEnvio;
        this.usuario = usuario;
        this.repartidor = repartidor;
        this.fechaCreacion = fechaCreacion;
        this.fechaEntrega = fechaEntrega;
        this.destino = destino;
        this.precio = precio;
        this.ID =ID;
        this.estadoEnvio = estadoEnvio;
        this.paquete = paquete;
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

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
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
                ", destino='" + destino + '\'' +
                ", precio=" + precio +
                ", ID='" + ID + '\'' +
                ", estadoEnvio='" + estadoEnvio + '\'' +
                ", paquete=" + paquete +
                '}';
    }
}
    public LocalDateTime getFechaEstimadaEntrega() {
        return fechaEstimadaEntrega;
    }

    public void setFechaEstimadaEntrega(LocalDateTime fechaEstimadaEntrega) {
        this.fechaEstimadaEntrega = fechaEstimadaEntrega;
    }

    public LocalDateTime getFechaEntregaReal() {
        return fechaEntregaReal;
    }

    public void setFechaEntregaReal(LocalDateTime fechaEntregaReal) {
        this.fechaEntregaReal = fechaEntregaReal;
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
        this.fechaCreacion = fechaCreacion;
        this.fechaEntrega = fechaEntrega;
        this.destino = destino;
        this.precio = precio;
        this.ID =ID;
        this.estadoEnvio = estadoEnvio;
        this.paquete = paquete;
    }

    // Acción principal que se conecta al implementador (bridge)
    public void procesarEnvio() {
        System.out.println("Procesando envío con ID: " + ID);
        metodoEnvio.enviar();
    }

    public abstract void mostrarDetalles();
}
    public void setServiciosAdicionales(List<ServicioAdicional> serviciosAdicionales) {
        this.serviciosAdicionales = serviciosAdicionales;
    }

    public String getDescripcionPaquete() {
        return descripcionPaquete;
    }

    public void setDescripcionPaquete(String descripcionPaquete) {
        this.descripcionPaquete = descripcionPaquete;
    }

    public String getInstruccionesEspeciales() {
        return instruccionesEspeciales;
    }

    public void setInstruccionesEspeciales(String instruccionesEspeciales) {
        this.instruccionesEspeciales = instruccionesEspeciales;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }


}
