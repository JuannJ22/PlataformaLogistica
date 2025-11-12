package co.edu.uniquindio.poo.plataformalogistica.model;


import java.util.List;

/**
 * Estrategia simple: elige el primer repartidor con disponibilidad ACTIVO.
 */
public class AsignacionPorDisponibilidadStrategy implements AsignacionRepartidorStrategy {

    @Override
    public Repartidor asignar(Envio envio, List<Repartidor> repartidores) {

        for (Repartidor repartidor : repartidores) {
            if (repartidor.getDisponibilidadRepartidor() == DisponibilidadRepartidor.ACTIVO) {
                return repartidor;
            }
        }

        // Si no hay repartidores disponibles
        return null;
    }
}
