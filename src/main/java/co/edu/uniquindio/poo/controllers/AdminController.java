package co.edu.uniquindio.poo.controllers;

import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.TipoCaja;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AdminController {
    @FXML
    private VBox contenedorCampos;

    private Empresa empresa = Empresa.getInstance();  // Usamos la instancia de la empresa

    @FXML
    private void mostrarCamposCarro() {
        contenedorCampos.getChildren().clear();
        contenedorCampos.getChildren().addAll(
            new TextField("Marca"),
            new TextField("Modelo"),
            new TextField("Año"),
            new TextField("Placa"),
            new TextField("Puertas")
        );
    }

    @FXML
    private void mostrarCamposCamion() {
        contenedorCampos.getChildren().clear();
        contenedorCampos.getChildren().addAll(
            new TextField("Marca"),
            new TextField("Modelo"),
            new TextField("Año"),
            new TextField("Placa"),
            new TextField("Capacidad (Kilos)")
        );
    }

    @FXML
    private void mostrarCamposMoto() {
        contenedorCampos.getChildren().clear();
        
        // Añadimos un ComboBox para la transmisión (Automática o Manual)
        ComboBox<TipoCaja> comboTransmision = new ComboBox<>();
        comboTransmision.getItems().addAll(TipoCaja.AUTOMATICA, TipoCaja.MANUAL);
        comboTransmision.getSelectionModel().selectFirst();

        contenedorCampos.getChildren().addAll(
            new TextField("Marca"),
            new TextField("Modelo"),
            new TextField("Año"),
            new TextField("Placa"),
            comboTransmision
        );
    }

    @FXML
    private void guardarVehiculo() {
        // Recoger los datos de los campos
        String marca = ((TextField) contenedorCampos.getChildren().get(0)).getText();
        String modelo = ((TextField) contenedorCampos.getChildren().get(1)).getText();
        String placa = ((TextField) contenedorCampos.getChildren().get(3)).getText();
        
        Vehiculo nuevoVehiculo = null;

        if (contenedorCampos.getChildren().get(4) instanceof TextField) {
            // Caso Auto
            String puertasStr = ((TextField) contenedorCampos.getChildren().get(4)).getText();
            byte puertas = Byte.parseByte(puertasStr);
            nuevoVehiculo = new Auto(placa, marca, modelo, puertas);
        } else if (contenedorCampos.getChildren().get(4) instanceof TextField) {
            // Caso Camioneta
            String capacidadStr = ((TextField) contenedorCampos.getChildren().get(4)).getText();
            double capacidad = Double.parseDouble(capacidadStr);
            nuevoVehiculo = new Camioneta(placa, marca, modelo, capacidad);
        } else if (contenedorCampos.getChildren().get(4) instanceof ComboBox) {
            // Caso Moto
            ComboBox<TipoCaja> comboTransmision = (ComboBox<TipoCaja>) contenedorCampos.getChildren().get(4);
            TipoCaja transmision = comboTransmision.getValue();
            nuevoVehiculo = new Moto(placa, marca, modelo, transmision);
        }

        // Guardar el vehículo en la empresa
        if (nuevoVehiculo != null) {
            String mensaje = empresa.crearVehiculo(nuevoVehiculo);
            // Mostrar mensaje de éxito
            System.out.println(mensaje); 
            
        }
    }
    
}

