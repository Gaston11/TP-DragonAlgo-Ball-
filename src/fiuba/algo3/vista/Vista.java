package fiuba.algo3.vista;

//import fiuba.algo3.modelo.Componentes.Ubicable;
import fiuba.algo3.modelo.Personajes.UbicableV2;
import javafx.scene.image.ImageView;

/**
 * Created by noe on 08/07/17.
 */
public class Vista extends ImageView{


    private ImageView ubicableImagen;
    private VistaPersonajes estado;
    private UbicableV2 ubicable;

    public Vista(UbicableV2 personaje){
        this.ubicableImagen = personaje.dibujar();
        this.ubicable = personaje;

    }


    public ImageView obtenerImagen() {
        return this.ubicableImagen;
    }

    public UbicableV2 getUbicable(){
        return ubicable;
    }
}
