package co.edu.uniquindio.poo.plataformalogistica.dto;

import co.edu.uniquindio.poo.plataformalogistica.model.EstadoPago;

import java.time.LocalDate;

public record PagoDTO(
        String id,
        String envioId,
        double monto,
        LocalDate fecha,
        String metodo,
        EstadoPago estado
) {}
