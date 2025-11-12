package co.edu.uniquindio.poo.plataformalogistica.model;

import java.util.ArrayList;
import java.util.List;

public class PlataformaLogistica {

        private String nit;
        private String nombre;
        private String telefono;
        private List<Administrador> listAdministradores;
        private List<Repartidor> listRepartidores;
        private List<Usuario> listUsuarios;
        private List<Envio> listEnvios;



        //Strategy usado para asignar el repartidor
        private AsignacionRepartidorStrategy estrategiaAsignacion;
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
            this.listAdministradores = new ArrayList<>();
            this.listRepartidores = new ArrayList<>();
            this.listEnvios = new ArrayList<>();
            this.listUsuarios = new ArrayList<>();
            this.estrategiaAsignacion = new AsignacionPorDisponibilidadStrategy();


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

    public List<Administrador> getListAdministradores() {
        return listAdministradores;
    }

    public void setListAdministradores(List<Administrador> listAdministradores) {
        this.listAdministradores = listAdministradores;
    }

    public List<Repartidor> getListRepartidores() {
        return listRepartidores;
    }

    public void setListRepartidores(List<Repartidor> listRepartidores) {
        this.listRepartidores = listRepartidores;
    }

    public List<Envio> getListEnvios() {
        return listEnvios;
    }

    public void setListEnvios(List<Envio> listEnvios) {
        this.listEnvios = listEnvios;
    }

    public static PlataformaLogistica getInstancia() {
        return instancia;
    }

    public static void setInstancia(PlataformaLogistica instancia) {
        PlataformaLogistica.instancia = instancia;
    }

    public List<Usuario> getListUsuarios() {
            return listUsuarios;
    }
    public void setListUsuarios(List<Usuario> listUsuarios) {
            this.listUsuarios = listUsuarios;
    }

    //CRUD ADMIN

    //AGREGAR LIST ADMIN

    public void agregarAdministrador(Administrador administrador) {
            this.listAdministradores.add(administrador);
    }


    //SET ADMIN (ID, nombre, correo, telefono)

