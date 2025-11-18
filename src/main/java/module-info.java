module co.edu.uniquindio.poo.plataformalogistica {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.poo.plataformalogistica to javafx.fxml;
    opens co.edu.uniquindio.poo.plataformalogistica.viewController to javafx.fxml;

    exports co.edu.uniquindio.poo.plataformalogistica;
}