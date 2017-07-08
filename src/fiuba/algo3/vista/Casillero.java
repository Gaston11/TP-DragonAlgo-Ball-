package fiuba.algo3.vista;


import fiuba.algo3.modelo.Componentes.Ubicable;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javafx.scene.image.ImageView;

public class Casillero extends StackPane{
    private Ubicable ubicable;
    private int x, y;
    private static final int TAMANIO_CASILLERO = 40;

    private Rectangle borde = new Rectangle(TAMANIO_CASILLERO - 3, TAMANIO_CASILLERO - 3);
    private ImageView imagen;


    public Casillero(int x, int y){
        this.x = x;
        this.y = y;
        this.imagen = new ImageView();
        //borde.setStroke(Color.ALICEBLUE);
        //this.
        //this.setTranslateX(x * TAMANIO_CASILLERO);
        //this.setTranslateY(y * TAMANIO_CASILLERO);
        //this.ubicable = null;
        //this.setVisible(true);
    }

    public void cambiarImagen(Image imagen){
        this.getChildren().remove(this.imagen);
        this.imagen = new ImageView(imagen);
        this.getChildren().add(this.imagen);
    }

    public void ajustarTamanio(double tamanio) {
        this.setMaxSize(tamanio, tamanio);
        this.setPrefHeight(tamanio);
        this.setMaxHeight(tamanio);
    }


    public void setearImagen(Image imagen_nueva, double width, double height, boolean preservratio){
        //boolean remove = this.getChildren().remove(this.imagen);
        this.imagen.setImage(imagen_nueva);
        this.imagen.setFitWidth(width);
        this.imagen.setFitHeight(height);
        this.imagen.setPreserveRatio(preservratio);
        this.imagen.setSmooth(true);
        this.getChildren().add(this.imagen);
    }
}
