package co.edu.uniquindio.poo.plataformalogistica.data;

import co.edu.uniquindio.poo.plataformalogistica.model.*;
import co.edu.uniquindio.poo.plataformalogistica.auth.*;

import java.time.LocalDate;

/**
 * Carga de datos + credenciales de ejemplo para login en memoria.
 */
public final class DataSeeder {

    private static boolean datosCargados = false;

    private DataSeeder() { }

    public static void seedIfEmpty() {
        PlataformaLogistica plataforma = PlataformaLogistica.getInstancia();
        if (plataforma == null) {
            throw new IllegalStateException(
                    "PlataformaLogistica no está inicializada. " +
                            "Llama primero a getInstancia(nit, nombre, telefono)."
            );
        }
        if (datosCargados) return;

        boolean sinAdmins       = plataforma.getListAdministradores().isEmpty();
        boolean sinUsuarios     = plataforma.getListUsuarios().isEmpty();
        boolean sinRepartidores = plataforma.getListRepartidores().isEmpty();
        boolean sinEnvios       = plataforma.getListEnvios().isEmpty();

        if (sinAdmins)       cargarAdministradores(plataforma);
        if (sinUsuarios)     cargarUsuarios(plataforma);
        if (sinRepartidores) cargarRepartidores(plataforma);
        if (sinEnvios)       cargarEnvios(plataforma);

        datosCargados = true;
    }

    private static void cargarAdministradores(PlataformaLogistica plataforma) {
        Administrador admin = new Administrador(
                "ADM-001", "Administrador General", "admin@plataforma.com", "3000000000"
        );
        if (plataforma.getAdministrador(admin.getID()) == null) {
            plataforma.agregarAdministrador(admin);
        }
    }

    private static void cargarUsuarios(PlataformaLogistica plataforma) {
        Usuario usuario1 = new Usuario.Builder("U-001", "Juan José Ortiz", "3110000000")
                .setEdad(21)
                .setCorreoElectronico("juanjo@demo.com")
                .build();

        Usuario usuario2 = new Usuario.Builder("U-002", "Sofía Ramírez", "3120000000")
                .setEdad(20)
                .setCorreoElectronico("sofia@demo.com")
                .build();

        if (plataforma.getUsuario(usuario1.getID()) == null) plataforma.agregarUsuario(usuario1);
        if (plataforma.getUsuario(usuario2.getID()) == null) plataforma.agregarUsuario(usuario2);
    }

    private static void cargarRepartidores(PlataformaLogistica plataforma) {
        Repartidor repartidor1 = new Repartidor(
                "R-001", "Pedro Gómez", "100200300", "3001111111",
                DisponibilidadRepartidor.ACTIVO, "Norte"
        );
        Repartidor repartidor2 = new Repartidor(
                "R-002", "María López", "100200301", "3002222222",
                DisponibilidadRepartidor.INACTIVO, "Centro"
        );

        if (plataforma.getRepartidor(repartidor1.getID()) == null) plataforma.agregarRepartidor(repartidor1);
        if (plataforma.getRepartidor(repartidor2.getID()) == null) plataforma.agregarRepartidor(repartidor2);
    }

    private static void cargarEnvios(PlataformaLogistica plataforma) {
        Usuario usuario = plataforma.getUsuario("U-001");
        Repartidor repartidorInicial = null;

        EnviarEnvio metodoEnvio = new EnvioMoto();
        Paquete paquete = new Paquete("Caja Mediana", "Paqueton", "2X2", 12.2);

        Envio envio1 = new EnvioUrbano(
                metodoEnvio, usuario, repartidorInicial,
                LocalDate.now(), null,
                "Armenia - Centro", 15000.0, "E-001",
                EstadoEnvio.SOLICITADO, paquete
        );

        if (plataforma.getEnvio(envio1.getID()) == null) plataforma.agregarEnvio(envio1);
    }

    /** Crea el repositorio de credenciales en memoria (para el LoginService). */
    public static InMemoryAuthRepository crearAuthRepository(PasswordEncoder encoder) {
        InMemoryAuthRepository repo = new InMemoryAuthRepository();

        // ADMIN (linkea con ADM-001)
        repo.add(new Credencial(
                "admin@plataforma.com",
                encoder.encode("admin123"),
                Rol.ADMIN,
                "ADM-001"
        ));

        // USUARIOS (linkean con U-001 y U-002)
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
