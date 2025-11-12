package co.edu.uniquindio.poo.plataformalogistica.model;
import java.util.ArrayList;
import java.util.List;

public class Administrador {

    private String ID;
    private String nombre;
    private String correo;
    private String telefono;
    private List<Usuario> listUsuarios;
    private List<Repartidor> listRepartidores;

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
        this.listUsuarios = new ArrayList<>();
    }

    //CURD USUARIO

    public void AgregarUsuario(Usuario usuario) {
        listUsuarios.add(usuario);
        System.out.println("Usuario agregado correctamente: " + usuario.getNombreCompleto());
    }

    // VER USUARIO

    public Usuario getUsuarioPorId(String ID) {
        if (listUsuarios.isEmpty()) {
            System.out.println("No hay usuariios registrados.");
        } else {
            for (Usuario usuario : listUsuarios) {
                if (usuario.getID().equals(ID)) {
                    return usuario;
                }
            }
            return null;
        }

        return null;
    }

    //ACTUALIZAR USUARIO

    public void setUsuario(String ID, String nuevoNombre, String nuevoTelefono, int nuevaEdad, String nuevoCorreo) {
        for (Usuario usuario : listUsuarios) {
            if (usuario.getID().equals(ID)) {

                // Se actualizan los campos individuales del usuario existente
                usuario.setNombreCompleto(nuevoNombre);
                usuario.setTelefono(nuevoTelefono);
                usuario.setEdad(nuevaEdad);
                usuario.setCorreoElectronico(nuevoCorreo);

                System.out.println("Usuario con ID " + ID + " actualizado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un usuario con el ID: " + ID);
    }


    //ELIMINAR USUARIO
    public void eliminarUsuario(String ID) {
        boolean eliminado = listUsuarios.removeIf(usuario -> usuario.getID().equals(ID));

        if (eliminado) {
            System.out.println("Usuario con ID " + ID + " eliminado correctamente");
        } else {
            System.out.println("No se encontró un usuario con el ID: " + ID);
        }
    }

    //CRUD REPARTIDOR

    // Agregar repartidor
    public void agregarRepartidor(Repartidor repartidor) {
        listRepartidores.add(repartidor);
        System.out.println("Repartidor agregado correctamente: " + repartidor.getNombre());
    }

    //Get repartidor por ID
    public Repartidor getRepartidor(String id) {
        for (Repartidor repartidor : listRepartidores) {
            if (repartidor.getID().equals(id)) {
                return repartidor;
            }
        }
        System.out.println("No se encontró un repartidor con el ID: " + id);
        return null;
    }

    //setRpeartidor

    public void setRepartidor(String ID, String nuevoNombre, String nuevoDocumento, String nuevoTelefono, boolean nuevaDisponibilidad, String nuevaZonaCobertura) {
        for (Repartidor repartidor : listRepartidores) {
            if (repartidor.getID().equals(ID)) {
                repartidor.setNombre(nuevoNombre);
                repartidor.setDocumento(nuevoDocumento);
                repartidor.setTelefono(nuevoTelefono);
                repartidor.setDisponibilidad(nuevaDisponibilidad);
                repartidor.setZonaCobertura(nuevaZonaCobertura);

                System.out.println("Repartidor con ID " + ID + " actualizado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un repartidor con el ID: " + ID);
    }

    //Eliminar repartidor

    public void eliminarRepartidor(String ID) {
        for (Repartidor repartidor : listRepartidores) {
            if (repartidor.getID().equals(ID)) {
                listRepartidores.remove(repartidor);
                System.out.println("Repartidor con ID " + ID + " eliminado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un repartidor con el ID: " + ID);
    }


    //GETTER Y SETTER DE LA CLASE ADMIN


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

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }
}

