package co.edu.uniquindio.poo.plataformalogistica.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Clase Pago que representa la transacción financiera de un envío.
 */
public class Pago {
    private String idPago;
    private double monto;
    private LocalDateTime fechaPago;
    private MetodoPago metodoPago;
    private EstadoPago estado;
    private String numeroTransaccion;
    private String descripcion;
    private Envio envio;

    public Pago() {
        this.fechaPago = LocalDateTime.now();
        this.estado = EstadoPago.PENDIENTE;
    }

    public Pago(String idPago, double monto, MetodoPago metodoPago, Envio envio) {
        this();
        this.idPago = idPago;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.envio = envio;
    }

    // Getters y Setters
    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public EstadoPago getEstado() {
        return estado;
    }

    public void setEstado(EstadoPago estado) {
        this.estado = estado;
    }

    public String getNumeroTransaccion() {
        return numeroTransaccion;
    }

    public void setNumeroTransaccion(String numeroTransaccion) {
        this.numeroTransaccion = numeroTransaccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }


    @Override
    public String toString() {
        return "Pago{" +
                "idPago='" + idPago + '\'' +
                ", monto=" + monto +
                ", estado=" + estado +
                ", fechaPago=" + fechaPago +
                ", numeroTransaccion='" + numeroTransaccion + '\'' +
                '}';
    }
}