    public void setAdministrador(String ID, String nuevoNombre, String Nuevocorreo, String nuevoID, String nuevoTelefono) {
        for (Administrador administrador : listAdministradores) {
            if (administrador.getID().equals(ID)) {

                administrador.setNombre(nuevoNombre);
                administrador.setID(nuevoID);
                administrador.setTelefono(nuevoTelefono);

                System.out.println("Administrador con ID " + ID + " actualizado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un administrador con el ID: " + ID);
    }

    //ELIMINAR ADMIN

    public void eliminarAdministrador(String ID) {
            for (Administrador administrador : listAdministradores) {
                if (administrador.getID().equals(ID)) {
                    listAdministradores.remove(administrador);
                }
            }
    }

    //GET ADMIN

    public Administrador getAdministrador(String ID) {
        for (Administrador administrador : listAdministradores) {
            if (administrador.getID().equals(ID)) {
                System.out.println("Administrador encontrado: " + administrador.getNombre());
                return administrador;
            }
        }
        System.out.println("No se encontró un administrador con el ID: " + ID);
        return null;
    }

    //CRUD REPARTIDOR

    //Agregar LIST REPARTIDOR

    public void agregarRepartidor(Repartidor repartidor) {
            this.listRepartidores.add(repartidor);
    }

    //SET  REPARTIDOR

    public void setRepartidor(String ID, String nuevoNombre, String nuevoID, String nuevoTelefono,
                              DisponibilidadRepartidor disponibilidadRepartidor, String nuevaZonaCobertura) {
        for (Repartidor repartidor : listRepartidores) {
            if (repartidor.getID().equals(ID)) {

                repartidor.setNombre(nuevoNombre);
                repartidor.setID(nuevoID);
                repartidor.setTelefono(nuevoTelefono);
                repartidor.setDisponibilidadRepartidor(disponibilidadRepartidor)    ;
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
                }
            }
    }

    //VISUALIZAR REPARTIDOR

    public Repartidor getRepartidor(String ID) {
        for (Repartidor repartidor : listRepartidores) {
            if (repartidor.getID().equals(ID)) {
                System.out.println("Repartidor encontrado: " + repartidor.getNombre());
                return repartidor;
            }
        }
        System.out.println("No se encontró un repartidor con el ID: " + ID);
        return null;
    }

    //CRUD ENVIOS

    //Agregar envio

    public void agregarEnvio(Envio envio) {
            this.listEnvios.add(envio);
    }

    //eliminar envio de la lista

    public void eliminarEnvio(String ID) {
            for (Envio envio : listEnvios) {
                if(envio.getID().equals(ID)){
                    listEnvios.remove(envio);
                }

            }
    }

    //VISUALZAR ENVIO
    public Envio getEnvio(String ID) {
        for (Envio envio : listEnvios) {
            if (envio.getID().equals(ID)) {
                System.out.println("Envio encontrado: " + envio.toString());
                return envio;
            }
        }
        System.out.println("No se encontró un Envio con el ID: " + ID);
        return null;
    }

    //SETTEAR ENVIO

//CRUD USUARIO

    //AGREGAR LIST ADMIN

    public void agregarUsuario(Usuario usuario ) {
        this.listUsuarios.add(usuario);
    }


    //SET USUARIO (ID, nombre, telefono, edad, correo)

    public void setUsuario(String ID, String nombreCompleto, String telefono, int edad, String correoElectronico) {
        for (Usuario usuario : listUsuarios) {
            if (usuario.getID().equals(ID)) {
                usuario.setNombreCompleto(nombreCompleto);
                usuario.setTelefono(telefono);
                usuario.setEdad(edad);
                usuario.setCorreoElectronico(correoElectronico);

                System.out.println("Administrador con ID " + ID + " actualizado correctamente.");
            }
        }
        System.out.println("No se encontró un administrador con el ID: " + ID);
    }

    //ELIMINAR USUARIO

    public void eliminarUsuario(String ID) {
        for (Usuario usuario : listUsuarios) {
            if (usuario.getID().equals(ID)) {
                listAdministradores.remove(usuario);
            }
        }
    }

    //GET USUARIO

    public Usuario getUsuario(String ID) {
        for (Usuario usuario : listUsuarios) {
            if (usuario.getID().equals(ID)) {
                System.out.println("Administrador encontrado: " + usuario.getNombreCompleto());
                return usuario;
            }
        }
        System.out.println("No se encontró un administrador con el ID: " + ID);
        return null;
    }





    //Asginacion y reasignaion de envios

    public void asignarEnvioAutomatico(String idEnvio) {
        Envio envio = getEnvio(idEnvio);
        if (envio == null) {
            throw new IllegalArgumentException("El envío con ID " + idEnvio + " no existe");
        }

        // Ajusta si tu enum se llama diferente
        if (envio.getEstadoEnvio() != EstadoEnvio.SOLICITADO) {
            throw new IllegalStateException("Solo se pueden asignar envíos en estado SOLICITADO");
        }

        Repartidor elegido = estrategiaAsignacion.asignar(envio, listRepartidores);
        if (elegido == null) {
            throw new IllegalStateException("No hay repartidores disponibles (ACTIVOS)");
        }

        envio.setRepartidor(elegido);
        envio.setEstadoEnvio(EstadoEnvio.ASIGNADO);
    }


    public void reasignarEnvioManualmente(String idEnvio, String idRepartidor) {
        Envio envio = getEnvio(idEnvio);
        Repartidor repartidor = getRepartidor(idRepartidor);

        if (envio == null || repartidor == null) {
            throw new IllegalArgumentException("Envío o repartidor no existen");
        }

        if (repartidor.getDisponibilidadRepartidor() != DisponibilidadRepartidor.ACTIVO) {
            throw new IllegalStateException("El repartidor no está disponible");
        }

        envio.setRepartidor(repartidor);
        envio.setEstadoEnvio(EstadoEnvio.ASIGNADO);
    }



}


