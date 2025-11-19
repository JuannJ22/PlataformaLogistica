package co.edu.uniquindio.poo.plataformalogistica.model;

import java.time.LocalDate;
import java.util.Objects;

public class Pago {
    private final String id;
    private final String envioId;
    private final double monto;
    private final LocalDate fecha;
    private final MetodoPago metodoPago;
    private final EstadoPago estado;

    public Pago(String id, String envioId, double monto, LocalDate fecha, MetodoPago metodoPago, EstadoPago estado) {
        this.id = Objects.requireNonNull(id);
        this.envioId = Objects.requireNonNull(envioId);
        this.monto = monto;
        this.fecha = Objects.requireNonNull(fecha);
        this.metodoPago = Objects.requireNonNull(metodoPago);
        this.estado = Objects.requireNonNull(estado);
    }

    public String getId() { return id; }
    public String getEnvioId() { return envioId; }
    public double getMonto() { return monto; }
    public LocalDate getFecha() { return fecha; }
    public MetodoPago getMetodoPago() { return metodoPago; }
    public EstadoPago getEstado() { return estado; }
}
