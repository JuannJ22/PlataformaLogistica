package co.edu.uniquindio.poo.plataformalogistica.model;

import java.util.List;

public interface AsignacionRepartidorStrategy {

    public Repartidor asignar(Envio envio, List<Repartidor> repartidores);
}
