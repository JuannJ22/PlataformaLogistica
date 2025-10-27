package co.edu.uniquindio.poo.plataformalogistica.patterns.creational;

import co.edu.uniquindio.poo.plataformalogistica.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Platamorma logística para la gestión centralizada de la plataforma logística.
 */
public class PlataformaLogisticaSingleton {
    private static volatile PlataformaLogisticaSingleton instance;
    
    private List<Usuario> usuarios;
    private List<Repartidor> repartidores;
    private List<Envio> envios;
    private List<ServicioAdicional> serviciosAdicionales;
    private Tarifa tarifaActual;
    
    // Constructor privado para evitar instanciación externa
    private PlataformaLogisticaSingleton() {
        inicializarDatos();
    }
    
    /**
     * Método thread-safe para obtener la instancia única
     */
    public static PlataformaLogisticaSingleton getInstance() {
        if (instance == null) {
            synchronized (PlataformaLogisticaSingleton.class) {
                if (instance == null) {
                    instance = new PlataformaLogisticaSingleton();
                }
            }
        }
        return instance;
    }
    
    private void inicializarDatos() {
        usuarios = new ArrayList<>();
        repartidores = new ArrayList<>();
        envios = new ArrayList<>();
        serviciosAdicionales = new ArrayList<>();
        
        // Inicializar tarifa por defecto
        tarifaActual = new Tarifa("TAR001", "Tarifa Estándar");
        
        // Inicializar servicios adicionales por defecto
        inicializarServiciosAdicionales();
    }
    
    private void inicializarServiciosAdicionales() {
        serviciosAdicionales.add(new ServicioAdicional("SRV001", 
            TipoServicioAdicional.SEGURO, "Seguro Básico", 
            "Protección contra daños hasta $500,000", 5.0));
        
        serviciosAdicionales.add(new ServicioAdicional("SRV002", 
            TipoServicioAdicional.FRAGIL, "Manejo Frágil", 
            "Cuidado especial para objetos delicados", 3000.0));
        
        serviciosAdicionales.add(new ServicioAdicional("SRV003", 
            TipoServicioAdicional.PRIORIDAD, "Entrega Prioritaria", 
            "Entrega en menos de 4 horas", 8000.0));
        
        serviciosAdicionales.add(new ServicioAdicional("SRV004", 
            TipoServicioAdicional.FIRMA_REQUERIDA, "Firma Requerida", 
            "Requiere firma del destinatario", 2000.0));
    }
    
    // Métodos de gestión de usuarios
    public void agregarUsuario(Usuario usuario) {
        if (usuario != null && !usuarios.contains(usuario)) {
            usuarios.add(usuario);
        }
    }
    
    public Optional<Usuario> buscarUsuario(String idUsuario) {
        return usuarios.stream()
                .filter(u -> u.getIdUsuario().equals(idUsuario))
                .findFirst();
    }
    
    public List<Usuario> getUsuarios() {
        return new ArrayList<>(usuarios);
    }
    
    // Métodos de gestión de repartidores
    public void agregarRepartidor(Repartidor repartidor) {
        if (repartidor != null && !repartidores.contains(repartidor)) {
            repartidores.add(repartidor);
        }
    }
    
    public Optional<Repartidor> buscarRepartidor(String idRepartidor) {
        return repartidores.stream()
                .filter(r -> r.getIdRepartidor().equals(idRepartidor))
                .findFirst();
    }
    
    public List<Repartidor> getRepartidoresDisponibles() {
        return repartidores.stream()
                .filter(Repartidor::estaDisponible)
                .collect(Collectors.toList());
    }
    
    public List<Repartidor> getRepartidores() {
        return new ArrayList<>(repartidores);
    }
    
    // Métodos de gestión de envíos
    public void agregarEnvio(Envio envio) {
        if (envio != null && !envios.contains(envio)) {
            envios.add(envio);
        }
    }
    
    public Optional<Envio> buscarEnvio(String idEnvio) {
        return envios.stream()
                .filter(e -> e.getIdEnvio().equals(idEnvio))
                .findFirst();
    }
    
    public List<Envio> getEnvios() {
        return new ArrayList<>(envios);
    }
    
    public List<Envio> getEnviosPorUsuario(String idUsuario) {
        return envios.stream()
                .filter(e -> e.getUsuario() != null && 
                           e.getUsuario().getIdUsuario().equals(idUsuario))
                .collect(Collectors.toList());
    }
    
    public List<Envio> getEnviosPorEstado(EstadoEnvio estado) {
        return envios.stream()
                .filter(e -> e.getEstado() == estado)
                .collect(Collectors.toList());
    }
    
    // Métodos de gestión de servicios adicionales
    public List<ServicioAdicional> getServiciosAdicionales() {
        return new ArrayList<>(serviciosAdicionales);
    }
    
    public List<ServicioAdicional> getServiciosAdicionalesActivos() {
        return serviciosAdicionales.stream()
                .filter(ServicioAdicional::isActivo)
                .collect(Collectors.toList());
    }
    
    // Métodos de gestión de tarifas
    public Tarifa getTarifaActual() {
        return tarifaActual;
    }
    
    public void setTarifaActual(Tarifa tarifa) {
        this.tarifaActual = tarifa;
    }
    
    // Método para calcular costo de envío
    public double calcularCostoEnvio(Envio envio) {
        if (tarifaActual != null && tarifaActual.puedeAplicarse(envio)) {
            return tarifaActual.calcularCosto(envio);
        }
        return 0.0;
    }
    
    // Estadísticas generales
    public int getTotalUsuarios() {
        return usuarios.size();
    }
    
    public int getTotalRepartidores() {
        return repartidores.size();
    }
    
    public int getTotalEnvios() {
        return envios.size();
    }
    
    public int getEnviosEntregados() {
        return (int) envios.stream()
                .filter(e -> e.getEstado() == EstadoEnvio.ENTREGADO)
                .count();
    }
    
    // Método para limpiar datos (útil para testing)
    public void limpiarDatos() {
        usuarios.clear();
        repartidores.clear();
        envios.clear();
        serviciosAdicionales.clear();
        inicializarServiciosAdicionales();
    }
}