package co.edu.uniquindio.poo.plataformalogistica;

import co.edu.uniquindio.poo.plataformalogistica.auth.AuthService;
import co.edu.uniquindio.poo.plataformalogistica.auth.InMemoryAuthRepository;
import co.edu.uniquindio.poo.plataformalogistica.auth.PasswordEncoder;
import co.edu.uniquindio.poo.plataformalogistica.auth.Sha256PasswordEncoder;
import co.edu.uniquindio.poo.plataformalogistica.controller.LoginController;
import co.edu.uniquindio.poo.plataformalogistica.data.DataSeeder;
import co.edu.uniquindio.poo.plataformalogistica.model.PlataformaLogistica;
import co.edu.uniquindio.poo.plataformalogistica.viewController.LoginViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // 1) Singleton de plataforma
        PlataformaLogistica.getInstancia("900123456", "Plataforma Q", "606-1234567");

        // 2) Inicialización de datos
        DataSeeder.seedIfEmpty();

        // 3) Autenticación
        PasswordEncoder encoder = new Sha256PasswordEncoder();
        InMemoryAuthRepository authRepo = DataSeeder.crearAuthRepository(encoder);
        AuthService authService = new AuthService(authRepo, encoder);
        LoginController loginController = new LoginController(authService);

        // 4) Cargar FXML del login
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/co/edu/uniquindio/poo/plataformalogistica/LoginView.fxml")
        );
        Scene scene = new Scene(loader.load());

        // 5) Inyectar el controlador de lógica en el controlador de la vista
        LoginViewController vc = loader.getController();
        vc.setLoginController(loginController);

        // 6) Configurar la ventana
        stage.setTitle("Plataforma de Logística - Inicio de sesión"); // título de la ventana
        stage.setScene(scene);

        // Que se vea grande en la pantalla
        stage.setMaximized(true);
        // (opcional) tamaño mínimo para que no se haga muy pequeña
        stage.setMinWidth(900);
        stage.setMinHeight(600);

        // 7) Mostrar la ventana
        stage.show();
    }
}