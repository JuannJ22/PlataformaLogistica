package co.edu.uniquindio.poo.plataformalogistica.viewController;

import co.edu.uniquindio.poo.plataformalogistica.controller.AdministradorController;
import co.edu.uniquindio.poo.plataformalogistica.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.util.Optional;

public class AdministradorViewController {

    private AdministradorController adminController;

    // ObservableLists
    private ObservableList<Usuario> usuariosObs;
    private ObservableList<Repartidor> repartidoresObs;
    private ObservableList<Envio> enviosObs;

    // ==== FXML: Usuarios ====
    @FXML private TableView<Usuario> tablaUsuarios;
    @FXML private TableColumn<Usuario, String> colUserId;
    @FXML private TableColumn<Usuario, String> colUserNombre;
    @FXML private TableColumn<Usuario, String> colUserCorreo;
    @FXML private TableColumn<Usuario, String> colUserTelefono;

    // ==== FXML: Repartidores ====
    @FXML private TableView<Repartidor> tablaRepartidores;
    @FXML private TableColumn<Repartidor, String> colRepId;
    @FXML private TableColumn<Repartidor, String> colRepNombre;
    @FXML private TableColumn<Repartidor, String> colRepZona;
    @FXML private TableColumn<Repartidor, String> colRepDisp;

    @FXML private TableView<Repartidor> tablaRepsAsignacion;
    @FXML private TableColumn<Repartidor, String> colRepAsigId;
    @FXML private TableColumn<Repartidor, String> colRepAsigNombre;
    @FXML private TableColumn<Repartidor, String> colRepAsigDisp;

    // ==== FXML: Envíos ====
    @FXML private TableView<Envio> tablaEnvios;
    @FXML private TableColumn<Envio, String> colEnvId;
    @FXML private TableColumn<Envio, String> colEnvEstado;
    @FXML private TableColumn<Envio, String> colEnvRep;

    // ==== FXML: Métricas ====
    @FXML private DatePicker dpDesde;
    @FXML private DatePicker dpHasta;
    @FXML private LineChart<String, Number> chartTiempos;
    @FXML private BarChart<String, Number> chartIngresos;
    @FXML private PieChart chartServiciosAdicionales;
    @FXML private BarChart<String, Number> chartIncidenciasZona;

    @FXML
    public void initialize() {
        configurarColumnas();
    }

    /**
     * Llamar desde el Main después de cargar el FXML.
     */
    public void inicializarDatos(Administrador administrador) {
        this.adminController = new AdministradorController(administrador);

        usuariosObs = FXCollections.observableArrayList(adminController.listarUsuarios());
        repartidoresObs = FXCollections.observableArrayList(adminController.listarRepartidores());
        enviosObs = FXCollections.observableArrayList(adminController.listarEnvios());

        tablaUsuarios.setItems(usuariosObs);
        tablaRepartidores.setItems(repartidoresObs);
        tablaRepsAsignacion.setItems(repartidoresObs);
        tablaEnvios.setItems(enviosObs);
    }

    private void configurarColumnas() {
        // Usuarios
        colUserId.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colUserNombre.setCellValueFactory(new PropertyValueFactory<>("nombreCompleto"));
        colUserCorreo.setCellValueFactory(new PropertyValueFactory<>("correoElectronico"));
        colUserTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        // Repartidores
        colRepId.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colRepNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colRepZona.setCellValueFactory(new PropertyValueFactory<>("zonaCobertura"));
        colRepDisp.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(
                        c.getValue().getDisponibilidadRepartidor().name()
                )
        );

