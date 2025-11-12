package co.edu.uniquindio.poo.plataformalogistica.model;

import java.util.ArrayList;
import java.util.List;

public class PlataformaLogistica {

        private String nit;
        private String nombre;
        private String telefono;
        private List<Administrador> listAdministradores;
        private List<Repartidor> listRepartidores;
        private List<Envio> listEnvios;


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
            if (Envio.getID().equals(ID)) {
                System.out.println("Envio encontrado: " + Envio.getNombre());
                return Envio;
            }
        }
        System.out.println("No se encontró un Envio con el ID: " + ID);
        return null;
    }

    //SETTEAR ENVIO


}


