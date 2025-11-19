package co.edu.uniquindio.poo.plataformalogistica.model;

public enum ServicioAdicional {
    SEGURO("Seguro contra daños"),
    MANEJO_FRAGIL("Manejo frágil"),
    FIRMA_REQUERIDA("Firma requerida"),
    PRIORIDAD("Entrega prioritaria"),
    REFRIGERADO("Cadena de frío");

    private final String descripcion;

    ServicioAdicional(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
