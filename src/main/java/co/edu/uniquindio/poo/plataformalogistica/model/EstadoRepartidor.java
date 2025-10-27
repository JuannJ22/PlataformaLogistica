package co.edu.uniquindio.poo.plataformalogistica.model;

public enum EstadoRepartidor {
        ACTIVO("Activo", "Disponible para recibir nuevos envíos"),
        INACTIVO("Inactivo", "No disponible para recibir envíos"),
        EN_RUTA("En Ruta", "Realizando entregas actualmente");

        private final String nombre;
        private final String descripcion;

        EstadoRepartidor(String nombre, String descripcion) {
            this.nombre = nombre;
            this.descripcion = descripcion;
        }

        public String getNombre() {
            return nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        @Override
        public String toString() {
            return nombre;
        }
}
