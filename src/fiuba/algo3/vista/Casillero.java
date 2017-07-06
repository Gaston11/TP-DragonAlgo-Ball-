package fiuba.algo3.vista;


import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.beans.EventHandler;

public class Casillero extends StackPane{
    private int x, y;
    private static final int TAMANIO_CASILLERO = 40;

    private Rectangle borde = new Rectangle(TAMANIO_CASILLERO - 3, TAMANIO_CASILLERO - 3);

    public Casillero(int x, int y){
        this.x = x;
        this.y = y;
        borde.setStroke(Color.LIGHTGRAY);
        this.getChildren().add(borde);
        this.setTranslateX(x * TAMANIO_CASILLERO);
        this.setTranslateY(y * TAMANIO_CASILLERO);

    }

}
