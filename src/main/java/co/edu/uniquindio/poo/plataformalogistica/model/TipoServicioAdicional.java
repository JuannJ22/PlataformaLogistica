package co.edu.uniquindio.poo.plataformalogistica.model;

public enum TipoServicioAdicional {
    SEGURO("Seguro", "Protección del paquete contra daños o pérdida", true),
    FRAGIL("Frágil", "Manejo especial para objetos delicados", false),
    FIRMA_REQUERIDA("Firma Requerida", "Requiere firma del destinatario", false),
    PRIORIDAD("Prioridad", "Entrega prioritaria", false),
    ENTREGA_NOCTURNA("Entrega Nocturna", "Entrega en horario nocturno", false),
    EMPAQUE_ESPECIAL("Empaque Especial", "Empaque adicional de protección", false);

    private final String nombre;
    private final String descripcion;
    private final boolean esPorcentaje;

    TipoServicioAdicional(String nombre, String descripcion, boolean esPorcentaje) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.esPorcentaje = esPorcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean esPorcentaje() {
        return esPorcentaje;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
