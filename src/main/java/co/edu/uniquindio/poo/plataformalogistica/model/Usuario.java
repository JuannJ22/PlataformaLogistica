package co.edu.uniquindio.poo.plataformalogistica.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String ID;
    private String nombreCompleto;
    private String telefono;
    private int edad;
    private String correoElectronico;

    // Constructor (Builder)
    private Usuario(Builder builder) {
        this.ID = builder.ID;
        this.nombreCompleto = builder.nombreCompleto;
        this.telefono = builder.telefono;
        this.edad = builder.edad;
        this.correoElectronico = builder.correoElectronico;
    }

    // Clase Builder interna
    public static class Builder {
        private String ID;
        private String nombreCompleto;
        private String telefono;
        private int edad;
        private String correoElectronico;

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
}

