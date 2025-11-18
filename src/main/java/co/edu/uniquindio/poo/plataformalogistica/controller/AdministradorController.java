package co.edu.uniquindio.poo.plataformalogistica.controller;

import co.edu.uniquindio.poo.plataformalogistica.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class AdministradorController {

    private final PlataformaLogistica plataforma;
    private final Administrador administrador;

    public AdministradorController(Administrador administrador) {
        this.plataforma = PlataformaLogistica.getInstancia();
        this.administrador = administrador;
    }

    // ========= RF-010: Usuarios =========

    public List<Usuario> listarUsuarios() {
        return plataforma.getListUsuarios();
    }

    public void crearUsuario(Usuario usuario) {
        plataforma.agregarUsuario(usuario);
    }

    public void actualizarUsuario(Usuario usuarioModificado) {
        plataforma.setUsuario(
                usuarioModificado.getID(),
                usuarioModificado.getNombreCompleto(),
                usuarioModificado.getTelefono(),
                usuarioModificado.getEdad(),
                usuarioModificado.getCorreoElectronico()
        );
    }

    public void eliminarUsuario(Usuario usuario) {
        if (usuario != null) {
            plataforma.eliminarUsuario(usuario.getID());
        }
    }

    // ========= RF-011: Repartidores =========

    public List<Repartidor> listarRepartidores() {
        return plataforma.getListRepartidores();
    }

    public void crearRepartidor(Repartidor repartidor) {
        plataforma.agregarRepartidor(repartidor);
    }

    public void actualizarRepartidor(Repartidor repartidorModificado) {
        plataforma.setRepartidor(
                repartidorModificado.getID(),
                repartidorModificado.getNombre(),
                repartidorModificado.getTelefono(),
                repartidorModificado.getDisponibilidadRepartidor(),
                repartidorModificado.getZonaCobertura()
        );
    }

    public void eliminarRepartidor(Repartidor repartidor) {
        if (repartidor != null) {
            plataforma.eliminarRepartidor(repartidor.getID());
        }
    }

    public void cambiarDisponibilidad(Repartidor repartidor, DisponibilidadRepartidor nuevaDisp) {
        if (repartidor != null) {
            repartidor.setDisponibilidadRepartidor(nuevaDisp);
        }
    }

    // ========= RF-012: Envíos / Asignación / Incidencias / Estado =========

    public List<Envio> listarEnvios() {
        return plataforma.getListEnvios();
    }

    public void asignarEnvioAutomatico(Envio envio) {
        plataforma.asignarEnvioAutomatico(envio.getID());
    }

    public void asignarOReasignarManual(Envio envio, Repartidor repartidor) {
        plataforma.reasignarEnvioManualmente(envio.getID(), repartidor.getID());
    }

    public void cambiarEstadoEnvio(Envio envio, EstadoEnvio nuevoEstado) {
        if (envio != null && nuevoEstado != null) {
            envio.setEstadoEnvio(nuevoEstado);
        }
    }

    public void registrarIncidencia(Envio envio, String descripcion) {
        if (envio == null || descripcion == null || descripcion.isBlank()) return;

        // Si tienes entidad Incidencia, aquí la crearías y la agregarías al envío.
        // Por ahora: solo marcamos estado como INCIDENCIA.
        envio.setEstadoEnvio(EstadoEnvio.INCIDENCIA);
        System.out.println("Incidencia registrada en envío " + envio.getID() + ": " + descripcion);
    }

    // ========= RF-013 / RF-014: Métricas (delegadas a PlataformaLogistica) =========
    // Estas firmas asumen que en PlataformaLogistica implementarás los cálculos.

    public Map<String, Double> tiemposPromedioEntregaPorZona(LocalDate desde, LocalDate hasta) {
        return plataforma.calcularTiemposPromedioEntrega(desde, hasta);
    }

    public Map<String, Double> ingresosPorPeriodo(LocalDate desde, LocalDate hasta) {
        return plataforma.calcularIngresosPorPeriodo(desde, hasta);
    }

    public Map<String, Integer> serviciosAdicionalesMasUsados(LocalDate desde, LocalDate hasta) {
        return plataforma.calcularServiciosAdicionales(desde, hasta);
    }

    public Map<String, Integer> incidenciasPorZona(LocalDate desde, LocalDate hasta) {
        return plataforma.calcularIncidenciasPorZona(desde, hasta);
    }
}
