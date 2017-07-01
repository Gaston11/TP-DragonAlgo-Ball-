package fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;

public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
    //VistaRobot vistaRobot;
    Canvas canvasCentral; // que significa ??
    VBox contenedorCentral;
/* aca irian los personajes para ubicarlos en el tablero y pasarselo a la imagen */

    public ContenedorPrincipal(Stage stage ) {

        this.setMenu(stage);
        //this.setCentro(robot);
        //this.setConsola();
        this.setBotonera();

    }

    private HBox elegirPersonaje(){

        javafx.scene.control.Label etiqueta = new javafx.scene.control.Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));;
        etiqueta.setText("Personaje: ");

        javafx.scene.control.TextField nombre = new javafx.scene.control.TextField();

        HBox layout = new HBox();
        layout.getChildren().addAll(etiqueta, nombre);
        return layout;

    }

    private void setBotonera(){

        Button botonArriba = new Button();
        botonArriba.setText("Arriba");

        Button botonAbajo = new Button();
        botonAbajo.setText("Abajo");

        Button botonDerecha = new Button();
        botonDerecha.setText("Derecha");

        Button botonIzquierda = new Button();
        botonIzquierda.setText("Izquierda");

        //HBox contenedorPersonaje = this.elegirPersonaje();
        HBox contenedorHorizontal = new HBox(botonIzquierda, botonDerecha);
        contenedorHorizontal.setAlignment(Pos.CENTER);
        VBox contenedorVertical = new VBox( botonArriba, contenedorHorizontal, botonAbajo);
        contenedorVertical.setAlignment(Pos.CENTER);

        VBox contenedorAtaques = this.menuAtaques();

        contenedorVertical.getChildren().add(contenedorAtaques);
        this.setLeft(contenedorVertical);
    }

    private VBox menuAtaques(){
        Label etiquetaAtaque = new Label();
        etiquetaAtaque.setText(" Ataques ");
        Button botonAtaqueBasico = new Button();
        botonAtaqueBasico.setText("Basico");

        Button botonAtaqueEspecial = new Button();
        botonAtaqueEspecial.setText("Especial");

        VBox contenedor = new VBox( etiquetaAtaque, botonAtaqueBasico,botonAtaqueEspecial);
        contenedor.setSpacing(10);
        contenedor.setAlignment(Pos.CENTER);

        return contenedor;

    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }


    /*
    private void setBotonera(Robot robot) {

        Button botonArriba = new Button();
        botonMover.setText("Arriba");
        BotonMoverHandler moveButtonHandler = new BotonMoverHandler(vistaRobot, robot);
        botonMover.setOnAction(moveButtonHandler);

        Button botonDireccion = new Button();
        botonDireccion.setText("Cambiar direccion");
        BotonDireccionHandler directionButtonHandler = new BotonDireccionHandler(robot);
        botonDireccion.setOnAction(directionButtonHandler);

        VBox contenedorVertical = new VBox(botonMover, botonDireccion);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));

        this.setLeft(contenedorVertical);

    }

    private void setCentro(Robot robot) {

        canvasCentral = new Canvas(460, 220);
        vistaRobot = new VistaRobot(robot, canvasCentral);
        vistaRobot.dibujar();

        contenedorCentral = new VBox(canvasCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));
        Image imagen = new Image("file:src/vista/imagenes/fondo-verde.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));

        this.setCenter(contenedorCentral);
    }

    private void setConsola() {

        // TODO cambiar por el modelo de Consola...
        Label etiqueta = new Label();
        etiqueta.setText("consola...");
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.WHITE);

        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        contenedorConsola.setStyle("-fx-background-color: black;");

        this.setBottom(contenedorConsola);
    }
*/

//aca habria que mandar los personajes y moverlos segun requisitos del jugador
}
