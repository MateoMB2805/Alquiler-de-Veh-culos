package co.edu.uniquindio.poo.app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException{
        try {
            // Carga el archivo FXML de la interfaz
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/ReservaView.fxml"));
            Parent root = loader.load();

            // Configura la escena con el archivo FXML cargado
            Scene scene = new Scene(root);

            // Configura el escenario (Stage)
            primaryStage.setTitle("Sistema de Reservas de Vehículos");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al cargar la vista: " + e.getMessage());
        }
    }

    
    

    public static void main(String[] args) {
        launch(args);
    }
}