        colRepAsigId.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colRepAsigNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colRepAsigDisp.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(
                        c.getValue().getDisponibilidadRepartidor().name()
                )
        );

        // Envíos
        colEnvId.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colEnvEstado.setCellValueFactory(c ->
                new javafx.beans.property.SimpleStringProperty(
                        c.getValue().getEstadoEnvio().name()
                )
        );
        colEnvRep.setCellValueFactory(c -> {
            Repartidor r = c.getValue().getRepartidor();
            String nombre = (r != null) ? r.getNombre() : "Sin asignar";
            return new javafx.beans.property.SimpleStringProperty(nombre);
        });
    }

    // ========== RF-010: Gestión Usuarios ==========

    @FXML
    private void onCrearUsuario() {
        Usuario nuevo = dialogoUsuario(null);
        if (nuevo != null) {
            adminController.crearUsuario(nuevo);
            refrescarUsuarios();
        }
    }

    @FXML
    private void onEditarUsuario() {
        Usuario seleccionado = tablaUsuarios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Selecciona un usuario.");
            return;
        }
        Usuario modificado = dialogoUsuario(seleccionado);
        if (modificado != null) {
            adminController.actualizarUsuario(modificado);
            refrescarUsuarios();
        }
    }

    @FXML
    private void onEliminarUsuario() {
        Usuario seleccionado = tablaUsuarios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Selecciona un usuario.");
            return;
        }
        if (confirmar("¿Eliminar usuario " + seleccionado.getNombreCompleto() + "?")) {
            adminController.eliminarUsuario(seleccionado);
            refrescarUsuarios();
        }
    }

    private void refrescarUsuarios() {
        usuariosObs.setAll(adminController.listarUsuarios());
        tablaUsuarios.refresh();
    }

    // ========== RF-011: Gestión Repartidores ==========

    @FXML
    private void onCrearRepartidor() {
        Repartidor nuevo = dialogoRepartidor(null);
        if (nuevo != null) {
            adminController.crearRepartidor(nuevo);
            refrescarRepartidores();
        }
    }

    @FXML
    private void onEditarRepartidor() {
        Repartidor seleccionado = tablaRepartidores.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Selecciona un repartidor.");
            return;
        }
        Repartidor modif = dialogoRepartidor(seleccionado);
        if (modif != null) {
            adminController.actualizarRepartidor(modif);
            refrescarRepartidores();
        }
    }

    @FXML
    private void onEliminarRepartidor() {
        Repartidor seleccionado = tablaRepartidores.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Selecciona un repartidor.");
            return;
        }
        if (confirmar("¿Eliminar repartidor " + seleccionado.getNombre() + "?")) {
            adminController.eliminarRepartidor(seleccionado);
            refrescarRepartidores();
        }
    }

    @FXML
    private void onCambiarDisponibilidad() {
        Repartidor seleccionado = tablaRepartidores.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Selecciona un repartidor.");
            return;
        }

        DisponibilidadRepartidor nueva =
                (seleccionado.getDisponibilidadRepartidor() == DisponibilidadRepartidor.ACTIVO)
                        ? DisponibilidadRepartidor.INACTIVO
                        : DisponibilidadRepartidor.ACTIVO;

        adminController.cambiarDisponibilidad(seleccionado, nueva);
        refrescarRepartidores();
    }

    private void refrescarRepartidores() {
        repartidoresObs.setAll(adminController.listarRepartidores());
        tablaRepartidores.refresh();
        tablaRepsAsignacion.refresh();
    }

    // ========== RF-012: Envíos / Asignación / Incidencias / Estado ==========

    @FXML
    private void onAsignarAutomatico() {
        Envio envio = tablaEnvios.getSelectionModel().getSelectedItem();
        if (envio == null) {
            mostrarAlerta("Selecciona un envío.");
            return;
        }

        try {
            adminController.asignarEnvioAutomatico(envio);
            refrescarEnvios();
        } catch (Exception e) {
            mostrarAlerta(e.getMessage());
        }
    }

    @FXML
    private void onAsignarManual() {
        Envio envio = tablaEnvios.getSelectionModel().getSelectedItem();
        Repartidor rep = tablaRepsAsignacion.getSelectionModel().getSelectedItem();

        if (envio == null || rep == null) {
            mostrarAlerta("Selecciona un envío y un repartidor.");
            return;
        }

        try {
            adminController.asignarOReasignarManual(envio, rep);
            refrescarEnvios();
        } catch (Exception e) {
            mostrarAlerta(e.getMessage());
        }
    }

    @FXML
    private void onCambiarEstadoEnvio() {
        Envio envio = tablaEnvios.getSelectionModel().getSelectedItem();
        if (envio == null) {
            mostrarAlerta("Selecciona un envío.");
            return;
        }

        ChoiceDialog<EstadoEnvio> dialog = new ChoiceDialog<>(envio.getEstadoEnvio(), EstadoEnvio.values());
        dialog.setTitle("Cambiar estado");
        dialog.setHeaderText(null);
        dialog.setContentText("Nuevo estado:");

        Optional<EstadoEnvio> result = dialog.showAndWait();
        result.ifPresent(nuevo -> {
            adminController.cambiarEstadoEnvio(envio, nuevo);
            refrescarEnvios();
        });
    }

    @FXML
    private void onRegistrarIncidencia() {
        Envio envio = tablaEnvios.getSelectionModel().getSelectedItem();
        if (envio == null) {
            mostrarAlerta("Selecciona un envío.");
            return;
        }

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Registrar incidencia");
        dialog.setHeaderText("Envío: " + envio.getID());
        dialog.setContentText("Descripción:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(desc -> {
            adminController.registrarIncidencia(envio, desc);
            refrescarEnvios();
        });
    }

    private void refrescarEnvios() {
        enviosObs.setAll(adminController.listarEnvios());
        tablaEnvios.refresh();
    }

    // ========== RF-013 / RF-014: Métricas ==========

    @FXML
    private void onActualizarMetricas() {
        LocalDate desde = dpDesde.getValue();
        LocalDate hasta = dpHasta.getValue();

        if (desde == null || hasta == null) {
            mostrarAlerta("Selecciona el rango de fechas.");
            return;
        }

        // Limpia charts
        chartTiempos.getData().clear();
        chartIngresos.getData().clear();
        chartServiciosAdicionales.getData().clear();
        chartIncidenciasZona.getData().clear();

        // Tiempos promedio
        XYChart.Series<String, Number> serieTiempos = new XYChart.Series<>();
        adminController.tiemposPromedioEntregaPorZona(desde, hasta)
                .forEach((zona, tiempo) ->
                        serieTiempos.getData().add(new XYChart.Data<>(zona, tiempo))
                );
        chartTiempos.getData().add(serieTiempos);

        // Ingresos
        XYChart.Series<String, Number> serieIngresos = new XYChart.Series<>();
        adminController.ingresosPorPeriodo(desde, hasta)
                .forEach((periodo, valor) ->
                        serieIngresos.getData().add(new XYChart.Data<>(periodo, valor))
                );
        chartIngresos.getData().add(serieIngresos);

        // Servicios adicionales
        adminController.serviciosAdicionalesMasUsados(desde, hasta)
                .forEach((servicio, cantidad) ->
                        chartServiciosAdicionales.getData().add(
                                new PieChart.Data(servicio, cantidad)
                        )
                );

        // Incidencias por zona
        XYChart.Series<String, Number> serieIncidencias = new XYChart.Series<>();
        adminController.incidenciasPorZona(desde, hasta)
                .forEach((zona, cant) ->
                        serieIncidencias.getData().add(new XYChart.Data<>(zona, cant))
                );
        chartIncidenciasZona.getData().add(serieIncidencias);
    }

    // ========== Helpers de diálogos ==========

    private Usuario dialogoUsuario(Usuario base) {
        Dialog<Usuario> dialog = new Dialog<>();
        dialog.setTitle(base == null ? "Crear usuario" : "Editar usuario");

        // Campos
        TextField txtId = new TextField(base != null ? base.getID() : "");
        TextField txtNombre = new TextField(base != null ? base.getNombreCompleto() : "");
        TextField txtTelefono = new TextField(base != null ? base.getTelefono() : "");
        TextField txtEdad = new TextField(base != null ? String.valueOf(base.getEdad()) : "");
        TextField txtCorreo = new TextField(base != null ? base.getCorreoElectronico() : "");

        GridPane grid = new GridPane();
        grid.setHgap(10); grid.setVgap(10);
        grid.addRow(0, new Label("ID:"), txtId);
        grid.addRow(1, new Label("Nombre:"), txtNombre);
        grid.addRow(2, new Label("Teléfono:"), txtTelefono);
        grid.addRow(3, new Label("Edad:"), txtEdad);
        grid.addRow(4, new Label("Correo:"), txtCorreo);

        dialog.getDialogPane().setContent(grid);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        dialog.setResultConverter(bt -> {
            if (bt == ButtonType.OK) {
                try {
                    int edad = 0;
                    if (!txtEdad.getText().isBlank()) {
                        edad = Integer.parseInt(txtEdad.getText().trim());
                    }

                    // Usamos el BUILDER
                    Usuario.Builder builder = new Usuario.Builder(
                            txtId.getText().trim(),
                            txtNombre.getText().trim(),
                            txtTelefono.getText().trim()
                    );

                    if (edad > 0) {
                        builder.setEdad(edad);
                    }

                    if (!txtCorreo.getText().isBlank()) {
                        builder.setCorreoElectronico(txtCorreo.getText().trim());
                    }

                    return builder.build();

                } catch (NumberFormatException e) {
                    mostrarAlerta("Edad inválida.");
                    return null;
                }
            }
            return null;
        });

        return dialog.showAndWait().orElse(null);
    }


    private Repartidor dialogoRepartidor(Repartidor base) {
        Dialog<Repartidor> dialog = new Dialog<>();
        dialog.setTitle(base == null ? "Crear repartidor" : "Editar repartidor");

        TextField txtId = new TextField(base != null ? base.getID() : "");
        TextField txtNombre = new TextField(base != null ? base.getNombre() : "");
        TextField txtDocumento = new TextField(base != null ? base.getDocumento() : "");
        TextField txtTelefono = new TextField(base != null ? base.getTelefono() : "");
        TextField txtZona = new TextField(base != null ? base.getZonaCobertura() : "");
        ChoiceBox<DisponibilidadRepartidor> cbDisp = new ChoiceBox<>(
                FXCollections.observableArrayList(DisponibilidadRepartidor.values())
        );
        cbDisp.setValue(base != null ? base.getDisponibilidadRepartidor() : DisponibilidadRepartidor.ACTIVO);

        GridPane grid = new GridPane();
        grid.setHgap(10); grid.setVgap(10);
        grid.addRow(0, new Label("ID:"), txtId);
        grid.addRow(1, new Label("Nombre:"), txtNombre);
        grid.addRow(2, new Label("Documento:"), txtDocumento);
        grid.addRow(3, new Label("Teléfono:"), txtTelefono);
        grid.addRow(4, new Label("Zona:"), txtZona);
        grid.addRow(5, new Label("Disponibilidad:"), cbDisp);

        dialog.getDialogPane().setContent(grid);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        dialog.setResultConverter(bt -> {
            if (bt == ButtonType.OK) {
                // Ajusta al constructor real de Repartidor
                return new Repartidor(
                        txtId.getText().trim(),
                        txtNombre.getText().trim(),
                        txtDocumento.getText().trim(),
                        txtTelefono.getText().trim(),
                        cbDisp.getValue(),
                        txtZona.getText().trim()
                );
            }
            return null;
        });

        Optional<Repartidor> result = dialog.showAndWait();
        return result.orElse(null);
    }

    private void mostrarAlerta(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }

    private boolean confirmar(String msg) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setHeaderText(null);
        a.setContentText(msg);
        Optional<ButtonType> result = a.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }
}
