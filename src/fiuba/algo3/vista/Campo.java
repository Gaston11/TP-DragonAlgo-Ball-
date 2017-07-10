package fiuba.algo3.vista;

import fiuba.algo3.modelo.Componentes.*;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.excepciones.CeldaOcupadaException;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by noe on 02/07/17.
 */
public class Campo extends BorderPane{

    private static int dimension = 10;
    private static ArrayList<Consumible> consumibles;
    private VBox contenedor;

    public Campo(){
        consumibles = new ArrayList<Consumible>();
        consumibles.add(new NubeVoladora());
        consumibles.add(new Semilla());
        consumibles.add(new EsferaDelDragon());
    }

    public Parent contenido(Tablero tablero) {

        contenedor = new VBox();
        Pane root = new Pane();
        root.setPrefSize(400, 400);
        this.generarConsumibles(tablero);

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

    private void generarConsumibles(Tablero tablero) {
        Random numero = new Random();
        for (int i = 0; i< consumibles.size(); i++){
            Coordenada coordenada = new Coordenada(numero.nextInt(tablero.getDimension()-1),numero.nextInt(tablero.getDimension()-1));
            Celda celda = tablero.obtenerCelda(coordenada);
            while (celda!=null) {
                coordenada = new Coordenada(numero.nextInt(tablero.getDimension()-1),numero.nextInt(tablero.getDimension()-1));
                celda = tablero.obtenerCelda(coordenada);

            }
            celda = new Celda(coordenada);
            celda.colocarConsumible(consumibles.get(i));
            tablero.colocarCeldaEnTablero(celda);
            consumibles.remove(i);
        }
    }

    private void dibujarImagen(Casillero1 casillero, Tablero tablero) {

        Coordenada coordenada = new Coordenada(casillero.getFila(), casillero.getColumna());
        Celda celda = new Celda(coordenada);
        if(tablero.celdaOcupada(celda)){
            if (tablero.celdaOcupadaConPersonaje(celda)){
                casillero.dibujarUbicable(tablero.obtenerPersonajeEn(coordenada));
                ContenedorPersonaje contenedorPersonaje = new ContenedorPersonaje(tablero.obtenerPersonajeEn(coordenada));
                contenedor.getChildren().add(contenedorPersonaje.informacionPersonaje());
            }else {
                casillero.dibujarConsumible(tablero.obtenerConsumible(coordenada));
            }

        }

    }

    public VBox contenedor(){
        return contenedor;
    }
}
