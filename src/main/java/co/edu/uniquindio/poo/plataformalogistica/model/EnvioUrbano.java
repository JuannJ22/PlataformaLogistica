package co.edu.uniquindio.poo.plataformalogistica.model;

import java.time.LocalDate;
import java.util.List;

public class EnvioUrbano extends Envio {

    public EnvioUrbano(EnviarEnvio metodoEnvio, Usuario usuario, Repartidor repartidor,
                       LocalDate fechaCreacion, LocalDate fechaEntrega,
                       Direccion origen, Direccion destino,
                       double distanciaKm, double pesoKg, double volumenM3,
                       boolean prioridad, double precio, String ID,
                       EstadoEnvio estadoEnvio, Paquete paquete,
                       List<ServicioAdicional> serviciosAdicionales) {
        super(metodoEnvio, usuario, repartidor, fechaCreacion, fechaEntrega,
                origen, destino, distanciaKm, pesoKg, volumenM3,
                prioridad, precio, ID, estadoEnvio, paquete, serviciosAdicionales);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("=== Detalles del Envío Urbano ===");
        System.out.println("ID Envío: " + ID);
        System.out.println("Usuario: " + usuario.getNombreCompleto());
        System.out.println("Repartidor: " + repartidor.getNombre());
        System.out.println("Origen: " + (origen != null ? origen : ""));
        System.out.println("Destino: " + (destino != null ? destino : ""));
        System.out.println("Precio: $" + tarifa);
        System.out.println("Estado: " + estadoEnvio);
        System.out.println("Paquete: " + paquete.getNombre() + " (" + paquete.getPeso() + " kg)");
        System.out.println("Fecha de Creación: " + fechaCreacion);
        System.out.println("Fecha de Entrega: " + fechaEntrega);
        System.out.println("Servicios: " + serviciosAdicionales);
    }
}

