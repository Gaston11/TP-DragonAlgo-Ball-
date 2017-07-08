package fiuba.algo3.vista;

import fiuba.algo3.modelo.Personajes.Personaje;
import javafx.scene.image.ImageView;

/**
 * Created by noe on 08/07/17.
 */
public class Vista {


    private ImageView personaje;

    public Vista(Personaje personaje){
        this.personaje = personaje.dibujar();
    }


    public ImageView obtenerImagen() {
        return this.personaje;
    }
}
