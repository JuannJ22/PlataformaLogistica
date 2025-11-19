package co.edu.uniquindio.poo.plataformalogistica.dto;

import co.edu.uniquindio.poo.plataformalogistica.model.EstadoEnvio;
import co.edu.uniquindio.poo.plataformalogistica.model.Tarifa;

import java.time.LocalDate;
import java.util.List;

public record EnvioDTO(
        String id,
        String usuarioNombre,
        String repartidorNombre,
        LocalDate fechaCreacion,
        LocalDate fechaEntrega,
        String origen,
        String destino,
        double distanciaKm,
        double precio,
        EstadoEnvio estado,
        Tarifa tarifa
) {}