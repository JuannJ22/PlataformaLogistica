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
    protected String estadoEnvio;
    protected Paquete paquete;

    public Envio(EnviarEnvio metodoEnvio, Usuario usuario, Repartidor repartidor,
                 LocalDate fechaCreacion, LocalDate fechaEntrega,
                 String destino, double precio, String ID,
                 String estadoEnvio, Paquete paquete) {

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

    public abstract void mostrarDetalles();
}
