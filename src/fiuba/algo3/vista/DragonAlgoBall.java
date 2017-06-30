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

        //Jugador jugadorActual = new JugadorZ(nombre);

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(primaryStage);
        Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480); //necesito tamanio ?? seria tablero

        //AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        //escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
/* el contenedor ppal seria la eleccion de jugadores y sus equipos
*/
        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(primaryStage, escenaJuego);

        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);

        //stage.setScene(escenaBienvenidos);
        //Scene miEscena = new Scene(root);

        primaryStage.setScene(escenaBienvenidos);
        primaryStage.show();

    }
}
