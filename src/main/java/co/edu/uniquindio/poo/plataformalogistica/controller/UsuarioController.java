package co.edu.uniquindio.poo.plataformalogistica.controller;

import co.edu.uniquindio.poo.plataformalogistica.model.PlataformaLogistica;
import co.edu.uniquindio.poo.plataformalogistica.model.Usuario;

public class UsuarioController {

    private final PlataformaLogistica plataforma;
    private final Usuario usuarioActual;

    public UsuarioController(PlataformaLogistica plataforma, Usuario usuarioActual) {
        this.plataforma = plataforma;
        this.usuarioActual = usuarioActual;
    }

    public String getId() { return usuarioActual.getID(); }
    public String getNombreCompleto() { return usuarioActual.getNombreCompleto(); }
    public String getTelefono() { return usuarioActual.getTelefono(); }
    public int getEdad() { return usuarioActual.getEdad(); }
    public String getCorreoElectronico() { return usuarioActual.getCorreoElectronico(); }

    public void actualizarPerfil(String nombre, String telefono, Integer edad, String correo) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (telefono == null || telefono.isBlank()) {
            throw new IllegalArgumentException("El teléfono es obligatorio");
        }
        if (correo == null || correo.isBlank()) {
            throw new IllegalArgumentException("El correo es obligatorio");
        }

        usuarioActual.setNombreCompleto(nombre.trim());
        usuarioActual.setTelefono(telefono.trim());
        usuarioActual.setCorreoElectronico(correo.trim());
        usuarioActual.setEdad(edad != null ? edad : 0);
    }
}
