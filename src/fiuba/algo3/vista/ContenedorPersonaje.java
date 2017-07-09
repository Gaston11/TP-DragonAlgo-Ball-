package fiuba.algo3.vista;

import fiuba.algo3.modelo.Personajes.Ubicable;
import fiuba.algo3.modelo.Personajes.Personaje;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Created by noe on 09/07/17.
 */
public class ContenedorPersonaje extends BorderPane {

    private ImageView imagen;
    private Personaje personaje;

    public ContenedorPersonaje(Ubicable ubicable){
        if(ubicable.esUnPersonaje()){
            this.personaje = (Personaje) ubicable;
            Vista vista = new Vista(this.personaje);
            this.imagen = vista.obtenerImagen();
            //this.informacionPersonaje();

        }
    }

    public VBox informacionPersonaje(){
        VBox contenedor = new VBox();

        Label etiquetaVida = new Label();
        etiquetaVida.setText("Vida: "+this.personaje.getVida());
        etiquetaVida.setFont(Font.font("Tahoma", FontWeight.BLACK,18));
        etiquetaVida.setTextFill(Color.DARKRED);

        Label etiquetaKi = new Label();
        etiquetaKi.setText("Ki: "+ this.personaje.getKi());
        etiquetaKi.setFont(Font.font("Tahoma", FontWeight.BLACK,18));
        etiquetaKi.setTextFill(Color.DARKRED);

        contenedor.getChildren().addAll(this.imagen,etiquetaVida,etiquetaKi);
        contenedor.setAlignment(Pos.CENTER_LEFT);
        //this.setRight(contenedor);
        return contenedor;
    }
}
