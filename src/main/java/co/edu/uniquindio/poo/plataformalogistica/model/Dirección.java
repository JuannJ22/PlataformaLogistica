package co.edu.uniquindio.poo.plataformalogistica.model;

import java.util.Objects;

public class Direccion {
    private final String id;
    private final String alias;
    private final String calle;
    private final String ciudad;
    private final String coordenadas;

    public Direccion(String id, String alias, String calle, String ciudad, String coordenadas) {
        this.id = Objects.requireNonNull(id, "El identificador de la dirección es obligatorio");
        this.alias = Objects.requireNonNullElse(alias, "");
        this.calle = Objects.requireNonNullElse(calle, "");
        this.ciudad = Objects.requireNonNullElse(ciudad, "");
        this.coordenadas = Objects.requireNonNullElse(coordenadas, "");
    }

    public String getId() { return id; }
    public String getAlias() { return alias; }
    public String getCalle() { return calle; }
    public String getCiudad() { return ciudad; }
    public String getCoordenadas() { return coordenadas; }

    @Override
    public String toString() {
        return alias + " - " + calle + ", " + ciudad;
    }
}
