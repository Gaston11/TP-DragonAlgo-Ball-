package fiuba.algo3.vista;/**
 * Created by nico on 26/06/17.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class DragonAlgoBall extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("DragonAlgoBall - TP2 Algoritmos III. FIUBA");


        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos);

        stage.setScene(escenaBienvenidos);
        stage.show();

    }
}