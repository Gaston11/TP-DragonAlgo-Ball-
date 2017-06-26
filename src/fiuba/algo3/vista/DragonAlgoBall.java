package fiuba.algo3.vista;/**
 * Created by nico on 26/06/17.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DragonAlgoBall extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("DragonAlgoBall - TP2 Algoritmos III. FIUBA");

        Parent root = FXMLLoader.load(getClass().getResource("/vista/EscenaEleccionDeEquipos.fxml"));

        Scene miEscena = new Scene(root);

        primaryStage.setScene(miEscena);
        primaryStage.show();
    }
}
