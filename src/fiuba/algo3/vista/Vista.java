package fiuba.algo3.vista;

import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Personajes.Ubicable;
import javafx.scene.image.ImageView;

/**
 * Created by noe on 08/07/17.
 */
public class Vista {


    private ImageView ubicableImagen;
    private Ubicable ubicable;

    public Vista(Ubicable personaje){
        this.ubicableImagen = personaje.dibujar();
        this.ubicable = personaje;
    }


    public ImageView obtenerImagen() {
        return this.ubicableImagen;
    }

    public Ubicable getPersonaje(){
        return ubicable;
    }
}
