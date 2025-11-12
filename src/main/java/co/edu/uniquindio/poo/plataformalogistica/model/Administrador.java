package co.edu.uniquindio.poo.plataformalogistica.model;

public class Administrador {

    private String ID;
    private String nombre;
    private String correo;
    private String telefono;

    // Se pasa la plataforma como singleton para que acceda a ella
    private final PlataformaLogistica plataforma;

    /**
     * Constructor clase administrador
     *
     * @param ID
     * @param nombre
     * @param correo
     * @param telefono
     */
    public Administrador(String ID, String nombre, String correo, String telefono) {
        this.ID = ID;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;

        // Usamos la instancia única de la plataforma
        this.plataforma = PlataformaLogistica.getInstancia();
    }

    // =========================
    // CRUD USUARIO (delegando en PlataformaLogistica)
    // =========================

    public void agregarUsuario(Usuario usuario) {
        plataforma.agregarUsuario(usuario);
        System.out.println("Usuario agregado correctamente: " + usuario.getNombreCompleto());
    }

    public Usuario getUsuarioPorId(String ID) {
        Usuario usuario = plataforma.getUsuario(ID);
        if (usuario == null) {
            System.out.println("No se encontró un usuario con el ID: " + ID);
        }
        return usuario;
    }

    public void setUsuario(String ID, String nuevoNombre, String nuevoTelefono,
                           int nuevaEdad, String nuevoCorreo) {
        Usuario usuario = plataforma.getUsuario(ID);
        if (usuario != null) {
            plataforma.setUsuario(ID, nuevoNombre, nuevoTelefono, nuevaEdad, nuevoCorreo);
            System.out.println("Usuario con ID " + ID + " actualizado correctamente.");
        } else {
            System.out.println("No se encontró un usuario con el ID: " + ID);
        }
    }

    public void eliminarUsuario(String ID) {
        plataforma.eliminarUsuario(ID);
        // (si quieres, aquí puedes imprimir siempre el mensaje, o validar antes)
        System.out.println("Solicitud de eliminación para usuario con ID " + ID);
    }

    // =========================
    // CRUD REPARTIDOR (delegando en PlataformaLogistica)
    // =========================

    public void agregarRepartidor(Repartidor repartidor) {
        plataforma.agregarRepartidor(repartidor);
        System.out.println("Repartidor agregado correctamente: " + repartidor.getNombre());
    }

    public Repartidor getRepartidor(String id) {
        Repartidor repartidor = plataforma.getRepartidor(id);
        if (repartidor == null) {
            System.out.println("No se encontró un repartidor con el ID: " + id);
        }
        return repartidor;
    }

    public void setRepartidor(String ID, String nuevoNombre, String nuevoDocumento,
                              String nuevoTelefono,
                              DisponibilidadRepartidor disponibilidadRepartidor,
                              String nuevaZonaCobertura) {

        Repartidor repartidor = plataforma.getRepartidor(ID);
        if (repartidor != null) {
            plataforma.setRepartidor(ID, nuevoNombre, ID, nuevoTelefono,
                    disponibilidadRepartidor, nuevaZonaCobertura);
            System.out.println("Repartidor con ID " + ID + " actualizado correctamente.");
        } else {
            System.out.println("No se encontró un repartidor con el ID: " + ID);
        }
    }

    public void eliminarRepartidor(String ID) {
        plataforma.eliminarRepartidor(ID);
        System.out.println("Solicitud de eliminación para repartidor con ID " + ID);
    }

    // =========================
    // GETTERS Y SETTERS BÁSICOS
    // =========================

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
