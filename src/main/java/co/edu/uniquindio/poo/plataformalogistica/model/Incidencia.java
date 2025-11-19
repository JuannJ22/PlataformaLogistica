package co.edu.uniquindio.poo.plataformalogistica.model;

import java.time.LocalDate;
import java.util.Objects;

public class Incidencia {
    private final String id;
    private final String envioId;
    private final String descripcion;
    private final LocalDate fecha;
    private final String zona;

    public Incidencia(String id, String envioId, String descripcion, LocalDate fecha, String zona) {
        this.id = Objects.requireNonNull(id);
        this.envioId = Objects.requireNonNull(envioId);
        this.descripcion = Objects.requireNonNullElse(descripcion, "");
        this.fecha = Objects.requireNonNull(fecha);
        this.zona = Objects.requireNonNullElse(zona, "");
    }

    public String getId() { return id; }
    public String getEnvioId() { return envioId; }
    public String getDescripcion() { return descripcion; }
    public LocalDate getFecha() { return fecha; }
    public String getZona() { return zona; }
}
