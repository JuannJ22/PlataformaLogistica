package co.edu.uniquindio.poo.plataformalogistica.viewController;

import co.edu.uniquindio.poo.plataformalogistica.auth.AuthResult;
import co.edu.uniquindio.poo.plataformalogistica.auth.Rol;
import co.edu.uniquindio.poo.plataformalogistica.controller.LoginController;
import co.edu.uniquindio.poo.plataformalogistica.model.Administrador;
import co.edu.uniquindio.poo.plataformalogistica.model.PlataformaLogistica;
import co.edu.uniquindio.poo.plataformalogistica.model.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginViewController {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtContrasena;
    @FXML private Button btnIngresar;
    @FXML private Label lblError;

    private LoginController loginController;

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    @FXML
    private void initialize() {
        lblError.setText("");
        btnIngresar.setOnAction(e -> intentarLogin());
        txtUsuario.setOnAction(e -> intentarLogin());
        txtContrasena.setOnAction(e -> intentarLogin());
    }

    private void intentarLogin() {
        String u = txtUsuario.getText().trim();
        String p = txtContrasena.getText();

        AuthResult res = loginController.login(u, p);
        if (!res.isSuccess()) {
            lblError.setText(res.getMessage());
            return;
        }

        try {
            Stage stage = (Stage) btnIngresar.getScene().getWindow();
            PlataformaLogistica plataforma = PlataformaLogistica.getInstancia();

            if (res.getRol() == Rol.ADMIN) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(
                        "/co/edu/uniquindio/poo/plataformalogistica/administrador.fxml"));
                Scene scene = new Scene(loader.load());

                // Buscar administrador por linkedId y pasarlo al VC
                Administrador admin = plataforma.getAdministrador(res.getLinkedId());
                AdministradorViewController adminVC = loader.getController();
                adminVC.inicializarDatos(admin);

                stage.setTitle("Panel de Administración");
                stage.setScene(scene);
                stage.show();
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(
                        "/co/edu/uniquindio/poo/plataformalogistica/usuarioView.fxml"));
                Scene scene = new Scene(loader.load());

                Usuario usuario = plataforma.getUsuario(res.getLinkedId());
                UsuarioViewController usuarioVC = loader.getController();
                usuarioVC.inicializarDatos(usuario);

                stage.setTitle("Panel de Usuario");
                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception ex) {
            lblError.setText("Error cargando vista: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
