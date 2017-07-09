package fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Created by Nico on 8/7/2017.
 */
public class Consola extends VBox {

    int maxElements = 6;
    public Consola() {
        super();
        // TODO cambiar por el modelo de Consola...
        Label etiqueta = new Label();
        etiqueta.setText("consola...");
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.YELLOW);


        this.setSpacing(10);
        this.setPadding(new Insets(15));
        this.setStyle("-fx-background-color: black;");

        this.getChildren().add(etiqueta);
    }


    public void escribirEnConsola(String texto){
        Label etiqueta = new Label();
        etiqueta.setText(texto);
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.YELLOW);
        if(this.getChildren().stream().count() >= this.maxElements)
            this.getChildren().remove(0);
        this.getChildren().add(etiqueta);
    }
}
