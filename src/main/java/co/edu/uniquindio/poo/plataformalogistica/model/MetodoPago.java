package co.edu.uniquindio.poo.plataformalogistica.model;

import java.util.Objects;

public class MetodoPago {
    private final String id;
    private final String alias;
    private final String tipo;      // Ej: VISA, PSE
    private final String referencia;

    public MetodoPago(String id, String alias, String tipo, String referencia) {
        this.id = Objects.requireNonNull(id, "El identificador del método de pago es obligatorio");
        this.alias = Objects.requireNonNullElse(alias, "");
        this.tipo = Objects.requireNonNullElse(tipo, "");
        this.referencia = Objects.requireNonNullElse(referencia, "");
    }

    public String getId() { return id; }
    public String getAlias() { return alias; }
    public String getTipo() { return tipo; }
    public String getReferencia() { return referencia; }

    @Override
    public String toString() {
        return alias + " (" + tipo + ")";
    }
}
