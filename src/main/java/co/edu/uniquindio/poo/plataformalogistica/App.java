package co.edu.uniquindio.poo.plataformalogistica;

import co.edu.uniquindio.poo.plataformalogistica.data.DataSeeder;
import co.edu.uniquindio.poo.plataformalogistica.model.Administrador;
import co.edu.uniquindio.poo.plataformalogistica.model.PlataformaLogistica;
import co.edu.uniquindio.poo.plataformalogistica.viewController.AdministradorViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Punto de entrada JavaFX. Inicializa el Singleton de la plataforma
 * y carga la vista del Administrador.
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Inicializar el Singleton UNA sola vez
        PlataformaLogistica.getInstancia("900123456", "Plataforma Q", "606-1234567");

        // Cargar datos de demo en un solo lugar
        DataSeeder.seedIfEmpty();

        // Cargar FXML
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/co/edu/uniquindio/poo/plataformalogistica/view/AdministradorView.fxml")
        );
        Scene scene = new Scene(loader.load());

        // Inyectar administrador y arrancar
        AdministradorViewController controller = loader.getController();
        Administrador administrador = new Administrador("ADM-001", "Administrador General",
                "admin@plataforma.com", "3001234567");
        controller.inicializarDatos(administrador);

        stage.setTitle("Panel de Administración - Plataforma de Logística");
        stage.setScene(scene);
        stage.show();
    }
}
