package fiuba.algo3.vista;

import fiuba.algo3.modelo.Personajes.Personaje;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by noe on 08/07/17.
 */
public class Casillero1 extends StackPane {
    int x;
    int y;
    ImageView imagen;


    public Casillero1(int x, int y) {
        this.x = x;
        this.y = y;
        imagen = this.dibujarImagen();

        Rectangle borde = new Rectangle(50, 50,50,50);

        borde.setFill(Color.TRANSPARENT);
        borde.setStroke(Color.BLACK);


        this.getChildren().addAll(borde, imagen);
        //this.getChildren().add(borde);
    }

    public ImageView dibujarImagen(){
        Image imagenCampo = new Image("file:src/fiuba/algo3/vista/imagenes/pasto.jpg");
        ImageView contenedorImage = new ImageView();
        contenedorImage.setFitHeight(50);
        contenedorImage.setFitWidth(50);
        contenedorImage.setImage(imagenCampo);
        contenedorImage.setOpacity(1);
        return contenedorImage;
    }
    public int getFila() {
        return x;
    }

    public int getColumna() {
        return y;
    }

    public void dibujarPersonaje(Personaje personaje) {
        Vista imagen = new Vista(personaje);
        this.imagen = imagen.obtenerImagen();
        //this.imagen = imagen.dibujarPersonaje();
        this.getChildren().add(this.imagen);
    }
}