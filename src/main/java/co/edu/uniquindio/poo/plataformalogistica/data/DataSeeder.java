package co.edu.uniquindio.poo.plataformalogistica.data;

import co.edu.uniquindio.poo.plataformalogistica.model.*;

import java.time.LocalDate;

/**
 * Carga de datos de ejemplo para la plataforma.
 * Esta clase centraliza la creación de usuarios, repartidores y envíos de demostración
 * para que no existan inicializaciones dispersas.
 *
 * <p>Uso recomendado:
 * <pre>
 *     PlataformaLogistica.getInstancia("NIT", "Nombre", "Tel");
 *     DataSeeder.seedIfEmpty();
 * </pre>
 * </p>
 */
public final class DataSeeder {

    private static boolean datosCargados = false;

    private DataSeeder() {}

    /**
     * Carga datos de demostración si la plataforma aún está vacía.
     * No duplica datos si ya fueron cargados.
     */
    public static void seedIfEmpty() {
        PlataformaLogistica plataforma = PlataformaLogistica.getInstancia();
        if (plataforma == null) {
            throw new IllegalStateException(
                    "PlataformaLogistica no está inicializada. " +
                            "Debe llamarse primero a getInstancia(nit, nombre, telefono)."
            );
        }

        if (datosCargados) {
            return;
        }

        boolean sinUsuarios = plataforma.getListUsuarios().isEmpty();
        boolean sinRepartidores = plataforma.getListRepartidores().isEmpty();
        boolean sinEnvios = plataforma.getListEnvios().isEmpty();

        if (sinUsuarios || sinRepartidores || sinEnvios) {
            cargarUsuarios(plataforma);
            cargarRepartidores(plataforma);
            cargarEnvios(plataforma);
            datosCargados = true;
        }
    }

    /**
     * Carga un conjunto mínimo de usuarios de prueba.
     */
    private static void cargarUsuarios(PlataformaLogistica plataforma) {
        Usuario usuario1 = new Usuario.Builder("U-001", "Juan José Ortiz", "3110000000")
                .setEdad(21)
                .setCorreoElectronico("juanjo@demo.com")
                .build();

        Usuario usuario2 = new Usuario.Builder("U-002", "Sofía Ramírez", "3120000000")
                .setEdad(20)
                .setCorreoElectronico("sofia@demo.com")
                .build();

        if (plataforma.getUsuario(usuario1.getID()) == null) {
            plataforma.agregarUsuario(usuario1);
        }
        if (plataforma.getUsuario(usuario2.getID()) == null) {
            plataforma.agregarUsuario(usuario2);
        }
    }

    /**
     * Carga un conjunto mínimo de repartidores de prueba.
     */
    private static void cargarRepartidores(PlataformaLogistica plataforma) {
        Repartidor repartidor1 = new Repartidor(
                "R-001", "Pedro Gómez", "100200300",
                "3001111111", DisponibilidadRepartidor.ACTIVO, "Norte"
        );

        Repartidor repartidor2 = new Repartidor(
                "R-002", "María López", "100200301",
                "3002222222", DisponibilidadRepartidor.INACTIVO, "Centro"
        );

        if (plataforma.getRepartidor(repartidor1.getID()) == null) {
            plataforma.agregarRepartidor(repartidor1);
        }
        if (plataforma.getRepartidor(repartidor2.getID()) == null) {
            plataforma.agregarRepartidor(repartidor2);
        }
    }

    /**
     * Carga un conjunto mínimo de envíos de prueba.
     * Ajusta los objetos Paquete / EnviarEnvio según tu implementación real.
     */
    private static void cargarEnvios(PlataformaLogistica plataforma) {
        Usuario usuario = plataforma.getUsuario("U-001");
        // Sin asignar repartidor de entrada (queda para la asignación automática/manual)
        Repartidor repartidorInicial = null;

        // Implementación Bridge para el envío (ajusta si tienes otras)
        EnviarEnvio metodoEnvio = new EnvioMoto();

        // Paquete de ejemplo (ajusta a tu clase Paquete real)
        Paquete paquete = new Paquete("Caja Mediana", "Paqueton", "2X2", 12.2);

        Envio envio1 = new EnvioUrbano(
                metodoEnvio,
                usuario,
                repartidorInicial,
                LocalDate.now(),
                null,
                "Armenia - Centro",
                15000.0,
                "E-001",
                EstadoEnvio.SOLICITADO,
                paquete
        );

        if (plataforma.getEnvio(envio1.getID()) == null) {
            plataforma.agregarEnvio(envio1);
        }

        // Si quieres demostrar asignación automática por disponibilidad:
        // plataforma.asignarEnvioAutomatico("E-001");
    }
}
