package fiuba.algo3.vista;

import fiuba.algo3.modelo.Juego.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class ContenedorPrincipal extends BorderPane {

    private Juego modelo;
    BarraDeMenu menuBar;
    Canvas canvasCentral;
    Canvas informacionEnemigo;
    VBox contenedorCentral;
    Casillero[][] casilleros;

    private static final int TAMANIO_CASILLERO = 40;
    private static final int ANCHO = 400;
    private static final int ALTO = 400;

    private static final int X_CASILLEROS = ANCHO / TAMANIO_CASILLERO;
    private static final int Y_CASILLEROS = ALTO / TAMANIO_CASILLERO;
    private GridPane grillaCentral;




/* aca irian los personajes para ubicarlos en el tablero y pasarselo a la imagen */

    public ContenedorPrincipal(Stage stage, Juego juego) {

        this.setMenu(stage);
        this.modelo = juego;
        this.setCentro();
        this.setConsola();
        this.setBotonera();
        this.setDerecha();
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


    /*private void setCentro() {
        canvasCentral = new Canvas(400, 400);
        //vistaRobot = new VistaRobot(robot, canvasCentral);
        //vistaRobot.dibujar();
        //AnchorPane centro = new AnchorPane();
        Pane centro2 = new Pane();
        GridPane centro3 = new GridPane();
        centro2.setPrefSize(ANCHO, ALTO);
        this.casilleros = new Casillero[X_CASILLEROS][Y_CASILLEROS];
        Image imagen = new Image("file:res/imagenes/pasto.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(50, 50, true, true, true, false);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);

        for (int y = 0; y < Y_CASILLEROS; y++) {
            for (int x = 0; x < X_CASILLEROS; x++) {
                Casillero casillero = new Casillero(x, y);
                //casillero.setBackground(new Background(imagenDeFondo));
                casillero.cambiarImagen(imagen);
                casilleros[x][y] = casillero;

                centro2.getChildren().add(casillero);
                centro3.add(casillero, y, x);
            }
        }
       contenedorCentral = new VBox(canvasCentral);
//        contenedorCentral.setAlignment(Pos.CENTER);
//        contenedorCentral.setSpacing(20);
//        contenedorCentral.setPadding(new Insets(25));
        //Image imagen = new Image("file:res/imagenes/pasto.png");
        //ImageView imagenView = new ImageView(imagen);
        //imagenView.setFitHeight(ALTO);
        //imagenView.setFitWidth(ANCHO);
        //BackgroundSize backgroundSize = new BackgroundSize(centro.getWidth(), centro.getHeight(), true, true, true, false);
        //BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        //centro2.setBackground(new Background(imagenDeFondo));

        //centro.getChildren().add(centro2);
        //centro.setCenterShape(true);
        this.contenedorCentral.getChildren().add(centro2);
        this.setCenter(this.contenedorCentral);
        //this.setCenter(centro2);
    }*/

    private void setCentro() {
        this.grillaCentral = new GridPane();
        this.grillaCentral.setHgap(0);
        this.grillaCentral.setVgap(0);
        this.casilleros = new Casillero[10][10];
        Image imagenPasto = new Image("file:res/imagenes/pasto.jpg");

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                Casillero casillero = new Casillero(i,j);
                //casillero.cambiarImagen(imagenPasto);
                //casillero.ajustarTamanio(20);
                casillero.setearImagen(imagenPasto, 70, 70, true);
                this.casilleros[i][j] = casillero;

                this.grillaCentral.add(casillero, i, j);
            }
        }

        this.setCenter(this.grillaCentral);
    }

    private void setDerecha(){
        VBox informacionEnemigo = new VBox(20);
            this.setRight(this.informacionEnemigo);
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
}

//aca habria que mandar los personajes y moverlos segun requisitos del jugador


