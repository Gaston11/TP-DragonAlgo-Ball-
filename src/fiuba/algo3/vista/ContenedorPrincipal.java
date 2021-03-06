package fiuba.algo3.vista;

import fiuba.algo3.eventos.*;
import fiuba.algo3.modelo.Juego.Juego;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    Campo campo;
    Juego juego;
    Consola contenedorConsola;

    private static final int TAMANIO_CASILLERO = 40;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private static final int X_CASILLEROS = WIDTH / TAMANIO_CASILLERO;
    private static final int Y_CASILLEROS = HEIGHT / TAMANIO_CASILLERO;


/* aca irian los personajes para ubicarlos en el tablero y pasarselo a la imagen */

    public ContenedorPrincipal(Stage stage, String jZ, String jEnemigo) {

        this.juego = new Juego(jZ, jEnemigo);
        this.setMenu(stage);
        this.modelo = juego;
        campo = new Campo();
        this.setRight(campo.contenedor());
        this.setCenter(campo.contenido(juego.getTablero()));
        this.contenedorConsola = new Consola();
        this.setBotonera();
        //this.setDerecha();
        this.setConsola();
        Controlador.getControlador().setJuego(juego);
        Controlador.getControlador().setContenedor(this);
        this.escribirConsola("Nombre jugador Equipo Z: " + jZ);
        this.escribirConsola("Nombre jugador Equipo Enemigo: " + jEnemigo);
        this.escribirConsola("Turno jugador: " + this.juego.getJugadorActual().getNombre());
    }

    private void setBotonera(){

        Button botonMover = new Button();
        botonMover.setText("Mover");
        BotonMoverEventHandler moverEventHandler = new BotonMoverEventHandler(juego, this);
        botonMover.setOnAction(moverEventHandler);
        Controlador.getControlador().setBotonMover(moverEventHandler);

        Button botonTransformar = new Button();
        botonTransformar.setText("Transformar");
        BotonTransformarEventHandler transformarEventHandler = new BotonTransformarEventHandler(juego);
        botonTransformar.setOnAction(transformarEventHandler);
        Controlador.getControlador().setBotonTransformar(transformarEventHandler);

        Button botonFinalizarTurno = new Button();
        botonFinalizarTurno.setText("Finalizar turno");
        BotonFinalizarTurnoEventHandler finalizarTurnoEventHandler = new BotonFinalizarTurnoEventHandler(this.juego);
        botonFinalizarTurno.setOnAction(finalizarTurnoEventHandler);

        VBox contenedorVertical = new VBox();

        VBox contenedorAtaques = this.menuAtaques();

        contenedorVertical.getChildren().addAll(contenedorAtaques, botonMover, botonTransformar, botonFinalizarTurno);
        contenedorVertical.setSpacing(10);
        this.setLeft(contenedorVertical);
    }

    private VBox menuAtaques(){
        Label etiquetaAtaque = new Label();
        etiquetaAtaque.setText(" Ataques ");
        etiquetaAtaque.setFont(Font.font("Tahoma", FontWeight.BLACK, 20));
        etiquetaAtaque.setTextFill(Color.BLACK);

        Button botonAtaqueBasico = new Button();
        botonAtaqueBasico.setText("Basico");
        BotonAtaqueBasicoEventHandler ataqueBasicoEventHandler = new BotonAtaqueBasicoEventHandler(juego);
        botonAtaqueBasico.setOnAction(ataqueBasicoEventHandler);
        Controlador.getControlador().setBotonAtaqueBasico(ataqueBasicoEventHandler);

        Button botonAtaqueEspecial = new Button();
        botonAtaqueEspecial.setText("Especial");
        BotonAtaqueEspecialEventHandler ataqueEspecialEventHandler = new BotonAtaqueEspecialEventHandler(juego);
        botonAtaqueEspecial.setOnAction(ataqueEspecialEventHandler);
        Controlador.getControlador().setBotonAtaqueEspecial(ataqueEspecialEventHandler);

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

    private void setDerecha(){
        this.informacionEnemigo = new Canvas(200, this.getHeight());
        this.setRight(this.informacionEnemigo);

    }


    private void setConsola() {
        String textoEnConsola = "Turno jugador: " + this.juego.getJugadorActual().getNombre().toString();
        this.contenedorConsola.escribirEnConsola( textoEnConsola );
        this.setBottom(contenedorConsola);
    }

    public void escribirConsola(String texto){
        this.contenedorConsola.escribirEnConsola(texto);
    }

    public void escribirConsola(String texto, Color color){
        this.contenedorConsola.escribirEnConsola(texto, color);
    }

    public void actualizar() {
        this.setCenter(campo.contenido(juego.getTablero()));
        this.setRight(campo.contenedor());
        this.setConsola();
    }

}