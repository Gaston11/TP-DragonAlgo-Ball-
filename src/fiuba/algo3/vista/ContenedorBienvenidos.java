package fiuba.algo3.vista;

import fiuba.algo3.eventos.BotonEntrarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.awt.*;

import static javafx.scene.layout.BackgroundRepeat.*;

public class ContenedorBienvenidos extends VBox {

    Stage stage;

    public ContenedorBienvenidos(Stage stage, Scene proximaEscena) {

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        Image imagen = new Image("file:src/fiuba/algo3/vista/imagenes/portada.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonEntrar = new Button();
        botonEntrar.setText("Entrar");

        Label etiquetaJugadorZ = new Label();
        etiquetaJugadorZ.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 18));
        etiquetaJugadorZ.setText("Nombre jugador Z :            ");
        TextField texto = new TextField();

        HBox layout = new HBox();
        layout.getChildren().addAll( etiquetaJugadorZ, texto);

        Label etiquetaJugadorEnemigo = new Label();
        etiquetaJugadorEnemigo.setFont(Font.font("Tahoma", FontWeight.BLACK, 18));
        etiquetaJugadorEnemigo.setText("Nombre jugador Enemigo: ");
        TextField texto2 = new TextField();

        HBox layout2 = new HBox();
        layout2.getChildren().addAll( etiquetaJugadorEnemigo, texto2);

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 18));
        etiqueta.setText("Elija jugadores ");

        BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage, proximaEscena, texto.getPromptText(), texto2.getPromptText());
        botonEntrar.setOnAction(botonEntrarHandler);

        this.getChildren().addAll(etiqueta,layout, layout2, botonEntrar );
    }

}
