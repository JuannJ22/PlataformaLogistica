package co.edu.uniquindio.poo.plataformalogistica.controller;

import co.edu.uniquindio.poo.plataformalogistica.dto.TarifaDTO;
import co.edu.uniquindio.poo.plataformalogistica.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class UsuarioController {

    private final PlataformaLogistica plataforma;
    private final Usuario usuarioActual;

    public UsuarioController(PlataformaLogistica plataforma, Usuario usuarioActual) {
        this.plataforma = plataforma;
        this.usuarioActual = usuarioActual;
    }

    public String getId() { return usuarioActual.getID(); }
    public String getNombreCompleto() { return usuarioActual.getNombreCompleto(); }
    public String getTelefono() { return usuarioActual.getTelefono(); }
    public int getEdad() { return usuarioActual.getEdad(); }
    public String getCorreoElectronico() { return usuarioActual.getCorreoElectronico(); }

    public void actualizarPerfil(String nombre, String telefono, Integer edad, String correo) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (telefono == null || telefono.isBlank()) {
            throw new IllegalArgumentException("El teléfono es obligatorio");
        }
        if (correo == null || correo.isBlank()) {
            throw new IllegalArgumentException("El correo es obligatorio");
        }

        usuarioActual.setNombreCompleto(nombre.trim());
        usuarioActual.setTelefono(telefono.trim());
        usuarioActual.setCorreoElectronico(correo.trim());
        usuarioActual.setEdad(edad != null ? edad : 0);
    }
    package co.edu.uniquindio.poo.plataformalogistica.controller;

import co.edu.uniquindio.poo.plataformalogistica.model.PlataformaLogistica;
import co.edu.uniquindio.poo.plataformalogistica.model.Usuario;
import co.edu.uniquindio.poo.plataformalogistica.dto.TarifaDTO;
import co.edu.uniquindio.poo.plataformalogistica.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

    public class UsuarioController {

        private final PlataformaLogistica plataforma;
        private final Usuario usuarioActual;

        public UsuarioController(PlataformaLogistica plataforma, Usuario usuarioActual) {
            this.plataforma = plataforma;
            this.usuarioActual = usuarioActual;
        }

        public String getId() { return usuarioActual.getID(); }
        public String getNombreCompleto() { return usuarioActual.getNombreCompleto(); }
        public String getTelefono() { return usuarioActual.getTelefono(); }
        public int getEdad() { return usuarioActual.getEdad(); }
        public String getCorreoElectronico() { return usuarioActual.getCorreoElectronico(); }

        public void actualizarPerfil(String nombre, String telefono, Integer edad, String correo) {
            if (nombre == null || nombre.isBlank()) {
                throw new IllegalArgumentException("El nombre es obligatorio");
            }
            if (telefono == null || telefono.isBlank()) {
                throw new IllegalArgumentException("El teléfono es obligatorio");
            }
            if (correo == null || correo.isBlank()) {
                throw new IllegalArgumentException("El correo es obligatorio");
            }

            usuarioActual.setNombreCompleto(nombre.trim());
            usuarioActual.setTelefono(telefono.trim());
            usuarioActual.setCorreoElectronico(correo.trim());
            usuarioActual.setEdad(edad != null ? edad : 0);
        }

        public List<Direccion> listarDirecciones() {
            return usuarioActual.getDireccionesFrecuentes();
        }

        public void guardarDireccion(Direccion direccion) {
            if (direccion == null) {
                throw new IllegalArgumentException("La dirección es obligatoria");
            }
            usuarioActual.agregarDireccion(direccion);
        }

        public void eliminarDireccion(String idDireccion) {
            usuarioActual.eliminarDireccion(idDireccion);
        }

        public List<MetodoPago> listarMetodosPago() {
            return usuarioActual.getMetodosPago();
        }

        public void guardarMetodoPago(MetodoPago metodoPago) {
            if (metodoPago == null) {
                throw new IllegalArgumentException("El método de pago es obligatorio");
            }
            usuarioActual.agregarMetodoPago(metodoPago);
        }

        public void eliminarMetodoPago(String idMetodo) {
            usuarioActual.eliminarMetodoPago(idMetodo);
        }

        public List<Envio> listarEnviosUsuario() {
            return plataforma.getListEnvios().stream()
                    .filter(envio -> envio.getUsuario().getID().equals(usuarioActual.getID()))
                    .toList();
        }

        public TarifaDTO cotizarEnvio(double distanciaKm, double pesoKg, double volumenM3,
                                      boolean prioridad, List<ServicioAdicional> serviciosAdicionales) {
            Tarifa tarifa = new Tarifa();
            return tarifa.cotizar(distanciaKm, pesoKg, volumenM3, prioridad, serviciosAdicionales);
        }

        public Envio crearSolicitudEnvio(Direccion origen, Direccion destino,
                                         double distanciaKm, double pesoKg, double volumenM3,
                                         boolean prioridad, List<ServicioAdicional> servicios,
                                         Paquete paquete) {
            if (origen == null || destino == null) {
                throw new IllegalArgumentException("Origen y destino son obligatorios");
            }
            TarifaDTO tarifa = cotizarEnvio(distanciaKm, pesoKg, volumenM3, prioridad, servicios);
            String idEnvio = "E-" + (plataforma.getListEnvios().size() + 1);
            Envio envio = new EnvioUrbano(
                    new EnvioMoto(),
                    usuarioActual,
                    null,
                    LocalDate.now(),
                    null,
                    origen,
                    destino,
                    distanciaKm,
                    pesoKg,
                    volumenM3,
                    prioridad,
                    tarifa.total(),
                    idEnvio,
                    EstadoEnvio.SOLICITADO,
                    paquete,
                    servicios
            );
            plataforma.agregarEnvio(envio);
            return envio;
        }

        public void cancelarEnvio(String idEnvio) {
            Envio envio = plataforma.getEnvio(idEnvio);
            if (envio == null) {
                throw new IllegalArgumentException("El envío no existe");
            }
            if (envio.getEstadoEnvio() != EstadoEnvio.SOLICITADO) {
                throw new IllegalStateException("Solo se pueden cancelar envíos solicitados");
            }
            plataforma.eliminarEnvio(idEnvio);
        }

        public Pago registrarPago(Envio envio, MetodoPago metodoPago) {
            if (envio == null) {
                throw new IllegalArgumentException("Selecciona un envío");
            }
            if (metodoPago == null) {
                throw new IllegalArgumentException("Selecciona un método de pago");
            }
            String idPago = "PAG-" + UUID.randomUUID();
            return plataforma.registrarPago(idPago, envio, envio.getPrecio(), LocalDate.now(), metodoPago, EstadoPago.APROBADO);
        }
}
