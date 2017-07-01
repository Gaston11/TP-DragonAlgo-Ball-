package fiuba.algo3.eventos;

import fiuba.algo3.modelo.Juego.Jugador;
import fiuba.algo3.modelo.Juego.JugadorEnemigo;
import fiuba.algo3.modelo.Juego.JugadorZ;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;

    public BotonEntrarEventHandler(Stage stage, Scene proximaEscena, String nombre1, String nombre2) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        Jugador jugadorActual = this.crearJugadorActual(nombre1,nombre2);

    }

    public Jugador crearJugadorActual(String nombre1, String nombre2){
        JugadorZ jugadorZ = new JugadorZ(nombre1);
        JugadorEnemigo jugadorEnemigo = new JugadorEnemigo(nombre2);
        jugadorZ.asignarRival(jugadorEnemigo);
        jugadorEnemigo.asignarRival(jugadorZ);
        return jugadorZ;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaEscena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
    }
}