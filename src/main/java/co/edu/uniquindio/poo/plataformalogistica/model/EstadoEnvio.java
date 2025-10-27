package co.edu.uniquindio.poo.plataformalogistica.model;

/**
 * Enume que representa los diferentes estados de un envío
 * en la plataforma de logística.
 */
public enum EstadoEnvio {
    SOLICITADO("Solicitado", "El envío ha sido solicitado por el usuario"),
    ASIGNADO("Asignado", "El envío ha sido asignado a un repartidor"),
    EN_RUTA("En Ruta", "El repartidor está en camino para recoger o entregar el paquete"),
    ENTREGADO("Entregado", "El paquete ha sido entregado exitosamente"),
    INCIDENCIA("Incidencia", "Ha ocurrido un problema con el envío"),
    CANCELADO("Cancelado", "El envío ha sido cancelado");
}