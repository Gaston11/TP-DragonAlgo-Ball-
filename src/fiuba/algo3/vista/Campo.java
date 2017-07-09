package fiuba.algo3.vista;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import fiuba.algo3.modelo.Personajes.Personaje;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by noe on 02/07/17.
 */
public class Campo extends BorderPane{

    private static int dimension = 10;
    private VBox contenedor;

    public Parent contenido(Tablero tablero) {

        contenedor = new VBox();
        Pane root = new Pane();
        root.setPrefSize(400, 400);

        VBox contenedorFilas = new VBox();
        for (int fil = 0; fil < 10; fil++) {

            HBox contenedorColumnas = new HBox();
            for (int col = 9; col > -1; col--) {

                Casillero1 casillero = new Casillero1(fil, col);
                casillero.setVisible(true);
                casillero.setOpacity(1);

                this.dibujarImagen(casillero, tablero);

                contenedorColumnas.getChildren().add(casillero);
            }
            contenedorFilas.getChildren().add(contenedorColumnas);
        }
        root.getChildren().add(contenedorFilas);


        return root;
    }

    private void dibujarImagen(Casillero1 casillero, Tablero tablero) {

        Coordenada coordenada = new Coordenada(casillero.getFila(), casillero.getColumna());
        Celda celda = new Celda(coordenada);
        if(tablero.celdaOcupada(celda)){
            if(tablero.celdaOcupadaConPersonaje(celda)){
                casillero.dibujarUbicable(tablero.obtenerCelda(celda).getPersonaje());
                ContenedorPersonaje contenedorPersonaje = new ContenedorPersonaje(tablero.obtenerPersonajeEn(coordenada));
                contenedor.getChildren().add(contenedorPersonaje.informacionPersonaje());
            }
            /*else {
                casillero.dibujarConsumible(casillero);
            }*/
        }

    }

    public VBox contenedor(){
        return contenedor;
    }
}
