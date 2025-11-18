package co.edu.uniquindio.poo.plataformalogistica;


import co.edu.uniquindio.poo.plataformalogistica.model.PlataformaLogistica;
import co.edu.uniquindio.poo.plataformalogistica.viewController.LoginViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // 1) Llamamos nuestro singleton de plataforma
        PlataformaLogistica.getInstancia("900123456", "Plataforma Q", "606-1234567");

        // 2) Inicializacion de datos con el dataseeder
        DataSeeder.seedIfEmpty();

        // 3) Autenticacion
        PasswordEncoder encoder = new Sha256PasswordEncoder();
        InMemoryAuthRepository authRepo = DataSeeder.crearAuthRepository(encoder);
        AuthService authService = new AuthService(authRepo, encoder);
        LoginController loginController = new LoginController(authService);

        // 4) Cargamos el login
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/co/edu/uniquindio/poo/plataformalogistica/view/LoginView.fxml"));
        Scene scene = new Scene(loader.load());

        LoginViewController vc = loader.getController();
        vc.setLoginController(loginController);
    }

}
