package co.edu.uniquindio.poo.plataformalogistica.model;

import java.time.LocalDate;

public class EnvioUrbano extends Envio {

    public EnvioUrbano(EnviarEnvio metodoEnvio, Usuario usuario, Repartidor repartidor,
                       LocalDate fechaCreacion, LocalDate fechaEntrega,
                       String destino, double precio, String ID,
                       String estadoEnvio, Paquete paquete) {
        super(metodoEnvio, usuario, repartidor, fechaCreacion, fechaEntrega,
                destino, precio, ID, estadoEnvio, paquete);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("=== Detalles del Envío Urbano ===");
        System.out.println("ID Envío: " + ID);
        System.out.println("Usuario: " + usuario.getNombreCompleto());
        System.out.println("Repartidor: " + repartidor.getNombre());
        System.out.println("Destino: " + destino);
        System.out.println("Precio: $" + precio);
        System.out.println("Estado: " + estadoEnvio);
        System.out.println("Paquete: " + paquete.getNombre() + " (" + paquete.getPeso() + " kg)");
        System.out.println("Fecha de Creación: " + fechaCreacion);
        System.out.println("Fecha de Entrega: " + fechaEntrega);
    }
}

