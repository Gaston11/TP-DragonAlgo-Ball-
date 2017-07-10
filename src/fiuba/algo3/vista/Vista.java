package fiuba.algo3.vista;

//import fiuba.algo3.modelo.Componentes.Ubicable;
import fiuba.algo3.modelo.Personajes.UbicableV2;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by noe on 08/07/17.
 */
public class Vista extends ImageView{


    private ImageView ubicableImagen;
    private UbicableV2 ubicable;

    public Vista(UbicableV2 ubicable){
        this.ubicable = ubicable;
        this.ubicableImagen = this.dibujar();

    }

    public ImageView dibujar() {

        Image imagen = new Image(ubicable.getDireccion());
        ImageView contenedorImagen = new ImageView();
        contenedorImagen.setFitHeight(50);
        contenedorImagen.setFitWidth(50);
        contenedorImagen.setImage(imagen);
        contenedorImagen.setOpacity(1);
        return contenedorImagen;
    }


    public ImageView obtenerImagen() {
        return this.ubicableImagen;
    }

    public UbicableV2 getUbicable(){
        return ubicable;
    }
}
