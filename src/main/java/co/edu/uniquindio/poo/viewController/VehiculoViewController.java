package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.controller.VehiculoController;
import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class VehiculoViewController {

    private VehiculoController vehiculoController;
    private ObservableList<Vehiculo> listVehiculos = FXCollections.observableArrayList();
    private Vehiculo selectedVehiculo;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNumeroMatricula;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableView<Vehiculo> tblListVehiculo;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnActualizarVehiculo;

    @FXML
    private TableColumn<Vehiculo, String> tbcNumeroMatricula;

    @FXML
    private TextField txtMarca;

    @FXML
    private TableColumn<Vehiculo, String> tbcMarca;

    @FXML
    private Button btnAgregarVehiculo;

    @FXML
    private TableColumn<Vehiculo, String> tbcModelo;

    @FXML
    private TextField txtAñoFabricacion;

    @FXML
    private TableColumn<Vehiculo, String> tbcAñoFabricacion;

    @FXML
    private TextField txtModelo;

    private App app;

    @FXML
    void onAgregarVehiculo() {
        agregarVehiculo();
    }

    @FXML
    void onActualizarVehiculo() {
        actualizarVehiculo();
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    @FXML
    void onEliminar() {
        eliminarVehiculo();
    }

    @FXML
    void initialize() {
        vehiculoController = new VehiculoController(app.consesionario);

        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerVehiculos();
        tblListVehiculo.setItems(listVehiculos);
        listenerSelection();
    }

    private void initDataBinding() {
        tbcNumeroMatricula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumeroMatricula()));
        tbcMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        tbcModelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        tbcAñoFabricacion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAñoFabricacion()));
    }

    private void obtenerVehiculos() {
        listVehiculos.addAll(vehiculoController.obtenerListaVehiculos());
    }

    private void listenerSelection() {
        tblListVehiculo.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedVehiculo = newSelection;
            mostrarInformacionVehiculo(selectedVehiculo);
        });
    }

    private void mostrarInformacionVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null) {
            txtNumeroMatricula.setText(vehiculo.getNumeroMatricula());
            txtMarca.setText(vehiculo.getMarca());
            txtModelo.setText(vehiculo.getModelo());
            txtAñoFabricacion.setText(vehiculo.getAñoFabricacion());
        }
    }

    private void agregarVehiculo() {
        Vehiculo vehiculo = buildVehiculo();
        if (vehiculoController.crearVehiculo(vehiculo)) {
            listVehiculos.add(vehiculo);
            limpiarCamposVehiculo();
        }
    }

    private Vehiculo buildVehiculo() {
        return new Auto(txtNumeroMatricula.getText(), txtMarca.getText(), txtModelo.getText(), txtAñoFabricacion.getText(), 8);
    }

    private void eliminarVehiculo() {
        if (selectedVehiculo != null && vehiculoController.eliminarVehiculo(selectedVehiculo.getNumeroMatricula())) {
            listVehiculos.remove(selectedVehiculo);
            limpiarCamposVehiculo();
            limpiarSeleccion();
        }
    }

    private void actualizarVehiculo() {
        if (selectedVehiculo != null && vehiculoController.actualizarVehiculo(selectedVehiculo.getNumeroMatricula(), buildVehiculo())) {
            int index = listVehiculos.indexOf(selectedVehiculo);
            if (index >= 0) {
                listVehiculos.set(index, buildVehiculo());
            }

            tblListVehiculo.refresh();
            limpiarSeleccion();
            limpiarCamposVehiculo();
        }
    }

    private void limpiarSeleccion() {
        tblListVehiculo.getSelectionModel().clearSelection();
        limpiarCamposVehiculo();
    }

    private void limpiarCamposVehiculo() {
        txtNumeroMatricula.clear();
        txtMarca.clear();
        txtModelo.clear();
        txtAñoFabricacion.clear();
    }

    public void setApp(App app) {
        this.app = app;
    }
}

