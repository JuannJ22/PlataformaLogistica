package co.edu.uniquindio.poo.plataformalogistica.model;

public class Administrador {

    private String ID;
    private String nombre;
    private String correo;
    private String telefono;

    // Referencia al Singleton (Facade) de la plataforma
    // Usa el getInstancia() SIN parámetros (ya debiste haber inicializado antes en el bootstrap)
    private final PlataformaLogistica plataforma;

    /**
     * Constructor clase administrador
     */

    public Administrador(String ID, String nombre, String correo, String telefono) {
        this.ID = ID;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;

 
        this.plataforma= PlataformaLogistica.getInstancia();
    }

    //CURD USUARIO

    public void AgregarUsuario(Usuario usuario) {
        plataforma.getListUsuarios().add(usuario);
        System.out.println("Usuario agregado correctamente: " + usuario.getNombreCompleto());
    }

    // VER USUARIO

    /**
     * Busca un usuario por su ID dentro de la lista de usuarios de la plataforma.
     *
     * @param ID El identificador único del usuario a buscar.
     * @param plataforma El objeto PlataformaLogistica que contiene la lista de usuarios.
     * @return El objeto Usuario si se encuentra, o null si no se encuentra.
     */
    public Usuario getUsuario(String ID, PlataformaLogistica plataforma) {
                return plataforma.getUsuario(ID);
            }



    //ACTUALIZAR USUARIO

    public void setUsuario (String ID, String nombreCompleto, String telefono, int edad, String correoElectronico, PlataformaLogistica plataforma) {
        plataforma.setUsuario(ID, nombreCompleto, telefono, edad, correoElectronico );
    }


    //ELIMINAR USUARIO
    public void eliminarUsuario(String ID, PlataformaLogistica plataforma) {
        plataforma.getListUsuarios().remove(ID);

    }

    // =========================
    // CRUD USUARIO (usando el singleton de plataorma logísitca)
    // =========================

    public void agregarUsuario(Usuario usuario) {
        plataforma.agregarUsuario(usuario);
        System.out.println("Usuario agregado correctamente: " + usuario.getNombreCompleto());
    }

    public Usuario getUsuarioPorId(String id) {
        Usuario usuario = plataforma.getUsuario(id);
        if (usuario == null) {
            System.out.println("No se encontró un usuario con el ID: " + id);
        }
        return usuario;
    }

    public void setUsuario(String id, String nuevoNombre, String nuevoTelefono,
                           int nuevaEdad, String nuevoCorreo) {
        Usuario usuario = plataforma.getUsuario(id);
        if (usuario != null) {
            plataforma.setUsuario(id, nuevoNombre, nuevoTelefono, nuevaEdad, nuevoCorreo);
            System.out.println("Usuario con ID " + id + " actualizado correctamente.");
        } else {
            System.out.println("No se encontró un usuario con el ID: " + id);
        }
    }

    public void eliminarUsuario(String id) {
        plataforma.eliminarUsuario(id); // NO intentes remove(id) sobre la lista
        System.out.println("Solicitud de eliminación para usuario con ID " + id);
    }

    // =========================
    // CRUD REPARTIDOR (delegando del singleton de PlataformaLogistica)
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

    public void setRepartidor(String id, String nuevoNombre, String nuevoDocumento,
                              String nuevoTelefono,
                              DisponibilidadRepartidor disponibilidadRepartidor,
                              String nuevaZonaCobertura) {

        Repartidor repartidor = plataforma.getRepartidor(id);
        if (repartidor != null) {
            plataforma.setRepartidor(id, nuevoNombre, nuevoDocumento, nuevoTelefono,
                    disponibilidadRepartidor, nuevaZonaCobertura);
            System.out.println("Repartidor con ID " + id + " actualizado correctamente.");
        } else {
            System.out.println("No se encontró un repartidor con el ID: " + id);
        }
    }

    public void eliminarRepartidor(String id) {
        plataforma.eliminarRepartidor(id);
        System.out.println("Solicitud de eliminación para repartidor con ID " + id);
    }

    // GETTERS Y SETTERS

    public String getID() { return ID; }
    public void setID(String ID) { this.ID = ID; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
