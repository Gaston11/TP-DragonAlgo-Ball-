package fiuba.algo3.vista;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ContenedorTablero extends Application {
    private Label etiquetaTexto, etiquetaImagen, etiquetaTextoImagen;
    private Image img;
    @Override
    public void start(Stage ventana)  {
        //Etiqueta solo con texto
        etiquetaTexto = new Label("Etiqueta solo con texto");
        etiquetaTexto.setTooltip(new Tooltip("Una etiqueta con texto..."));
        //Etiqueta con imagen
        img = new Image("file:src/fiuba/algo3/vista/imagenes/gokuNormal.png", false);
        etiquetaImagen = new Label();
        etiquetaImagen.setGraphic(new ImageView(img));
        etiquetaImagen.setTooltip(new Tooltip("Una etiqueta con una imagen..."));
        //Etiqueta con texto e imagen.
        etiquetaTextoImagen = new Label("Etiqueta con texto e imagen");
        etiquetaTextoImagen.setTextAlignment(TextAlignment.CENTER);
        etiquetaTextoImagen.setContentDisplay(ContentDisplay.TOP);
        etiquetaTextoImagen.setGraphicTextGap(1);
        etiquetaTextoImagen.setGraphic(new ImageView(
                new Image("file:src/fiuba/algo3/vista/imagenes/gohan.png")));
        etiquetaTextoImagen.setTooltip(new Tooltip("Tengo texto e imagen!"));
        //Creando el panel y agregando los componentes
        StackPane panel = new StackPane();
        //Alineacion de los componentes en el panel
        StackPane.setAlignment(etiquetaTexto, Pos.TOP_CENTER);
        StackPane.setAlignment(etiquetaImagen, Pos.CENTER_LEFT);
        StackPane.setAlignment(etiquetaTextoImagen, Pos.CENTER_RIGHT);
        //Los agregamos
        panel.getChildren().addAll(etiquetaTexto, etiquetaImagen, etiquetaTextoImagen);
        //Caracteristicas de la escena
        Scene escena = new Scene(panel, 300, 200);
        ventana.setScene(escena);
        ventana.setTitle("Uso de etiquetas");
        //Mostramos la ventana
        ventana.show();
    }
    public static void main(String args[]) {
        Application.launch(args);
    }
}