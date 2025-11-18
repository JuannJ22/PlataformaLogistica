package co.edu.uniquindio.poo.plataformalogistica.data;


import co.edu.uniquindio.poo.plataformalogistica.auth.Credencial;
import co.edu.uniquindio.poo.plataformalogistica.auth.InMemoryAuthRepository;
import co.edu.uniquindio.poo.plataformalogistica.auth.PasswordEncoder;
import co.edu.uniquindio.poo.plataformalogistica.auth.Rol;
import co.edu.uniquindio.poo.plataformalogistica.model.*;

import java.time.LocalDate;

/**
 * Clase que se usa para la carga de datos de ejemplo para la plataforma.
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
        if (datosCargados) return;

        boolean sinAdmins        = plataforma.getListAdministradores().isEmpty();
        boolean sinUsuarios      = plataforma.getListUsuarios().isEmpty();
        boolean sinRepartidores  = plataforma.getListRepartidores().isEmpty();
        boolean sinEnvios        = plataforma.getListEnvios().isEmpty();

        if (sinAdmins)        cargarAdministradores(plataforma);
        if (sinUsuarios)      cargarUsuarios(plataforma);
        if (sinRepartidores)  cargarRepartidores(plataforma);
        if (sinEnvios)        cargarEnvios(plataforma);

        datosCargados = true;
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
        if (usuario == null) return; // o lanza excepción si quieres que sea obligatorio

        Repartidor repartidorInicial = null;
        EnviarEnvio metodoEnvio = new EnvioMoto();
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
    }

    /**
     * Metodo usado para cargar los administradores que se tendran de base
     * @param plataforma se vincula la info con plataforma
     */
    private static void cargarAdministradores(PlataformaLogistica plataforma) {
        Administrador admin = new Administrador(
                "ADM-001",
                "Administrador General",
                "admin@plataforma.com",
                "3000000000"
        );

        if (plataforma.getAdministrador(admin.getID()) == null) {
            plataforma.agregarAdministrador(admin);
        }
    }

    /**
     * vincula los usuarios que inician sesion usando el linkedid
     */
    public static InMemoryAuthRepository crearAuthRepository(PasswordEncoder encoder) {
        InMemoryAuthRepository repo = new InMemoryAuthRepository();

        // ADMIN (debe existir ADM-001 en dominio)
        repo.add(new Credencial(
                "admin@plataforma.com",
                encoder.encode("admin123"),
                Rol.ADMIN,
                "ADM-001"
        ));

        // USUARIOS (deben existir U-001 y U-002 en dominio)
        repo.add(new Credencial(
                "juanjo@demo.com",
                encoder.encode("1234"),
                Rol.USUARIO,
                "U-001"
        ));
        repo.add(new Credencial(
                "sofia@demo.com",
                encoder.encode("abcd"),
                Rol.USUARIO,
                "U-002"
        ));

        return repo;
    }

}
