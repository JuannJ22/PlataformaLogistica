package co.edu.uniquindio.poo.plataformalogistica.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlataformaLogistica {

    private String nit;
    private String nombre;
    private String telefono;

    private List<Administrador> listAdministradores;
    private List<Repartidor>    listRepartidores;
    private List<Usuario>       listUsuarios;
    private List<Envio>         listEnvios;
    private List<Paquete>       listPaquetes;
    private List<Pago>          listPagos;
    private List<Incidencia>    listIncidencias;
    private List<Tarifa>        listTarifas;

    // Strategy para asignación
    private AsignacionRepartidorStrategy estrategiaAsignacion;

    // Singleton
    private static PlataformaLogistica instancia;

    /** Constructor privado (Singleton) */
    private PlataformaLogistica(String nit, String nombre, String telefono) {
        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;

        this.listAdministradores = new ArrayList<>();
        this.listRepartidores    = new ArrayList<>();
        this.listUsuarios        = new ArrayList<>();
        this.listEnvios          = new ArrayList<>();
        this.listPaquetes        = new ArrayList<>();
        this.listPagos           = new ArrayList<>();
        this.listIncidencias     = new ArrayList<>();
        this.listTarifas         = new ArrayList<>();

        this.estrategiaAsignacion = new AsignacionPorDisponibilidadStrategy();
    }

    private static final String DEFAULT_NIT = "000000000";
    private static final String DEFAULT_NOMBRE = "Plataforma Logística";
    private static final String DEFAULT_TELEFONO = "0000000";

    // Inicializa (si hace falta) y retorna la instancia
    public static PlataformaLogistica getInstancia(String nit, String nombre, String telefono) {
        PlataformaLogistica plataforma = getInstancia();
        plataforma.setNit(nit);
        plataforma.setNombre(nombre);
        plataforma.setTelefono(telefono);
        return plataforma;
    }

    // Retorna la instancia ya inicializada
    public static PlataformaLogistica getInstancia() {
        if (instancia == null) {
            instancia = new PlataformaLogistica(DEFAULT_NIT, DEFAULT_NOMBRE, DEFAULT_TELEFONO);
        }
        return instancia;
    }

    // Útil para tests
    public static void setInstancia(PlataformaLogistica instancia) {
        PlataformaLogistica.instancia = instancia;
    }

    // ========================
    // Getters / Setters básicos
    // ========================

    public String getNit() { return nit; }
    public void setNit(String nit) { this.nit = nit; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public List<Administrador> getListAdministradores() { return listAdministradores; }
    public void setListAdministradores(List<Administrador> listAdministradores) { this.listAdministradores = listAdministradores; }

    public List<Repartidor> getListRepartidores() { return listRepartidores; }
    public void setListRepartidores(List<Repartidor> listRepartidores) { this.listRepartidores = listRepartidores; }

    public List<Usuario> getListUsuarios() { return listUsuarios; }
    public void setListUsuarios(List<Usuario> listUsuarios) { this.listUsuarios = listUsuarios; }

    public List<Envio> getListEnvios() { return listEnvios; }
    public void setListEnvios(List<Envio> listEnvios) { this.listEnvios = listEnvios; }

    public List<Paquete> getListPaquetes() { return listPaquetes; }
    public void setListPaquetes(List<Paquete> listPaquetes) { this.listPaquetes = listPaquetes; }

    public List<Pago> getListPagos() { return listPagos; }

    public List<Incidencia> getListIncidencias() { return listIncidencias; }

    public List<Tarifa> getListTarifas() { return listTarifas; }
    public void setListTarifas(List<Tarifa> listTarifas) { this.listTarifas = listTarifas; }

    public AsignacionRepartidorStrategy getEstrategiaAsignacion() { return estrategiaAsignacion; }
    public void setEstrategiaAsignacion(AsignacionRepartidorStrategy estrategiaAsignacion) { this.estrategiaAsignacion = estrategiaAsignacion; }

    // ==============
    // CRUD: Admin
    // ==============

    public void agregarAdministrador(Administrador administrador) {
        this.listAdministradores.add(administrador);
    }

    public void setAdministrador(String ID, String nuevoNombre, String Nuevocorreo, String nuevoID, String nuevoTelefono) {
        for (Administrador administrador : listAdministradores) {
            if (administrador.getID().equals(ID)) {
                administrador.setNombre(nuevoNombre);
                administrador.setCorreo(Nuevocorreo);
                administrador.setID(nuevoID);
                administrador.setTelefono(nuevoTelefono);
                System.out.println("Administrador con ID " + ID + " actualizado correctamente.");
                return;
            }
        }
        Administrador nuevoAdministrador = new Administrador(nuevoID, nuevoNombre, Nuevocorreo, nuevoTelefono);
        listAdministradores.add(nuevoAdministrador);
        System.out.println("Administrador con ID " + ID + " no existía. Se creó uno nuevo con ID " + nuevoID + ".");
    }

    public void eliminarAdministrador(String ID) {
        listAdministradores.removeIf(adm -> adm.getID().equals(ID));
    }

    public Administrador getAdministrador(String ID) {
        for (Administrador administrador : listAdministradores) {
            if (administrador.getID().equals(ID)) {
                System.out.println("Administrador encontrado: " + administrador.getNombre());
                return administrador;
            }
        }
        System.out.println("No se encontró un administrador con el ID: " + ID);
        return null;
    }

    // ==============
    // CRUD: Repartidor
    // ==============

    public void agregarRepartidor(Repartidor repartidor) {
        this.listRepartidores.add(repartidor);
    }

    public void setRepartidor(String ID, String nuevoNombre, String nuevoTelefono,
                              DisponibilidadRepartidor disponibilidadRepartidor, String nuevaZonaCobertura) {
        for (Repartidor repartidor : listRepartidores) {
            if (repartidor.getID().equals(ID)) {
                repartidor.setNombre(nuevoNombre);
                repartidor.setTelefono(nuevoTelefono);
                repartidor.setDisponibilidadRepartidor(disponibilidadRepartidor);
                repartidor.setZonaCobertura(nuevaZonaCobertura);
                System.out.println("Repartidor con ID " + ID + " actualizado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un repartidor con el ID: " + ID);
    }

    public void eliminarRepartidor(String ID) {
        listRepartidores.removeIf(rep -> rep.getID().equals(ID));
    }

    public Repartidor getRepartidor(String ID) {
        for (Repartidor repartidor : listRepartidores) {
            if (repartidor.getID().equals(ID)) {
                System.out.println("Repartidor encontrado: " + repartidor.getNombre());
                return repartidor;
            }
        }
        System.out.println("No se encontró un repartidor con el ID: " + ID);
        return null;
    }

    // ==============
    // CRUD: Envío
    // ==============

    public void agregarEnvio(Envio envio) {
        this.listEnvios.add(envio);
    }

    public void eliminarEnvio(String ID) {
        listEnvios.removeIf(envio -> envio.getID().equals(ID));
    }

    public Envio getEnvio(String ID) {
        for (Envio envio : listEnvios) {
            if (envio.getID().equals(ID)) {
                System.out.println("Envio encontrado: " + envio);
                return envio;
            }
        }
        System.out.println("No se encontró un Envio con el ID: " + ID);
        return null;
    }

    // ==============
    // CRUD: Usuario
    // ==============

    public void agregarUsuario(Usuario usuario) {
        this.listUsuarios.add(usuario);
    }

    public void setUsuario(String ID, String nombreCompleto, String telefono, int edad, String correoElectronico) {
        for (Usuario usuario : listUsuarios) {
            if (usuario.getID().equals(ID)) {
                usuario.setNombreCompleto(nombreCompleto);
                usuario.setTelefono(telefono);
                usuario.setEdad(edad);
                usuario.setCorreoElectronico(correoElectronico);
                System.out.println("Usuario con ID " + ID + " actualizado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un Usuario con el ID: " + ID);
    }

    public void eliminarUsuario(String ID) {
        listUsuarios.removeIf(usuario -> usuario.getID().equals(ID));
    }

    public Usuario getUsuario(String ID) {
        for (Usuario usuario : listUsuarios) {
            if (usuario.getID().equals(ID)) {
                System.out.println("Usuario:: " + usuario.getNombreCompleto());
                return usuario;
            }
        }
        System.out.println("No se encontró un Usuario con el ID: " + ID);
        return null;
    }

    // =========================
    // Asignación / Reasignación
    // =========================

    public void asignarEnvioAutomatico(String idEnvio) {
        Envio envio = getEnvio(idEnvio);
        if (envio == null) {
            throw new IllegalArgumentException("El envío con ID " + idEnvio + " no existe");
        }
        if (envio.getEstadoEnvio() != EstadoEnvio.SOLICITADO) {
            throw new IllegalStateException("Solo se pueden asignar envíos en estado SOLICITADO");
        }

        Repartidor elegido = estrategiaAsignacion.asignar(envio, listRepartidores);
        if (elegido == null) {
            throw new IllegalStateException("No hay repartidores disponibles (ACTIVOS)");
        }

        envio.setRepartidor(elegido);
        envio.setEstadoEnvio(EstadoEnvio.ASIGNADO);
    }

    public void reasignarEnvioManualmente(String idEnvio, String idRepartidor) {
        Envio envio = getEnvio(idEnvio);
        Repartidor repartidor = getRepartidor(idRepartidor);

        if (envio == null || repartidor == null) {
            throw new IllegalArgumentException("Envío o repartidor no existen");
        }
        if (repartidor.getDisponibilidadRepartidor() != DisponibilidadRepartidor.ACTIVO) {
            throw new IllegalStateException("El repartidor no está disponible");
        }

        envio.setRepartidor(repartidor);
        envio.setEstadoEnvio(EstadoEnvio.ASIGNADO);
    }

    // =========================
    // Métricas
    // =========================

    public Map<String, Double> calcularTiemposPromedioEntrega(LocalDate desde, LocalDate hasta) {
        Map<String, Double> sumaHorasPorZona = new HashMap<>();
        Map<String, Integer> conteoPorZona   = new HashMap<>();

        for (Envio envio : listEnvios) {
            LocalDate fecha = envio.getFechaEntregaReal();
            if (fecha != null &&
                    (fecha.isEqual(desde) || fecha.isAfter(desde)) &&
                    (fecha.isEqual(hasta) || fecha.isBefore(hasta))) {

                Repartidor repartidor = envio.getRepartidor();
                if (repartidor == null) continue;

                String zona = repartidor.getZonaCobertura();
                if (zona == null || zona.isBlank()) zona = "Sin zona";

                double horas = envio.getTiempoEntregaHoras();

                sumaHorasPorZona.merge(zona, horas, Double::sum);
                conteoPorZona.merge(zona, 1, Integer::sum);
            }
        }

        Map<String, Double> promedios = new HashMap<>();
        for (String zona : sumaHorasPorZona.keySet()) {
            double total = sumaHorasPorZona.get(zona);
            int cantidad = conteoPorZona.get(zona);
            promedios.put(zona, total / cantidad);
        }
        return promedios;
    }

    public Map<String, Double> calcularIngresosPorPeriodo(LocalDate desde, LocalDate hasta) {
        Map<String, Double> resultado = new HashMap<>();
        double totalIngresos = 0.0;

        for (Envio envio : listEnvios) {
            LocalDate fecha = envio.getFechaEntregaReal();
            if (fecha != null &&
                    (fecha.isEqual(desde) || fecha.isAfter(desde)) &&
                    (fecha.isEqual(hasta) || fecha.isBefore(hasta))) {
                totalIngresos += envio.getTarifa();
            }
        }

        resultado.put("totalIngresos", totalIngresos);
        return resultado;
    }

    public Map<String, Integer> calcularServiciosAdicionales(LocalDate desde, LocalDate hasta) {
        Map<String, Integer> conteo = new HashMap<>();
        for (Envio envio : listEnvios) {
            if (envio.getFechaCreacion() == null) continue;
            if (!estaEnRango(envio.getFechaCreacion(), desde, hasta)) continue;
            for (ServicioAdicional servicio : envio.getServiciosAdicionales()) {
                conteo.merge(servicio.name(), 1, Integer::sum);
            }
        }
        return conteo;
    }

    public Map<String, Integer> calcularIncidenciasPorZona(LocalDate desde, LocalDate hasta) {
        Map<String, Integer> resultado = new HashMap<>();
        for (Incidencia incidencia : listIncidencias) {
            if (!estaEnRango(incidencia.getFecha(), desde, hasta)) continue;
            resultado.merge(incidencia.getZona(), 1, Integer::sum);
        }
        return resultado;
    }

    public void registrarIncidencia(Envio envio, String descripcion) {
        if (envio == null) return;
        String id = "INC-" + (listIncidencias.size() + 1);
        String zona = envio.getRepartidor() != null ? envio.getRepartidor().getZonaCobertura() : "Sin zona";
        Incidencia incidencia = new Incidencia(id, envio.getID(), descripcion, LocalDate.now(), zona);
        listIncidencias.add(incidencia);
        envio.setEstadoEnvio(EstadoEnvio.INCIDENCIA);
    }

    public Pago registrarPago(String idPago, Envio envio, double monto, LocalDate fecha,
                              MetodoPago metodoPago, EstadoPago estadoPago) {
        if (envio == null) {
            throw new IllegalArgumentException("El envío es obligatorio para registrar un pago");
        }
        Pago pago = new Pago(idPago, envio.getID(), monto, fecha, metodoPago, estadoPago);
        listPagos.add(pago);
        return pago;
    }

    public List<Pago> listarPagosPorRango(LocalDate desde, LocalDate hasta) {
        List<Pago> resultados = new ArrayList<>();
        for (Pago pago : listPagos) {
            if (estaEnRango(pago.getFecha(), desde, hasta)) {
                resultados.add(pago);
            }
        }
        return resultados;
    }

    private boolean estaEnRango(LocalDate fecha, LocalDate desde, LocalDate hasta) {
        if (fecha == null) return false;
        boolean despues = desde == null || fecha.isEqual(desde) || fecha.isAfter(desde);
        boolean antes   = hasta == null || fecha.isEqual(hasta) || fecha.isBefore(hasta);
        return despues && antes;
    }
}
