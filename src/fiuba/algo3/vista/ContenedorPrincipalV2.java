package fiuba.algo3.vista;

import fiuba.algo3.modelo.Juego.Juego;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class ContenedorPrincipalV2 extends BorderPane {
/*
    private final Stage stage;
    private Juego juego;
    private GridPane grillaCentral;
    private Casillero[][] casilleros;

    public ContenedorPrincipalV2(Stage stage, Juego juego) {
        this.stage = stage;
        this.juego = juego;
        this.setCentro();

    }

    private void setCentro() {
        this.grillaCentral = new GridPane();
        this.casilleros = new Casillero[10][10];
        Image imagenPasto = new Image("file:res/imagenes/pasto.jpg");

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                Casillero casillero = new Casillero(i,j);
                casillero.cambiarImagen(imagenPasto);
                this.casilleros[i][j] = casillero;

                this.grillaCentral.add(casillero, j, i);
            }
        }

        this.setCenter(this.grillaCentral);
    }

*/
}
