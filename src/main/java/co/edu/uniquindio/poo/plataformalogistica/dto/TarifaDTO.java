package co.edu.uniquindio.poo.plataformalogistica.dto;

public record TarifaDTO(
        double costoBase,
        double recargoDistancia,
        double recargoPeso,
        double recargoVolumen,
        double recargoPrioridad,
        double recargosAdicionales,
        double total
) {}
