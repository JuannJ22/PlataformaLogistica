package co.edu.uniquindio.poo.plataformalogistica.model;

import co.edu.uniquindio.poo.plataformalogistica.dto.TarifaDTO;

import java.util.List;

public class Tarifa {

    private static final double COSTO_BASE = 8000;
    private static final double COSTO_POR_KM = 500;
    private static final double COSTO_POR_KG = 1000;
    private static final double COSTO_POR_M3 = 2000;
    private static final double COSTO_PRIORIDAD = 7000;
    private static final double COSTO_SERVICIO_ADICIONAL = 3500;

    public TarifaDTO cotizar(double distanciaKm, double pesoKg, double volumenM3,
                             boolean prioridad, List<ServicioAdicional> serviciosAdicionales) {

        double recargoDistancia = distanciaKm * COSTO_POR_KM;
        double recargoPeso = pesoKg * COSTO_POR_KG;
        double recargoVolumen = volumenM3 * COSTO_POR_M3;
        double recargoPrioridad = prioridad ? COSTO_PRIORIDAD : 0;
        double recargosServicios = (serviciosAdicionales != null ? serviciosAdicionales.size() : 0)
                * COSTO_SERVICIO_ADICIONAL;

        double total = COSTO_BASE + recargoDistancia + recargoPeso + recargoVolumen
                + recargoPrioridad + recargosServicios;

        return new TarifaDTO(
                COSTO_BASE,
                recargoDistancia,
                recargoPeso,
                recargoVolumen,
                recargoPrioridad,
                recargosServicios,
                total
        );
    }
}
