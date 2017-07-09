package fiuba.algo3.eventos;

import fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;

    //public BotonEntrarEventHandler(Stage stage, Scene proximaEscena, String nombre1, String nombre2) {
    public BotonEntrarEventHandler(Stage stage, String nombreJugadorZ, String nommbreJugadorEnemigos){
        this.stage = stage;
        this.proximaEscena = proximaEscena;

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, nombreJugadorZ, nommbreJugadorEnemigos);
        this.proximaEscena = new Scene(contenedorPrincipal);

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaEscena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
    }
}