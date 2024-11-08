package co.edu.uniquindio.poo.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import co.edu.uniquindio.poo.model.Empresa;

public class AdminLoginController {
    @FXML
    private TextField cedulaAdminField;
    @FXML
    private PasswordField passwordAdminField;
    @FXML
    private Button btnIngresarAdminLogin;

    private Empresa empresa;

    public AdminLoginController() {
        this.empresa = Empresa.getInstance();
    }

    @FXML
    private void handleAdminLogin() {
        String cedula = cedulaAdminField.getText();
        String password = passwordAdminField.getText();
        
        if (empresa.validarAdministrador(cedula, password)) {
           try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/AdminView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Gestiones Administrador");
            stage.show();
            } catch (Exception e) {
            e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de autenticación");
            alert.setHeaderText("Credenciales incorrectas");
            alert.setContentText("Por favor verifica la cédula y contraseña.");
            alert.showAndWait();
        }
    }

    
}