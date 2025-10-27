package co.edu.uniquindio.poo.plataformalogistica.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Objeto Usuario que representa a las personas que utilizan la plataforma
 * para solicitar y gestionar envíos.
 */
public class Usuario extends Persona {
    private String correoElectronico;
    private String numeroTelefono;
    private List<Direccion> direccionesFrecuentes;
    private List<MetodoPago> metodosPago;
    private List<Envio> envios;

    public Usuario(String nombre, String ID, String correoElectronico, String numeroTelefono) {
        super(nombre,ID);
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
        this.direccionesFrecuentes = new ArrayList<>();
        this.metodosPago = new ArrayList<>();
        this.envios = new ArrayList<>();
    }

    // Getters y Setters
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public List<Direccion> getDireccionesFrecuentes() {
        return direccionesFrecuentes;
    }

    public void setDireccionesFrecuentes(List<Direccion> direccionesFrecuentes) {
        this.direccionesFrecuentes = direccionesFrecuentes;
    }

    public List<MetodoPago> getMetodosPago() {
        return metodosPago;
    }

    public void setMetodosPago(List<MetodoPago> metodosPago) {
        this.metodosPago = metodosPago;
    }

    public List<Envio> getEnvios() {
        return envios;
    }

    public void setEnvios(List<Envio> envios) {
        this.envios = envios;
    }

    // Métodos de negocio
    public void agregarDireccion(Direccion direccion) {
        if (direccion != null && !direccionesFrecuentes.contains(direccion)) {
            direccionesFrecuentes.add(direccion);
        }
    }

    public void eliminarDireccion(Direccion direccion) {
        direccionesFrecuentes.remove(direccion);
    }

    public void agregarMetodoPago(MetodoPago metodoPago) {
        if (metodoPago != null && !metodosPago.contains(metodoPago)) {
            metodosPago.add(metodoPago);
        }
    }

    public void eliminarMetodoPago(MetodoPago metodoPago) {
        metodosPago.remove(metodoPago);
    }

    public void agregarEnvio(Envio envio) {
        if (envio != null && !envios.contains(envio)) {
            envios.add(envio);
            envio.setUsuario(this);
        }
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario='" + ID + '\'' +
                ", nombreCompleto='" + nombre + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                '}';
    }
}