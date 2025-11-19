package co.edu.uniquindio.poo.plataformalogistica.viewController;

import co.edu.uniquindio.poo.plataformalogistica.controller.UsuarioController;
import co.edu.uniquindio.poo.plataformalogistica.model.PlataformaLogistica;
import co.edu.uniquindio.poo.plataformalogistica.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UsuarioViewController {

    private UsuarioController usuarioController;

    // Toolbar
    @FXML private Label lblNombreUsuario;

    // Perfil
    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtEdad;
    @FXML private TextField txtCorreo;
    @FXML private Label lblErrorPerfil;

    @FXML
    private void initialize() {
        // Por ahora no hacemos nada aquí;
        // esperamos a que nos llamen a inicializarDatos(...)
    }

    /**
     * ESTE es el método que te falta y que llama LoginViewController.
     * Recibe el Usuario que ya obtuvo el Login y arma el UsuarioController.
     */
    public void inicializarDatos(Usuario usuario) {
        PlataformaLogistica plataforma = PlataformaLogistica.getInstancia();
        this.usuarioController = new UsuarioController(plataforma, usuario);
        cargarDatosPerfil();
    }

    private void cargarDatosPerfil() {
        if (usuarioController == null) return;

        txtId.setText(usuarioController.getId());
        txtNombre.setText(usuarioController.getNombreCompleto());
        txtTelefono.setText(usuarioController.getTelefono());
        txtEdad.setText(String.valueOf(usuarioController.getEdad()));
        txtCorreo.setText(usuarioController.getCorreoElectronico());
        lblNombreUsuario.setText(usuarioController.getNombreCompleto());
    }

    @FXML
    private void onGuardarPerfil() {
        lblErrorPerfil.setText("");

        try {
            Integer edad = null;
            if (!txtEdad.getText().isBlank()) {
                edad = Integer.parseInt(txtEdad.getText().trim());
                if (edad < 0) throw new NumberFormatException("Edad negativa");
            }

            usuarioController.actualizarPerfil(
                    txtNombre.getText(),
                    txtTelefono.getText(),
                    edad,
                    txtCorreo.getText()
            );

            lblNombreUsuario.setText(txtNombre.getText().trim());

        } catch (NumberFormatException e) {
            lblErrorPerfil.setText("La edad debe ser un número entero válido.");
        } catch (IllegalArgumentException e) {
            lblErrorPerfil.setText(e.getMessage());
        }
    }

    @FXML
    private void onCerrarSesion() {
        txtId.getScene().getWindow().hide();
    }

    // Placeholders para cuando implementes direcciones / métodos de pago
    @FXML
    private void onAgregarDireccion() {}
    @FXML
    private void onEditarDireccion() {}
    @FXML
    private void onEliminarDireccion() {}
    @FXML
    private void onAgregarMetodoPago() {}
    @FXML
    private void onEliminarMetodoPago() {}
}
