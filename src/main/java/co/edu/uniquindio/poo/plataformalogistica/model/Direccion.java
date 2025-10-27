package co.edu.uniquindio.poo.plataformalogistica.model;

import java.util.Objects;

/**
 * Objeto Dirección que representa los lugares de origen o destino de un envío.
 */
public class Direccion {
    private String idDireccion;
    private String alias;
    private String calle;
    private String ciudad;
    private double latitud;
    private double longitud;
    private String codigoPostal;
    private String barrio;

    public Direccion() {
    }

    public Direccion(String idDireccion, String alias, String calle, String ciudad, 
                    double latitud, double longitud) {
        this.idDireccion = idDireccion;
        this.alias = alias;
        this.calle = calle;
        this.ciudad = ciudad;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Direccion(String idDireccion, String alias, String calle, String ciudad, 
                    double latitud, double longitud, String codigoPostal, String barrio) {
        this(idDireccion, alias, calle, ciudad, latitud, longitud);
        this.codigoPostal = codigoPostal;
        this.barrio = barrio;
    }

    // Getters y Setters
    public String getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(String idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

}