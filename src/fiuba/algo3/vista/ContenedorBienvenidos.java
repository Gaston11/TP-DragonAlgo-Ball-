package fiuba.algo3.vista;

import fiuba.algo3.eventos.BotonEntrarEventHandler;
import fiuba.algo3.modelo.Juego.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorBienvenidos extends VBox {

    Stage stage;
    Juego juego;

    public ContenedorBienvenidos(Stage stage) {

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        Image imagen = new Image("file:src/fiuba/algo3/vista/imagenes/portada.png");
        BackgroundSize backgroundSize = new BackgroundSize(200, 200, true, true, true, false);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        this.setBackground(new Background(imagenDeFondo));

        Button botonEntrar = new Button();
        botonEntrar.setText("Entrar");

        Label etiquetaJugadorZ = new Label();
        etiquetaJugadorZ.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 18));
        etiquetaJugadorZ.setTextFill(Color.DARKRED);
        etiquetaJugadorZ.setText("Jugador Z :            ");
        TextField texto = new TextField();

        HBox layout = new HBox();
        layout.getChildren().addAll( etiquetaJugadorZ, texto);

        Label etiquetaJugadorEnemigo = new Label();
        etiquetaJugadorEnemigo.setFont(Font.font("Tahoma", FontWeight.BLACK, 18));
        etiquetaJugadorEnemigo.setText("Jugador Enemigo: ");
        etiquetaJugadorEnemigo.setTextFill(Color.DARKRED);
        TextField texto2 = new TextField();

        HBox layout2 = new HBox();
        layout2.getChildren().addAll( etiquetaJugadorEnemigo, texto2);

        BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage, texto.getText(), texto2.getText());
        botonEntrar.setOnAction(botonEntrarHandler);

        this.getChildren().addAll(layout, layout2, botonEntrar );
    }

}