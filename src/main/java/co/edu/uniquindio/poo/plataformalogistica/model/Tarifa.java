package co.edu.uniquindio.poo.plataformalogistica.model;

import java.time.Duration;

public class Tarifa {

    private boolean tarifaAdicional;

    private final PlataformaLogistica plataforma;

    public Tarifa(boolean tarifaAdicional ) {
        this.tarifaAdicional = tarifaAdicional;
        this.plataforma= PlataformaLogistica.getInstancia();
    }

    /**
     * Calcula el precio base de un envío según:
     * - Precio base fijo: 10.000
     * - Si la duración supera las 24 horas: +5.000
     */
    public double definirPrecioBase(Envio envio) {

        double precioBase = 10000;

        // Calcular diferencia entre fechas en horas
        long horasDiferencia = Duration.between(
                envio.getFechaCreacion().atStartOfDay(),
                envio.getFechaEntrega().atStartOfDay()
        ).toHours();

        // Si dura más de 24 horas se suman $5000
        if (horasDiferencia > 24) {
            precioBase += 5000;
        }

        if (tarifaAdicional) {
            precioBase += 7000;
        }

        return precioBase;
    }
}
