package co.edu.uniquindio.poo.plataformalogistica.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase que representa un método de pago simulado asociado a un usuario.
 */
public class MetodoPago {
    private String idMetodoPago;
    private TipoMetodoPago tipo;
    private String numeroTarjeta;
    private String nombreTitular;
    private LocalDate fechaVencimiento;
    private String cvv;
    private boolean activo;
    private String alias;

    public MetodoPago() {
        this.activo = true;
    }

    public MetodoPago(String idMetodoPago, TipoMetodoPago tipo, String numeroTarjeta, 
                     String nombreTitular, LocalDate fechaVencimiento, String alias) {
        this();
        this.idMetodoPago = idMetodoPago;
        this.tipo = tipo;
        this.numeroTarjeta = numeroTarjeta;
        this.nombreTitular = nombreTitular;
        this.fechaVencimiento = fechaVencimiento;
        this.alias = alias;
    }

    // Getters y Setters
    public String getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(String idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public TipoMetodoPago getTipo() {
        return tipo;
    }

    public void setTipo(TipoMetodoPago tipo) {
        this.tipo = tipo;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

}