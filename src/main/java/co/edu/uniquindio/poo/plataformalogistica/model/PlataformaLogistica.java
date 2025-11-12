package co.edu.uniquindio.poo.plataformalogistica.model;

public class PlataformaLogistica {

        private String nit;
        private String nombre;
        private String telefono;

        // Instancia única (Singleton)
        private static PlataformaLogistica instancia;

    /**
     * Constructor clase plataformaLogistica
     * @param nit
     * @param nombre
     * @param telefono
     */
        private PlataformaLogistica(String nit, String nombre, String telefono) {
            this.nit = nit;
            this.nombre = nombre;
            this.telefono = telefono;
        }

        //Instancia única (Singleton)
        public static PlataformaLogistica getInstancia(String nit, String nombre, String telefono) {
            if (instancia == null) {
                instancia = new PlataformaLogistica(nit, nombre, telefono);
            }
            return instancia;
        }

        // Getters y Setters
        public String getNit() {
            return nit;
        }

        public void setNit(String nit) {
            this.nit = nit;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

    }
