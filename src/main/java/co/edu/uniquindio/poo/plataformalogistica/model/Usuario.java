package co.edu.uniquindio.poo.plataformalogistica.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String ID;
    private String nombreCompleto;
    private String telefono;
    private int edad;
    private String correoElectronico;
    private final List<Direccion> direccionesFrecuentes;
    private final List<MetodoPago> metodosPago;

    // Constructor (Builder)
    private Usuario(Builder builder) {
        this.ID = builder.ID;
        this.nombreCompleto = builder.nombreCompleto;
        this.telefono = builder.telefono;
        this.edad = builder.edad;
        this.correoElectronico = builder.correoElectronico;
        this.direccionesFrecuentes = new ArrayList<>(builder.direccionesFrecuentes);
        this.metodosPago = new ArrayList<>(builder.metodosPago);
    }

    // Clase Builder interna
    public static class Builder {
        private String ID;
        private String nombreCompleto;
        private String telefono;
        private int edad;
        private String correoElectronico;
        private final List<Direccion> direccionesFrecuentes = new ArrayList<>();
        private final List<MetodoPago> metodosPago = new ArrayList<>();

        // Constructor del Builder con los campos obligatorios
        public Builder(String ID, String nombreCompleto, String telefono) {
            this.ID= ID;
            this.nombreCompleto = nombreCompleto;
            this.telefono = telefono;
        }

        // Métodos opcionales
        public Builder setEdad(int edad) {
            this.edad = edad;
            return this;
        }

        public Builder setCorreoElectronico(String correoElectronico) {
            this.correoElectronico = correoElectronico;
            return this;
        }
        public Builder agregarDireccion(Direccion direccion) {
            if (direccion != null) {
                this.direccionesFrecuentes.add(direccion);
            }
            return this;
        }

        public Builder agregarMetodoPago(MetodoPago metodoPago) {
            if (metodoPago != null) {
                this.metodosPago.add(metodoPago);
            }
            return this;
        }

        // METODO CONSTRUIR
        public Usuario build() {
            return new Usuario(this);
        }
    }

    /**
     * Metodos getter y setter
     * @return
     */
    public String getID() {
        return ID;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getEdad() {
        return edad;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<Direccion> getDireccionesFrecuentes() {
        return new ArrayList<>(direccionesFrecuentes);
    }

    public List<MetodoPago> getMetodosPago() {
        return new ArrayList<>(metodosPago);
    }

    public void agregarDireccion(Direccion direccion) {
        if (direccion == null) return;
        direccionesFrecuentes.removeIf(d -> d.getId().equalsIgnoreCase(direccion.getId()));
        direccionesFrecuentes.add(direccion);
    }

    public void eliminarDireccion(String idDireccion) {
        if (idDireccion == null) return;
        direccionesFrecuentes.removeIf(d -> d.getId().equalsIgnoreCase(idDireccion));
    }

    public void agregarMetodoPago(MetodoPago metodoPago) {
        if (metodoPago == null) return;
        metodosPago.removeIf(m -> m.getId().equalsIgnoreCase(metodoPago.getId()));
        metodosPago.add(metodoPago);
    }

    public void eliminarMetodoPago(String idMetodo) {
        if (idMetodo == null) return;
        metodosPago.removeIf(m -> m.getId().equalsIgnoreCase(idMetodo));
    }
}

