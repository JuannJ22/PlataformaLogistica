package co.edu.uniquindio.poo.plataformalogistica.model;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlataformaLogisticaTest {

    @Test
    void getInstancia() {
        PlataformaLogistica instancia1 = PlataformaLogistica.getInstancia();
        PlataformaLogistica instancia2 = PlataformaLogistica.getInstancia();
        assertEquals(instancia1, instancia2);
    }

    @Test
    void getNit() {
        PlataformaLogistica plataforma = PlataformaLogistica.getInstancia();
        plataforma.setNit("123");
        assertEquals("123", plataforma.getNit());
    }

    @Test
    void setNit() {
        PlataformaLogistica plataforma = PlataformaLogistica.getInstancia();
        plataforma.setNit("999");
        assertEquals("999", plataforma.getNit());
    }

    @Test
    void getNombre() {
        PlataformaLogistica plataforma = PlataformaLogistica.getInstancia();
        plataforma.setNombre("LOGISTICA");
        assertEquals("LOGISTICA", plataforma.getNombre());
    }

    @Test
    void setNombre() {
        PlataformaLogistica plataforma = PlataformaLogistica.getInstancia();
        plataforma.setNombre("SISTEMA XPRESS");
        assertEquals("SISTEMA XPRESS", plataforma.getNombre());
    }

    @Test
    void getTelefono() {
        PlataformaLogistica plataforma = PlataformaLogistica.getInstancia();
        plataforma.setTelefono("321");
        assertEquals("321", plataforma.getTelefono());
    }

    @Test
    void setTelefono() {
        PlataformaLogistica plataforma = PlataformaLogistica.getInstancia();
        plataforma.setTelefono("555");
        assertEquals("555", plataforma.getTelefono());
    }

    @Test
    void getListAdministradores() {
        PlataformaLogistica plataforma = PlataformaLogistica.getInstancia();
        plataforma.setListAdministradores(new ArrayList<>());
        assertTrue(plataforma.getListAdministradores().isEmpty());
    }

    @Test
    void setListAdministradores() {
        PlataformaLogistica plataforma = PlataformaLogistica.getInstancia();
        ArrayList<Administrador> lista = new ArrayList<>();
        lista.add(new Administrador("1", "Juan", "300", "55555"));
        plataforma.setListAdministradores(lista);
        assertEquals(1, plataforma.getListAdministradores().size());
    }

    @Test
    void getListRepartidores() {
        PlataformaLogistica plataforma = PlataformaLogistica.getInstancia();
        plataforma.setListRepartidores(new ArrayList<>());
        assertTrue(plataforma.getListRepartidores().isEmpty());
    }


    @Test
    void getListEnvios() {
        PlataformaLogistica plataforma = PlataformaLogistica.getInstancia();
        plataforma.setListEnvios(new ArrayList<>());
        assertTrue(plataforma.getListEnvios().isEmpty());
    }

    @Test
    void testGetInstancia() {
        PlataformaLogistica a = PlataformaLogistica.getInstancia();
        PlataformaLogistica b = PlataformaLogistica.getInstancia();
        assertEquals(a, b);
    }

    @Test
    void setInstancia() {
        PlataformaLogistica instancia1 = PlataformaLogistica.getInstancia();
        PlataformaLogistica.setInstancia(instancia1);
        assertEquals(instancia1, PlataformaLogistica.getInstancia());
    }

    @Test
    void getListUsuarios() {
        PlataformaLogistica plataforma = PlataformaLogistica.getInstancia();
        plataforma.setListUsuarios(new ArrayList<>());
        assertTrue(plataforma.getListUsuarios().isEmpty());
    }



    @Test
    void agregarAdministrador() {
        PlataformaLogistica plataforma = PlataformaLogistica.getInstancia();
        plataforma.setListAdministradores(new ArrayList<>());

        Administrador adm = new Administrador("1", "Carlos", "320","222222");
        plataforma.agregarAdministrador(adm);

        assertEquals(1, plataforma.getListAdministradores().size());
    }

    @Test
    void setAdministrador() {
        PlataformaLogistica plataforma = PlataformaLogistica.getInstancia();
        plataforma.setListAdministradores(new ArrayList<>());

        Administrador adm = new Administrador("2", "Maria", "311" , "321123321");
        plataforma.setAdministrador("2", "Laura", "312","22", "333333");

        assertEquals(1, plataforma.getListAdministradores().size());
    }

    @Test
    void eliminarAdministrador() {
        PlataformaLogistica plataforma = PlataformaLogistica.getInstancia();
        plataforma.setListAdministradores(new ArrayList<>());

        Administrador adm = new Administrador("3", "Pedro", "322", "31215121");
        plataforma.agregarAdministrador(adm);

        plataforma.eliminarAdministrador("3");

        assertTrue(plataforma.getListAdministradores().isEmpty());
    }}



