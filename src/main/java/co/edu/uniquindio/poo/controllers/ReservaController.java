package co.edu.uniquindio.poo.controllers;

import co.edu.uniquindio.poo.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ReservaController {

    // Elementos de la interfaz
    @FXML
    private TextField nombreClienteField;

    @FXML
    private TextField cedulaField;

    @FXML
    private TextField diasField;

    @FXML
    private MenuButton vehiculoMenuButton;

    @FXML
    private MenuItem autoMenuItem;

    @FXML
    private MenuItem camionetaMenuItem;

    @FXML
    private MenuItem motoMenuItem;

    @FXML
    private Button realizarAlquilerButton;

    @FXML
    private TextField costoField;

    @FXML
    private Button adminButton;

    private Empresa empresa; // Empresa donde se gestionarán los vehículos, clientes y reservas
    private Cliente clienteSeleccionado; // Cliente seleccionado
    private Vehiculo vehiculoSeleccionado; // Vehículo seleccionado

    public ReservaController() {
        // Crear una empresa ficticia para demostración (podría ser pasada desde otro controlador)
        empresa = new Empresa("Empresa de Alquiler");
    }

    // Método para inicializar el controlador y configurar las opciones de vehículo
    @FXML
    public void initialize() {
        // Configuración de los ítems del menú
        autoMenuItem.setOnAction(this::handleSeleccionarAuto);
        camionetaMenuItem.setOnAction(this::handleSeleccionarCamioneta);
        motoMenuItem.setOnAction(this::handleSeleccionarMoto);
    }

    // Acción para seleccionar un Auto
    private void handleSeleccionarAuto(ActionEvent event) {
        vehiculoSeleccionado = new Auto("ABC123", "Toyota", "Corolla", (byte) 4); // Datos de ejemplo
        vehiculoMenuButton.setText("Auto - " + vehiculoSeleccionado.getMarca() + " " + vehiculoSeleccionado.getModelo());
    }

    // Acción para seleccionar una Camioneta
    private void handleSeleccionarCamioneta(ActionEvent event) {
        vehiculoSeleccionado = new Camioneta("XYZ456", "Ford", "Ranger", 1200.0); // Datos de ejemplo
        vehiculoMenuButton.setText("Camioneta - " + vehiculoSeleccionado.getMarca() + " " + vehiculoSeleccionado.getModelo());
    }

    // Acción para seleccionar una Moto
    private void handleSeleccionarMoto(ActionEvent event) {
        vehiculoSeleccionado = new Moto("MOTO789", "Honda", "CBR500", TipoCaja.AUTOMATICA); // Datos de ejemplo
        vehiculoMenuButton.setText("Moto - " + vehiculoSeleccionado.getMarca() + " " + vehiculoSeleccionado.getModelo());
    }

    // Acción para realizar el alquiler
    @FXML
    private void handleRealizarAlquiler(ActionEvent event) {
        String nombreCliente = nombreClienteField.getText().trim();
        String cedulaCliente = cedulaField.getText().trim();
        String diasPrestamoText = diasField.getText().trim();

        if (nombreCliente.isEmpty() || cedulaCliente.isEmpty() || diasPrestamoText.isEmpty() || vehiculoSeleccionado == null) {
            mostrarAlerta("Error", "Todos los campos son obligatorios y se debe seleccionar un vehículo.");
            return;
        }

        try {
            int diasPrestamo = Integer.parseInt(diasPrestamoText);

            // Crear cliente si no existe
            clienteSeleccionado = empresa.buscarClientePorCedula(cedulaCliente);
            if (clienteSeleccionado == null) {
                clienteSeleccionado = new Cliente(nombreCliente, cedulaCliente);
                empresa.crearCliente(clienteSeleccionado);
            }

            // Crear y calcular costo de la reserva
            Reserva reserva = new Reserva(diasPrestamo, 50.0, clienteSeleccionado, vehiculoSeleccionado);
            empresa.crearReserva(reserva);

            double costo = vehiculoSeleccionado.calcularReserva(reserva);
            costoField.setText(String.format("%.2f", costo));

            //limpiarCampos();

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El campo de días de préstamo debe ser un número válido.");
        }
    }

    // Método para limpiar campos después de realizar una reserva
    /*private void limpiarCampos() {
        nombreClienteField.clear();
        cedulaField.clear();
        diasField.clear();
        vehiculoMenuButton.setText("Vehículo");
        vehiculoSeleccionado = null;
        costoField.clear();
    }
    
     */

    // Método para mostrar alertas
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void abrirAdminLogin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/AdminLogin.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Inicio Sesion Administrador");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();

    
        }

    }
}